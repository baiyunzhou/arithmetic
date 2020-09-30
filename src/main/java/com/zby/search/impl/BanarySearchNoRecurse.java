package com.zby.search.impl;

import com.zby.search.Search;

public class BanarySearchNoRecurse implements Search {

	@Override
	public int search(int[] sortedSource, int searchedValue) {
		int left = 0;
		int right = sortedSource.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (sortedSource[mid] == searchedValue) {
				return mid;
			}
			if (sortedSource[mid] > searchedValue) {
				right = mid - 1;
			}
			if (sortedSource[mid] < searchedValue) {
				left = mid + 1;
			}
		}
		return -1;
	}

}
