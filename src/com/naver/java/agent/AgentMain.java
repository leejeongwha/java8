package com.naver.java.agent;

import com.naver.java.agent.actor.AgentActor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AgentMain {

	public static void main(String[] args) {
		ActorSystem actorSystem = ActorSystem.create("TestSystem");
		ActorRef agentActor = actorSystem.actorOf(Props.create(AgentActor.class), "agentActor");
		agentActor.tell("start", ActorRef.noSender());

	}

}
