package com.naver.java.lambda.utilize;

import java.util.Comparator;
import java.util.List;

import com.naver.java.parameterization.Apple;
import com.naver.java.parameterization.MainFilter;

public class ComparatorCombination {
	public static void main(String[] args) {
		List<Apple> inventory = MainFilter.makeDummy(10);

		Comparator<Apple> c = Comparator.comparing(Apple::getWeight);

		// 정렬
		inventory.sort(c);

		inventory.forEach(System.out::println);

		// 역정렬
		inventory.sort(Comparator.comparing(Apple::getWeight).reversed());

		inventory.forEach(System.out::println);

		// Comparator 연결(무게가 같은 경우 색상으로 정렬)
		inventory.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor));

		inventory.forEach(System.out::println);
	}
}
