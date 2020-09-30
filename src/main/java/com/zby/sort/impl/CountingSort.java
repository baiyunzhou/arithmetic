package com.zby.sort.impl;

import com.zby.sort.Sort;

public class CountingSort implements Sort {

	@Override
	public int[] sort(int[] source) {
		int minValue = source[0];
		int maxValue = source[0];
		for (int i = 1; i < source.length; i++) {
			if (minValue > source[i]) {
				minValue = source[i];
			}
			if (maxValue < source[i]) {
				maxValue = source[i];
			}
		}
		int[] temp = new int[maxValue - minValue + 1];
		for (int i = 0; i < source.length; i++) {
			temp[source[i] - minValue] += 1;
		}
		int index = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i]; j++) {
				source[index++] = i + minValue;
			}
		}
		return source;
	}

}
