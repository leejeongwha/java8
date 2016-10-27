package com.naver.java.agent;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class NonblockingMain {

	public static void main(String[] args) {
		ActorSystem actorSystem = ActorSystem.create("TestSystem");
		ActorRef nonblockingActor = actorSystem.actorOf(Props.create(NonblockingActor.class), "nonblockingActor");
		nonblockingActor.tell(10, ActorRef.noSender());
		nonblockingActor.tell("hello", ActorRef.noSender());

	}

}
