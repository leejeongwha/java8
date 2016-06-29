package com.naver.java.defaultmethod;

public interface Person {
	String getName();

	default String getJob() {
		return "no job";
	}

}
