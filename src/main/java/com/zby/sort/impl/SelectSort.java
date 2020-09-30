package com.zby.sort.impl;

import com.zby.sort.Sort;

public class SelectSort implements Sort {

	@Override
	public int[] sort(int[] source) {
		for (int i = 0; i < source.length - 1; i++) {
			int lastIndex = source.length - 1 - i;
			int maxIndex = lastIndex;
			for (int j = lastIndex - 1; j >= 0; j--) {
				if (source[j] > source[maxIndex]) {
					maxIndex = j;
				}
			}
			if (maxIndex != lastIndex) {
				int temp = source[lastIndex];
				source[lastIndex] = source[maxIndex];
				source[maxIndex] = temp;
			}
		}
		return source;
	}

}
