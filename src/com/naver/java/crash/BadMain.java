package com.naver.java.crash;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 아카의 Let It Crash 철학을 보여주기 위한 메인 클래스
 * 
 * @author NAVER
 *
 */
public class BadMain {

	public static void main(String[] args) {
		ActorSystem actorSystem = ActorSystem.create("TestSystem");
		ActorRef ping = actorSystem.actorOf(Props.create(PingActor.class), "pingActor");
		ping.tell("bad", ActorRef.noSender());

	}

}
