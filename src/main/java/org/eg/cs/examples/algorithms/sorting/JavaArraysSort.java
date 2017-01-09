package org.eg.cs.examples.algorithms.sorting;

import java.util.Arrays;

/**
 *Java default Arrays.sort() Example
 */

public class JavaArraysSort extends AbstractSort {

	public JavaArraysSort(int arraySize, int randomBound) {
		super(arraySize, randomBound);
	}
	
	public static void main(String[] args) {

		new JavaArraysSort(10, 100).execute();
		new JavaArraysSort(100, 1000).execute();
		new JavaArraysSort(1000, 1000).execute();
		new JavaArraysSort(10000, 10000).execute();
		new JavaArraysSort(100000, 100000).execute();
		new JavaArraysSort(200000, 100000).execute();
		new JavaArraysSort(300000, 100000).execute();
		new JavaArraysSort(400000, 100000).execute();
	
	}

	/**
	 * This implementation calls Arrays.sort (default implementation in Java SDK) which calls DualPivotQuickSort
	 * 
	 * Runtime Complexity is O(n log(n))
	 * Spatial Complexity is O(n)
	 * 
	 */	
	public void doSort() {
		Arrays.sort(array);
	}
}
