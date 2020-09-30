package com.zby.sort.impl;

import com.zby.sort.Sort;

public class InsertMoveSort implements Sort {

	@Override
	public int[] sort(int[] source) {
		for (int i = 1; i < source.length; i++) {
			int insertValue = source[i];
			int insertIndex = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (insertValue >= source[j]) {
					break;
				}
				source[j + 1] = source[j];
				insertIndex = j;
			}
			if (insertIndex != -1) {
				source[insertIndex] = insertValue;
			}
		}
		return source;
	}

}
