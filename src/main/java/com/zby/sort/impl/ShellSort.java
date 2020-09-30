package com.zby.sort.impl;

import com.zby.sort.Sort;

public class ShellSort implements Sort {

	@Override
	public int[] sort(int[] source) {
		// 遍历缩小增量次数
		for (int incr = source.length / 2; incr > 0; incr /= 2) {
			// 遍历0～incr的元素作为开始点
			for (int i = 0; i < incr; i++) {
				// 遍历所有增量元素
				for (int j = i + incr; j < source.length; j += incr) {
					int insertValue = source[j];
					int lastIndex = -1;
					// 遍历增量元素前面的元素，后移
					for (int k = j - incr; k >= 0; k -= incr) {
						if (source[k] > insertValue) {
							source[k + incr] = source[k];
							lastIndex = k;
						}
					}
					if (lastIndex != -1) {
						source[lastIndex] = insertValue;
					}
				}
			}
		}
		return source;
	}

}
