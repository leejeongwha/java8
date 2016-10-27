package com.naver.java.start;

import com.naver.java.start.actor.PingActor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {

	/**
	 * 핑퐁액터 데모를 위한 메인 클래스
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ActorSystem actorSystem = ActorSystem.create("TestSystem");
		ActorRef ping = actorSystem.actorOf(Props.create(PingActor.class), "pingActor");
		ping.tell("start", ActorRef.noSender());

	}

}
