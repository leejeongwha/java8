package com.naver.java.stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.naver.java.parameterization.Apple;
import com.naver.java.parameterization.MainFilter;

public class MainSimpleStream {
	public static void main(String[] args) {
		// legacy();
		latest();
	}

	private static void legacy() {
		List<Apple> inventory = MainFilter.makeDummy(10);

		List<Apple> bigApples = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > 500) {
				bigApples.add(apple);
			}
		}

		Collections.sort(bigApples, new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return Integer.compare(o1.getWeight(), o2.getWeight());
			}
		});

		List<String> bigApplesName = new ArrayList<>();
		for (Apple a : bigApples) {
			bigApplesName.add(a.toString());
		}

		bigApplesName.forEach(System.out::println);
	}

	private static void latest() {
		List<Apple> inventory = MainFilter.makeDummy(10);

		List<String> bigApplesName = inventory.stream().filter(a -> a.getWeight() > 500)
				.sorted(comparing(Apple::getWeight)).map(Apple::toString).collect(toList());

		bigApplesName.forEach(System.out::println);
	}
}
