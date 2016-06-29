package com.naver.java.defaultmethod;

public class MainPerson {

	public static void main(String[] args) {
		Person p = new Doctor();
		System.out.println(p.getName());
		System.out.println(p.getJob());

		Person p2 = new Freeter();
		System.out.println(p2.getName());
		System.out.println(p2.getJob());
	}
}
