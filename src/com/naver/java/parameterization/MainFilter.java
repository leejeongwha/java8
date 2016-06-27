package com.naver.java.parameterization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class MainFilter {

	public static void main(String[] args) {
		List<Apple> inventory = makeDummy(200);

		// 1. 사과를 필터링 해보자
		List<Apple> greenApples = filterApples(inventory, "GREEN", 0, true);
		// print(greenApples);

		List<Apple> bigApples = filterApples(inventory, "", 600, false);
		// print(bigApples);

		// 2. Delegate으로 해결하자
		List<Apple> bigApples1 = filterApples(inventory, new AppleHeavyWeightPredicate());
		// print(bigApples1);

		// 3. 매번 클래스를 생성할 수는 없으니 익명클래스로 해결하자
		List<Apple> bigApples2 = filterApples(inventory, new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				return apple.getWeight() > 800;
			}
		});
		// print(bigApples2);

		// 4. 람다식 사용하자
		List<Apple> bigApples3 = filterApples(inventory, (Apple apple) -> apple.getWeight() > 800);
		// print(bigApples3);

		// 5. 추상화 하여 개선하자
		List<Apple> bigApples4 = filter(inventory, (Apple apple) -> apple.getWeight() > 800);
		print(bigApples4);
	}

	/**
	 * 단순한 사과 필터링 함수
	 * 
	 * @param inventory
	 * @param color
	 * @param weight
	 * @param flag
	 * @return
	 */
	public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
				result.add(apple);
			}
		}

		return result;
	}

	/**
	 * predicate을 사용하여 개선
	 * 
	 * @param inventory
	 * @param p
	 * @return
	 */
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}

		return result;
	}

	/**
	 * 추상화(java.util.function.Predicate 사용)
	 * 
	 * @param list
	 * @param p
	 * @return
	 */
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}

		return result;
	}

	/**
	 * 더미데이터 생성
	 * 
	 * @param count
	 * @return
	 */
	public static List<Apple> makeDummy(int count) {
		String[] colorArray = { "GREEN", "GRAY", "RED", "YELLOW", "BLUE", "ORANGE" };
		List<Apple> inventory = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < count; i++) {
			Apple apple = new Apple();
			apple.setColor(colorArray[random.nextInt(colorArray.length)]);
			apple.setWeight((int) (Math.random() * 1000));
			// System.out.println(apple.toString());
			inventory.add(apple);
		}

		return inventory;
	}

	/**
	 * 출력
	 * 
	 * @param <T>
	 * @param apples
	 */
	public static <T> void print(List<T> t) {
		for (T e : t) {
			System.out.println(e.toString());
		}
	}
}
