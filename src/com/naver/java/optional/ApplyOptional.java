package com.naver.java.optional;

import java.util.Optional;
import java.util.Properties;

public class ApplyOptional {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("a", "5");
		props.setProperty("b", "true");

		int result = readDuration2(props, "a");
		System.out.println(result);

	}

	public static int readDuration(Properties props, String name) {
		String value = props.getProperty(name);
		if (value != null) {
			try {
				int i = Integer.parseInt(value);
				if (i > 0) {
					return i;
				}
			} catch (NumberFormatException e) {
				return 0;
			}
		}

		return 0;
	}

	public static int readDuration2(Properties props, String name) {
		return Optional.ofNullable(props.getProperty(name)).flatMap(ApplyOptional::stringToInt).filter(i -> i > 0)
				.orElse(0);
	}

	public static Optional<Integer> stringToInt(String s) {
		try {
			return Optional.of(Integer.parseInt(s));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}
}
