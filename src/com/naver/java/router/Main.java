package com.naver.java.router;

import com.naver.java.router.actor.PingActor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 아카의 라우터를 보여주기 위한 메인 클래스
 * 
 * @author NAVER
 *
 */
public class Main {

	public static void main(String[] args) {
		ActorSystem actorSystem = ActorSystem.create("TestSystem");
		ActorRef ping = actorSystem.actorOf(Props.create(PingActor.class), "pingActor");
		ping.tell("start", ActorRef.noSender());

	}

}
