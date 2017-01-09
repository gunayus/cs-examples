package org.eg.cs.examples.algorithms.sorting;

import org.eg.cs.examples.utils.Utils;

abstract public class AbstractSort {

	protected int[] array;
	
	protected AbstractSort() {
		this(100, 500);
	}
	
	protected AbstractSort(int arraySize, int randomBound) {
		array = Utils.generateRandomArray(arraySize, randomBound);
	}
	
	/**
	 * abstract method which has to be implemented by sub-classes for actual sorting algorithm implementation
	 */
	abstract public void doSort();
	
	/**
	 * template method for doing internal printing and duration calculations
	 * it actually calls the abstract doSort() method which will implement the algorithm
	 */
	public void execute() {
		long startTime = System.currentTimeMillis();
		
		System.out.println();
		System.out.printf("%s is starting to sort %d items.\n", this.getClass().getSimpleName(), array.length);

		doSort();
		
		long endTime = System.currentTimeMillis();
		System.out.printf("%s finished sorting %d items in %d milliseconds\n", this.getClass().getSimpleName(), array.length, (endTime - startTime));
	}
	
}
