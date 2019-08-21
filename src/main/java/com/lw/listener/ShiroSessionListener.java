package com.lw.listener;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * session 的监听器
 *  * @author apple
 *
 */

public class ShiroSessionListener implements SessionListener{
	

	// 在线人数
	private static AtomicInteger num = new AtomicInteger(0);

	private Long end;
	
	
	@Override
	public void onStart(Session session) {
		// TODO Auto-generated method stub
		// 加1
		num.incrementAndGet();
		end = System.currentTimeMillis();
		
	}

	@Override
	public void onStop(Session session) {
		// TODO Auto-generated method stub
		// 减一
		num.decrementAndGet();
	}

	@Override
	public void onExpiration(Session session) {
		// TODO Auto-generated method stub
		// 会话过期
		num.decrementAndGet();
		System.out.println(num);
		System.out.println("session过期时间"+String.valueOf(System.currentTimeMillis()-end));
	}
	
	public AtomicInteger getSessionCount() {
        return num;
    }

}
