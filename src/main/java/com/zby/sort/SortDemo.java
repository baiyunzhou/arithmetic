package com.zby.sort;

import java.util.Arrays;
import java.util.Random;

import com.zby.sort.impl.BubbleAdvanceSort;
import com.zby.sort.impl.BubbleSort;
import com.zby.sort.impl.CountingSort;
import com.zby.sort.impl.HeapSort;
import com.zby.sort.impl.InsertMoveSort;
import com.zby.sort.impl.InsertSort;
import com.zby.sort.impl.MergeSort;
import com.zby.sort.impl.QuickSort;
import com.zby.sort.impl.SelectSort;
import com.zby.sort.impl.ShellOptimizeSort;
import com.zby.sort.impl.ShellSort;

/**
 * 参考：https://www.cnblogs.com/onepixel/articles/7674659.html
 * 
 * @author zby
 *
 */
public class SortDemo {

	private static final Random random = new Random();
	/**
	 * 待排序数组是否使用随机值
	 */
	private static final boolean RANDOM_VALUE = true;
	/**
	 * 是否打印源数组
	 */
	private static final boolean PRINT_SOURE = false;
	/**
	 * 是否打印排序后的结果
	 */
	private static final boolean PRINT_RESULT = false;
	/**
	 * 排序数组大小
	 */
	private static final int SIZE = 100000;
	/**
	 * 排序数组范围[0,MAX_VALUE]
	 */
	private static final int MAX_VALUE = 1000000;

	private static int[] sortedSource;

	public static void main(String[] args) {
		int[] source = generateArray(SIZE, MAX_VALUE);
		initSortedArray(source);
		if (PRINT_SOURE) {
			System.out.println("source array:" + Arrays.toString(source));
		}
		// 冒泡排序：比较相邻两个元素，选出大的那个，然后继续，直到最后，每次最大的放到最后去
		checkSort(source, new BubbleSort());
		// 冒泡排序：可以提前退出，只有数组有序时效率高:RANDOM_VALUE=false
		checkSort(source, new BubbleAdvanceSort());
		// 选择排序：
		checkSort(source, new SelectSort());
		// 插入排序，元素集中往后copy
		checkSort(source, new InsertSort());
		// 插入排序，元素后移
		checkSort(source, new InsertMoveSort());
		// 希尔排序：为啥比插入还慢啊，循环4层！
		checkSort(source, new ShellSort());
		// 希尔排序：原来是写的有问题
		checkSort(source, new ShellOptimizeSort());
		// 快速排序：通过基准值分区排序，但是对有序数字排序栈深度会等于数组大小，导致java.lang.StackOverflowError
		checkSort(source, new QuickSort());
		// 归并排序：divide and conquer
		checkSort(source, new MergeSort());
		// 堆排序：构建二叉堆
		checkSort(source, new HeapSort());
		// 计数排序
		checkSort(source, new CountingSort());
	}

	/**
	 * 使用JDK的api对数组排序
	 * 
	 * @param source
	 */
	private static void initSortedArray(int[] source) {
		int[] copyArray = copyArray(source);
		Arrays.sort(copyArray);
		sortedSource = copyArray;
	}

	/**
	 * 生成指定大小，指定最大值的数组
	 * 
	 * @param size
	 * @param maxValue
	 * @return
	 */
	public static int[] generateArray(int size, int maxValue) {
		int[] source = new int[size];
		for (int i = 0; i < size; i++) {
			if (RANDOM_VALUE) {
				source[i] = random.nextInt(maxValue);
			} else {
				source[i] = i;
			}
		}
		return source;
	}

	/**
	 * 复制给定源数组
	 * 
	 * @param source
	 * @return
	 */
	public static int[] copyArray(int[] source) {
		int[] copyed = new int[source.length];
		System.arraycopy(source, 0, copyed, 0, source.length);
		return copyed;

	}

	/**
	 * 判断给定的数组是否有序
	 * 
	 * @param sortedArray
	 * @return
	 */
	public static boolean isSorted(int[] sortedArray) {
		for (int i = 0; i < sortedArray.length; i++) {
			if (sortedSource[i] != sortedArray[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 校验排序算法正确性
	 * 
	 * @param source
	 * @param sort
	 */
	public static void checkSort(int[] source, Sort sort) {
		int[] copyArray = copyArray(source);
		long startTime = System.currentTimeMillis();
		int[] sourtedArray = sort.sort(copyArray);
		long endTime = System.currentTimeMillis();
		System.out.println("【" + sort.getClass().getSimpleName() + "】is sorted? " + isSorted(sourtedArray)
				+ ",spend time:【" + (endTime - startTime) + "m】s,sorted size:" + source.length);
		if (PRINT_RESULT) {
			System.out.println(sort.getClass().getSimpleName() + " sorted result:" + Arrays.toString(sourtedArray));
		}
		System.out.println();
	}

}
