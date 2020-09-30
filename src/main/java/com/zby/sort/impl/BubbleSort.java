package com.zby.sort.impl;

import com.zby.sort.Sort;

public class BubbleSort implements Sort {

	@Override
	public int[] sort(int[] source) {
		for (int i = 0; i < source.length - 1; i++) {
			for (int j = 0; j < source.length - i - 1; j++) {
				if (source[j] > source[j + 1]) {
					int temp = source[j];
					source[j] = source[j + 1];
					source[j + 1] = temp;
				}
			}
		}
		return source;
	}

}
