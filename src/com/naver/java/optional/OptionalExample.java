package com.naver.java.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		exception();
	}

	public static void wrap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test", new String("test"));

		Object obj = map.get("test1");

		if (obj == null) {
			System.out.println(String.valueOf(false));
		} else {
			System.out.println(obj.toString());
		}

		Optional<Object> value = Optional.ofNullable(map.get("test1"));

		System.out.println(value.isPresent());
	}

	public static void exception() {
		Optional<Integer> result = stringToInt("a");

		System.out.println(result.isPresent());
	}

	public static Optional<Integer> stringToInt(String s) {
		try {
			return Optional.of(Integer.parseInt(s));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}
}
