package com.zby.search;

/**
 * 查找算法
 * 
 * @author zby
 *
 */
public interface Search {
	/**
	 * 
	 * @param sortedSource  排好序的数组
	 * @param searchedValue 被查找的值
	 * @return
	 */
	int search(int[] sortedSource, int searchedValue);
}
