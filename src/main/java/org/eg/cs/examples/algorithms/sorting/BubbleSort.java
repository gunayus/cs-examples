package org.eg.cs.examples.algorithms.sorting;

import org.eg.cs.examples.utils.Utils;

/**
 * Java Bubble Sort Example
 * This Java bubble sort example shows how to sort an array of int using bubble
 * sort algorithm. Bubble sort is the simplest sorting algorithm.
 */
public class BubbleSort extends AbstractSort {

	public BubbleSort(int arraySize, int randomBound) {
		super(arraySize, randomBound);
	}
	
	public static void main(String[] args) {

		new BubbleSort(10, 100).execute();
		new BubbleSort(100, 1000).execute();
		new BubbleSort(1000, 1000).execute();
		new BubbleSort(10000, 10000).execute();
		new BubbleSort(100000, 100000).execute();
		new BubbleSort(200000, 100000).execute();
		new BubbleSort(300000, 100000).execute();
		new BubbleSort(400000, 100000).execute();
	
	}

	/**
	 * In bubble sort, we basically traverse the array from first to
	 * array_length - 1 position and compare the element with the next one.
	 * Element is swapped with the next element if the next element is
	 * greater.
	 *
	 * Bubble sort steps are as follows.
	 *
	 * 1. Compare array[0] & array[1] 2. If array[0] > array [1] swap it. 3.
	 * Compare array[1] & array[2] 4. If array[1] > array[2] swap it. ... 5.
	 * Compare array[n-1] & array[n] 6. if [n-1] > array[n] then swap it.
	 *
	 * After this step we will have largest element at the last index.
	 *
	 * Repeat the same steps for array[1] to array[n-1]
	 * 
	 * Runtime Complexity is O(n^2)
	 * Spatial Complexity is O(n)
	 * 
	 */	
	public void doSort() {
		int n = array.length;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {

				if (array[j - 1] > array[j]) {
					// swap the elements!
					Utils.swap(array, j-1, j);
				}

			}
		}

	}
}
