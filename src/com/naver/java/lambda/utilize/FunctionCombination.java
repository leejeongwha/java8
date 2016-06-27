package com.naver.java.lambda.utilize;

import java.util.function.Function;

public class FunctionCombination {

	public static void main(String[] args) {

		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g);

		int result = h.apply(1);

		System.out.println(result);

		Function<Integer, Integer> i = f.compose(g);

		int result2 = i.apply(1);

		System.out.println(result2);

	}

}
