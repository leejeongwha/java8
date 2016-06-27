package com.naver.java.lambda.functioninterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainPredicate {
	/**
	 * T형식의 객체를 사용하는 boolean 표현식이 필요한 상황에서 사용
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("1", "2", "3", "", "5");

		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();

		List<String> nonEmptyStrings = filter(listOfStrings, nonEmptyStringPredicate);

		for (String target : nonEmptyStrings) {
			System.out.println(target);
		}
	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}

}
