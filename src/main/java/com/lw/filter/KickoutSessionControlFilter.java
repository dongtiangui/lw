package com.lw.filter;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import com.lw.dao.SessionInfoMapper;
import com.lw.model.AdminUserInfoModel;
import com.lw.model.SessionModel;

import com.lw.utils.SerializableUtils;

/**
 * 并发控制session
 * @author apple
 *
 */

public class KickoutSessionControlFilter extends AccessControlFilter{
	
	@Autowired
    private SessionInfoMapper sessionMapper;

	@Autowired
    private ResourceUrlProvider resourceUrlProvider;
	
	/**  踢出之前登录的/之后登录的用户 默认踢出之前登录的用户 */
    private boolean kickoutAfter = false;
	
    private int maxSession = 1;
    
    private SessionManager sessionManager;
    
    
    public static final String DEFAULT_KICKOUT_CACHE_KEY_PREFIX = "shiro:cache:kickout:";
    private String keyPrefix = DEFAULT_KICKOUT_CACHE_KEY_PREFIX;
    
    
    public void setKickoutUrl(String kickoutUrl) {
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }


    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    /**
	 * 是否允许访问
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 访问错误是否自己处理 如果返回true表示自己不处理且继续拦截器链执行，返回false表示自己已经处理了
	 */

	@SuppressWarnings("unlikely-arg-type")
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Subject subject = getSubject(request, response);
		if (!subject.isAuthenticated() && !subject.isRemembered()) {
			 return true;
		}
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String path = httpServletRequest.getServletPath();
        // 如果是静态文件，则返回true
        if (isStaticFile(path)){
            return true;
        }
		// 拿到当前的会话
        Session session  = subject.getSession();
//        获取当前用户以及sessionId
        String username = ((AdminUserInfoModel) subject.getPrincipal()).getAdminName();
        String sessionId = session.getId().toString();
        
        @SuppressWarnings("unchecked")
		Deque<SessionModel> deque = (Deque<SessionModel>)sessionMapper.loadByUserName(username);
        if(deque == null || deque.size()==0) {
            deque = new LinkedList<SessionModel>();
        }
        // 如果队列里面没有session 且session 没有被提出 则放入队列
        if (!deque.contains(sessionId) && !(session.getAttribute("kickout") == null)) {
			deque.push(sessionMapper.load(sessionId));
		}
        // 如果队列大小超过最大sessin 开始踢人
        
        while (deque.size()>maxSession) {
        	 Serializable kickoutSessionId = null;
        	 // 踢后者
        	 if (kickoutAfter) {
				 kickoutSessionId = deque.getFirst();
				 kickoutSessionId = deque.removeFirst();
			}else {
				kickoutSessionId = deque.removeLast();
			}
        	try {
        		Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
	           	if(kickoutSession != null) {
	                   //设置会话的kickout属性表示踢出了
	                 kickoutSession.setAttribute("kickout", true);
	            } 
			} catch (Exception e) {
				e.printStackTrace();
			}
        	sessionMapper.insert(sessionId, SerializableUtils.serializ(session));
        	if (session.getAttribute("kickout") != null) {
        		try {
					subject.logout();
				} catch (Exception e) {
					// TODO: handle exception
				}
//        		重定向到URL
        		return false;
			}
		}
		return true;
	}

	 private boolean isStaticFile(String path) {
	        String staticUri = resourceUrlProvider.getForLookupPath(path);
	       return staticUri != null;
	 }
}
