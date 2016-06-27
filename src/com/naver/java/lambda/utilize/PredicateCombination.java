package com.naver.java.lambda.utilize;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.naver.java.parameterization.Apple;
import com.naver.java.parameterization.MainFilter;

public class PredicateCombination {

	public static void main(String[] args) {
		List<Apple> inventory = MainFilter.makeDummy(10);

		inventory.forEach(System.out::println);

		System.out.println("-------------------------------------");

		Predicate<Apple> redApple = (Apple a) -> a.getColor().equals("RED");

		filter(inventory, redApple).forEach(System.out::println);

		System.out.println("-------------------------------------");

		Predicate<Apple> notRedApple = redApple.negate();

		filter(inventory, notRedApple).forEach(System.out::println);

		System.out.println("-------------------------------------");

		Predicate<Apple> notRedAndHeavyApple = notRedApple.and(a -> a.getWeight() > 600);

		filter(inventory, notRedAndHeavyApple).forEach(System.out::println);

		System.out.println("-------------------------------------");

	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}

		return result;
	}
}
