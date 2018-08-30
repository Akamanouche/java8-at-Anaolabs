package org.anaolabs.java8.methodref;

import java.util.Arrays;

public class RunSample {

	public static void main(String[] args) {
		sample1();
	}

	private static void sample1() {
		Arrays.stream(new int[] { 10, 2, 15, 50 }).reduce(Math::max);
	}
}
