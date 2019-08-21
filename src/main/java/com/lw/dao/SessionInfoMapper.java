package com.lw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lw.model.SessionModel;

public interface SessionInfoMapper {
	
	 public int insert(@Param("sessionId") String sessionId,@Param("session") String session);
	 
	 public int delete(@Param("sessionId")String  sessionId);
	 
	 public int update(@Param("sessionId") String sessionId,@Param("session") String session,@Param("user") String user);
	 
	 public SessionModel load(String sessionId);
	 
	 public List<SessionModel> loadByUserName(@Param("user") String user);

}
