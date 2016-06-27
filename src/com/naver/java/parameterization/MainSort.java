package com.naver.java.parameterization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.naver.java.parameterization.Apple;

public class MainSort {

	public static void main(String[] args) {
		List<Apple> inventory = makeDummy(200);

		// 1. 기존 정렬 방식
		// inventory.sort(new Comparator<Apple>() {
		// public int compare(Apple a1, Apple a2) {
		// return a1.getWeight().compareTo(a2.getWeight());
		// }
		// });
		// print(inventory);

		// 2. 람다 사용
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		print(inventory);

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
