package org.eg.cs.examples.utils;

import java.util.Random;

public class Utils {

	/**
	 * generates a random int array of given size
	 * 
	 * Runtime complexity : O(n)
	 * Spatial complexity : O(n)
	 * 
	 * @param arraySize
	 * @return
	 */
	public static int[] generateRandomArray(int arraySize, int randomBound) {
		int[] result = new int[arraySize];
		Random random = new Random();
		
		for (int i = 0; i < result.length; i++) 
			result[i] = random.nextInt(randomBound);
		
		return result;
	}
	
	/**
	 * swaps two items in a given array 
	 * 
	 * Runtime complexity : O(1)
	 * Spatial complexity : O(1)
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
