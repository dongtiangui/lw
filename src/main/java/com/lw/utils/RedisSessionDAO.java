package com.lw.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lw.dao.SessionInfoMapper;

import com.lw.model.SessionModel;

/**
 * 继承sessiondao 进行session的持久化
 * @author apple
 *
 */

public class RedisSessionDAO extends EnterpriseCacheSessionDAO{
	
	private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

	@Autowired
    private SessionInfoMapper sessionMapper;

	@Override
    public void delete(Session session) {
        //删除session
        try {
        	this.sessionMapper.delete(session.getId().toString());
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
    }
	@Override
    public void update(Session session) throws UnknownSessionException {
        //当是ValidatingSession 无效的情况下，直接退出
        if(session instanceof ValidatingSession && 
                !((ValidatingSession)session).isValid() ) {
            return ;
        }
        //检索到用户名
        String username = String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
        if (username == "") {
			username = null;
		}
        //序列化Session
        this.sessionMapper.update(session.getId().toString(), SerializableUtils.serializ(session),username);
    }

    @Override
    protected Serializable doCreate(Session session) {
    	
        //生成session的id
        Serializable sessionId = generateSessionId(session);
        //给Session设定id
        assignSessionId(session, sessionId);
        //插入session 到数据库
        this.sessionMapper.insert(session.getId().toString(), SerializableUtils.serializ(session));
        return sessionId;
    }

    /**
     * 
     * @param username
     * @return
     */
    
    @Override
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
    	// TODO Auto-generated method stub
    	return super.readSession(sessionId);
    }
    public List<Session> loadByUserName(String username) {
        //获取session的字符串
        List<SessionModel> dbSessions = this.sessionMapper.loadByUserName(username);
        //判断是否存在用户的情况
        if(dbSessions == null || dbSessions.size() == 0) {
            return null;
        }
        List<Session> result = new ArrayList<Session>();
        for(SessionModel session:dbSessions) {
            //加载session数据
            String sessionStr = session.getSession();
            //将Session的数据串，转化为对象
            result.add(SerializableUtils.deserializ(sessionStr));
        }
        return result;
    }
}
