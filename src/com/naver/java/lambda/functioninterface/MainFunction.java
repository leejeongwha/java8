package com.naver.java.lambda.functioninterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MainFunction {

	/**
	 * 입력을 출력으로 매핑하는 람다를 정의할 때 사용
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> lengthList = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());

		// lambda
		lengthList.forEach(item -> System.out.println(item));

		// method reference
		lengthList.stream().forEach(System.out::println);
	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T s : list) {
			result.add(f.apply(s));
		}
		return result;
	}
}
