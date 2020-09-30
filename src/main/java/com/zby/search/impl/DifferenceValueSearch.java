package com.zby.search.impl;

import com.zby.search.Search;

public class DifferenceValueSearch implements Search {
	@Override
	public int search(int[] sortedSource, int searchedValue) {
		return search(sortedSource, searchedValue, 0, sortedSource.length - 1);
	}

	private int search(int[] sortedSource, int searchedValue, int left, int right) {
		if (left > right || searchedValue < sortedSource[left] || searchedValue > sortedSource[right]) {
			return -1;
		}
		int mid = left
				+ (right - left) * (searchedValue - sortedSource[left]) / (sortedSource[right] - sortedSource[left]);
		if (sortedSource[mid] == searchedValue) {
			return mid;
		} else if (sortedSource[mid] > searchedValue) {
			return search(sortedSource, searchedValue, left, mid - 1);
		} else {
			return search(sortedSource, searchedValue, mid + 1, right);
		}
	}
}
