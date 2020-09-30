package com.zby.sort.impl;

import com.zby.sort.Sort;

public class MergeSort implements Sort {

	@Override
	public int[] sort(int[] source) {
		return mergeSort(source, 0, source.length - 1);
	}

	private int[] mergeSort(int[] source, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			int[] mergeleft = mergeSort(source, left, mid);
			int[] mergeright = mergeSort(source, mid + 1, right);
			return merge(mergeleft, mergeright);
		}
		return new int[] { source[left] };
	}

	private int[] merge(int[] mergeleft, int[] mergeright) {
		int[] newArray = new int[mergeleft.length + mergeright.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int newIndex = 0;
		while (leftIndex < mergeleft.length || rightIndex < mergeright.length) {
			while (leftIndex < mergeleft.length && rightIndex < mergeright.length) {
				newArray[newIndex++] = mergeleft[leftIndex] < mergeright[rightIndex] ? mergeleft[leftIndex++]
						: mergeright[rightIndex++];
			}
			while (leftIndex < mergeleft.length) {
				newArray[newIndex++] = mergeleft[leftIndex++];
			}
			while (rightIndex < mergeright.length) {
				newArray[newIndex++] = mergeright[rightIndex++];
			}
		}
		return newArray;
	}

}
