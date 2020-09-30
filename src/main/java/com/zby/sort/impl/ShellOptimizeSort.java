package com.zby.sort.impl;

import com.zby.sort.Sort;

public class ShellOptimizeSort implements Sort {

	@Override
	public int[] sort(int[] source) {
		for (int incr = source.length / 2; incr > 0; incr /= 2) {
			for (int i = incr; i < source.length; i++) {
				int insertValue = source[i];
				int j = i - incr;
				boolean move = false;
				for (; j >= 0; j -= incr) {
					if (source[j] > insertValue) {
						source[j + incr] = source[j];
						move = true;
					} else {
						break;
					}
				}
				if (move) {
					source[j + incr] = insertValue;
				}
			}
		}
		return source;
	}

}
