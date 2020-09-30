package com.zby.sort.impl;

import com.zby.sort.Sort;

public class QuickSort implements Sort {

	@Override
	public int[] sort(int[] source) {
		quickSort(source, 0, source.length - 1);
		return source;
	}

	private void quickSort(int[] source, int left, int right) {
		if (left < right) {
			int partitionIndex = partition(source, left, right);
			quickSort(source, left, partitionIndex - 1);
			quickSort(source, partitionIndex + 1, right);
		}
	}

	/**
	 * 分区
	 * 
	 * @param source
	 * @param starleftt
	 * @param right
	 * @return
	 */
	private int partition(int[] source, int left, int right) {
		int pivot = left;
		// 记录比pivot小的值的索引
		int index = left + 1;
		for (int i = index; i <= right; i++) {
			// 把比pivot小的交换到index上，原index上的交换到哪个位置去了不关心
			if (source[i] < source[pivot]) {
				int temp = source[i];
				source[i] = source[index];
				source[index] = temp;
				index++;
			}
		}
		int temp = source[pivot];
		source[pivot] = source[index - 1];
		source[index - 1] = temp;
		return index - 1;

	}

	public int[] sort2(int[] source) {
		quickSort2(source, 0, source.length - 1);
		return source;
	}

	private void quickSort2(int[] source, int i, int j) {
		if (i < j) {
			int partitionIndex = partition2(source, i, j);
			quickSort2(source, i, partitionIndex - 1);
			quickSort2(source, partitionIndex + 1, j);
		}
	}

	private int partition2(int[] source, int i, int j) {
		int pivot = i;
		int index = i + 1;
		for (int k = index; k <= j; k++) {
			if (source[k] < source[pivot]) {
				int temp = source[k];
				source[k] = source[pivot];
				source[pivot] = temp;
				index++;
			}
		}
		int temp = source[index - 1];
		source[index - 1] = source[pivot];
		source[pivot] = temp;
		return index - 1;
	}
}
