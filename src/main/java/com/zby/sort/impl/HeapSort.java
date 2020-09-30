package com.zby.sort.impl;

import com.zby.sort.Sort;

public class HeapSort implements Sort {

	@Override
	public int[] sort(int[] source) {
		for (int i = source.length / 2; i >= 0; i--) {
			heapify(source, i, source.length);
		}
		for (int i = source.length - 1; i >= 0; i--) {
			swap(source, 0, i);
			// 一定不要把i位置的再进行堆化
			heapify(source, 0, i);
		}
		return source;
	}

	private void swap(int[] source, int left, int right) {
		int temp = source[left];
		source[left] = source[right];
		source[right] = temp;
	}

	private void heapify(int[] source, int vertex, int lastIndex) {
		int leftChildIndex = vertex * 2 + 1;
		int rightChildIndex = vertex * 2 + 2;
		int maxIndex = vertex;
		if (leftChildIndex < lastIndex && source[leftChildIndex] > source[maxIndex]) {
			maxIndex = leftChildIndex;
		}
		if (rightChildIndex < lastIndex && source[rightChildIndex] > source[maxIndex]) {
			maxIndex = rightChildIndex;
		}
		if (maxIndex != vertex) {
			swap(source, maxIndex, vertex);
			heapify(source, maxIndex, lastIndex);
		}
	}

}
