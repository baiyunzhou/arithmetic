package com.zby.sort.impl;

import com.zby.sort.Sort;

public class InsertSort implements Sort {

	@Override
	public int[] sort(int[] source) {
		for (int i = 1; i < source.length; i++) {
			int curIndex = i;
			int insertIndex = curIndex;
			for (int j = curIndex - 1; j >= 0; j--) {
				if (source[curIndex] >= source[j]) {
					break;
				}
				insertIndex = j;
			}
			if (curIndex == insertIndex) {
				continue;
			}
			int insertValue = source[curIndex];
			System.arraycopy(source, insertIndex, source, insertIndex + 1, curIndex - insertIndex);
			source[insertIndex] = insertValue;
		}
		return source;
	}

}
