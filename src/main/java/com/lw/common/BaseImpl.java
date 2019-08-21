package com.lw.common;

import java.util.ArrayList;
import java.util.List;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.ConcurrentLoginPermission;
import org.apache.ftpserver.usermanager.impl.TransferRatePermission;
import org.apache.ftpserver.usermanager.impl.WritePermission;
import org.springframework.stereotype.Service;

import com.lw.utils.ApplicationUtil;

@Service
public class BaseImpl implements BaseInterface {
	@Override
	public void startFtpServer() {
		try {
			FtpServerFactory ftpServerFactory = new FtpServerFactory();
			BaseUser user = new BaseUser();
			user.setName("admin");
			user.setPassword("admin");
			user.setHomeDirectory(ApplicationUtil.FTP_ROOT);
			List<Authority> authority = new ArrayList<Authority>();
			authority.add(new WritePermission());
			user.setAuthorities(authority);
			ftpServerFactory.getUserManager().save(user);
			FtpServer server = ftpServerFactory.createServer();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
