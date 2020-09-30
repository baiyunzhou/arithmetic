package com.zby.search;

import com.zby.search.impl.BanarySearchNoRecurse;
import com.zby.search.impl.BanarySearchRecurse;
import com.zby.search.impl.DifferenceValueSearch;

public class SearchDemo {

	public static void main(String[] args) {
		int[] generateArray = new int[] { -3, -1, 1, 2, 2, 3, 4, 4, 4, 5, 5, 5, 7, 9 };
		Search banarySearchRecurse = new BanarySearchRecurse();
		for (int i = -5; i < 15; i++) {
			System.out.print(i + "=" + banarySearchRecurse.search(generateArray, i) + ",");// -1
		}
		System.out.println();
		Search banarySearchNoRecurse = new BanarySearchNoRecurse();
		for (int i = -5; i < 15; i++) {
			System.out.print(i + "=" + banarySearchNoRecurse.search(generateArray, i) + ",");// -1
		}
		System.out.println();
		Search differenceValueSearch = new DifferenceValueSearch();
		for (int i = -5; i < 15; i++) {
			System.out.print(i + "=" + differenceValueSearch.search(generateArray, i) + ",");// -1
		}
		System.out.println();
	}

}
