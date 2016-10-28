package com.naver.java.cluster2;

import java.io.IOException;
import java.io.InputStream;

import com.naver.java.cluster.service.PingService;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 백엔드 서비스 역할을 수행하는 PingService 액터를 생성한다
 * 
 * @author NAVER
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("cluster2_application.conf");
		StringBuffer sb = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = systemResourceAsStream.read(b)) != -1;) {
			sb.append(new String(b, 0, n));
		}
		String config = sb.toString();

		Config parseFile = ConfigFactory.parseString(config);

		ActorSystem actorSystem = ActorSystem.create("ClusterSystem", parseFile);
		ActorRef pingService = actorSystem.actorOf(Props.create(PingService.class), "pingService");

	}

}
