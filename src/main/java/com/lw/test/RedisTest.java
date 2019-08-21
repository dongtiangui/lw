package com.lw.test;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.lw.configuration.DynamicDataSource;
import com.lw.dao.AnnounCement;
import com.lw.dao.UserInfoMapper;
import com.lw.model.AnnounCementModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springxml/spring-mybatis.xml")

public class RedisTest {
	
//	@Autowired
//    private RedisUtil redisUtil;
//    @Resource(name="redisTemplate")
//    private RedisTemplate<String, Object> redisTemplate;
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private AnnounCement announCement;
//	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
//	@Autowired 
//	private JmsTemplate jmsTemplate;
//	@Autowired
//	private Destination destination;
	@Test
    public void testSpringRedis() {
		
//		jmsTemplate.send(destination,new MessageCreator() {
//			
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				// TODO Auto-generated method stub
//			
//				  TextMessage textMessage = new ActiveMQTextMessage();
//				  textMessage.setText("发给android");
//				  return textMessage;
//			}
//		});
		
//		PageHelper.startPage(1,10);
		List<AnnounCementModel> uInfoModels = announCement.findAll();
//		
		System.out.println(uInfoModels.toString());
			
		
//		System.out.println(redisUtil.set("123", "123"));
//		
//		Object oredisUtil  = redisUtil.get("123");
//		System.out.println(oredisUtil);
		
			
		String hashAlgorithmName = "MD5";
        String credentials = "123456";
        int hashIterations = 1024;
        Object obj = new SimpleHash(hashAlgorithmName, credentials, ByteSource.Util.bytes("2"), hashIterations);
        System.out.println(obj);
    }
}
