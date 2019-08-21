package com.lw.test;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DelegatingSession;
import org.apache.commons.lang3.SerializationUtils;
import org.msgpack.MessagePack;
import org.msgpack.template.Template;
import org.msgpack.template.Templates;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;


public class MessagePackTest {

	public static void main(String[] args) {
		
		List<String> src = new ArrayList<String>();
		src.add("msgpack");
		src.add("kumofs");
		src.add("viver");
		MessagePack mPack = new MessagePack();
		try {
			byte[] apache = SerializationUtils.serialize(new DelegatingSession(null, null));
			byte[] b = mPack.write(src);
			System.out.println(apache);
			System.out.println(b);
			System.out.println("========");
			List<String> strings = mPack.read(b,Templates.tList(Templates.TString));
			System.out.println(strings.toString());
			List<String> strings2 = SerializationUtils.deserialize(apache);
			System.out.println(strings2.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
