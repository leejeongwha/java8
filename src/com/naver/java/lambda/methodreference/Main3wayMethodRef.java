package com.naver.java.lambda.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main3wayMethodRef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		constructMethodReference();
	}

	/**
	 * Reference to a Static Method
	 */
	public static void staticMethodReference() {
		String number = "1";

		Function<String, Integer> stringToInteger = Integer::parseInt;

		int n = stringToInteger.apply(number);
	}

	/**
	 * Reference to an Instance Method of an Arbitrary Object of a Particular
	 * Type
	 */
	public static void instanceMethodReference() {
		List<String> keywords = Arrays.asList("Apple", "Ananas", "Mango", "Banana", "Beer");

		List<String> uppercaseKeywords = keywords.stream().map(String::toUpperCase).collect(Collectors.toList());

		uppercaseKeywords.forEach(System.out::println);
	}

	/**
	 * Reference to a Constructor
	 */
	public static void constructMethodReference() {
		List<String> names = Arrays.asList("lee", "kim", "jane", "tim");

		// 인수가 많을 경우 BiFunction, TriFunction 활용
		List<Person> persons = map(names, Person::new);

		persons.forEach(System.out::println);

	}

	public static List<Person> map(List<String> list, Function<String, Person> f) {
		List<Person> result = new ArrayList<>();
		for (String s : list) {
			result.add(f.apply(s));
		}
		return result;
	}

}
