package com.naver.java.cluster;

import java.io.IOException;
import java.io.InputStream;

import com.naver.java.cluster.http.HttpActor;
import com.naver.java.cluster.service.PingService;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.FromConfig;

/**
 * 웹서버 역할을 하는 HttpActor와 라우터를 생성한다
 * 
 * @author NAVER
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("cluster_application.conf");
		StringBuffer sb = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = systemResourceAsStream.read(b)) != -1;) {
			sb.append(new String(b, 0, n));
		}
		String config = sb.toString();

		Config parseFile = ConfigFactory.parseString(config);

		ActorSystem actorSystem = ActorSystem.create("ClusterSystem", parseFile);

		ActorRef router = actorSystem.actorOf(Props.create(PingService.class).withRouter(new FromConfig()),
				"serviceRouter");
		ActorRef httpActor = actorSystem.actorOf(Props.create(HttpActor.class, router), "httpActor");

		ActorRef listener = actorSystem.actorOf(Props.create(SimpleClusterListener.class), "listener");

	}
}
