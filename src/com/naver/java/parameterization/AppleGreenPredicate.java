package com.naver.java.parameterization;

import com.naver.java.parameterization.Apple;

public class AppleGreenPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "GREEN".equals(apple.getColor());
	}

}
