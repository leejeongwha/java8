package com.naver.java.parameterization;

import com.naver.java.parameterization.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 600;
	}

}
