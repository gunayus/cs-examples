package org.eg.cs.examples.utils;

import java.util.Random;

public class Utils {

	public static final int INTEGER_SIZE_IN_BYTES = 4;
	
	public static final Random random = new Random();
	
	
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

	public static void setLast(int[] array, int v) {
		array[array.length-1] = v;
	}
	
	/**
	 * Runtime complexity is O(n)
	 * Spatial complexity is O(n + newSize) which is O(n)
	 * 
	 * @param intArray
	 * @return
	 */
	public static int[] reallocateArray(int[] intArray, int newSize) {
		int[] newArray = new int[newSize];
		int length = Math.min(intArray.length, newSize);
		
		if (newSize > 1 && intArray.length > 1)
			System.arraycopy(intArray, 0, newArray, 0, length);

		return newArray;
	}
	
	public static int randomInt(int bound) {
		return random.nextInt(bound);
	}
}
