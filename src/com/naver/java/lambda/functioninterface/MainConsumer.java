package com.naver.java.lambda.functioninterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MainConsumer {

	/**
	 * T 형식의 객체를 인수로 받아서 어떤 동작을 수행하고 싶을 때
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));

	}

	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T i : list) {
			c.accept(i);
		}
	}
}
