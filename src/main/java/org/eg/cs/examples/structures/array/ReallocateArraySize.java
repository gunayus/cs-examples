package org.eg.cs.examples.structures.array;

import org.eg.cs.examples.utils.Utils;

public class ReallocateArraySize {

	public static void main(String[] args) {
		
		ReallocateArraySize reallocateArraySize = new ReallocateArraySize();
		
		reallocateArraySize.doubleArraySize(Utils.generateRandomArray(10000, Integer.MAX_VALUE));
		reallocateArraySize.doubleArraySize(Utils.generateRandomArray(100000, Integer.MAX_VALUE));
		reallocateArraySize.doubleArraySize(Utils.generateRandomArray(1000000, Integer.MAX_VALUE));
		reallocateArraySize.doubleArraySize(Utils.generateRandomArray(10000000, Integer.MAX_VALUE));
		reallocateArraySize.doubleArraySize(Utils.generateRandomArray(100000000, Integer.MAX_VALUE));
		reallocateArraySize.doubleArraySize(Utils.generateRandomArray(200000000, Integer.MAX_VALUE));

		
		reallocateArraySize.doubleArraySizeByLoop(Utils.generateRandomArray(10000, Integer.MAX_VALUE));
		reallocateArraySize.doubleArraySizeByLoop(Utils.generateRandomArray(100000, Integer.MAX_VALUE));
		reallocateArraySize.doubleArraySizeByLoop(Utils.generateRandomArray(1000000, Integer.MAX_VALUE));
		reallocateArraySize.doubleArraySizeByLoop(Utils.generateRandomArray(10000000, Integer.MAX_VALUE));
		reallocateArraySize.doubleArraySizeByLoop(Utils.generateRandomArray(100000000, Integer.MAX_VALUE));
		reallocateArraySize.doubleArraySizeByLoop(Utils.generateRandomArray(200000000, Integer.MAX_VALUE));
		
	}
	
	/**
	 * Runtime complexity is O(n)
	 * Spatial complexity is O(n + 2n) which is O(n)
	 * 
	 * @param intArray
	 * @return
	 */
	public int[] doubleArraySize(int[] intArray) {
		long initialMemory = Runtime.getRuntime().totalMemory();

		long startTime = System.currentTimeMillis();
		int[] newArray = new int[intArray.length * 2];
		System.arraycopy(intArray, 0, newArray, 0, intArray.length);		
		long endTime = System.currentTimeMillis();
		
		long finalMemory = Runtime.getRuntime().totalMemory();

		System.out.printf("ReallocateArraySize doubled the arraf of length %d in %d milliseconds. \n", intArray.length, (endTime - startTime));

		System.out.printf("Total memory. initial: %d, final: %d. \n", initialMemory, finalMemory);
		
		return newArray;
	}

	/**
	 * Runtime complexity is O(n)
	 * Spatial complexity is O(n + 2n) which is O(n)
	 * 
	 * @param intArray
	 * @return
	 */
	public int[] doubleArraySizeByLoop(int[] intArray) {
		long initialMemory = Runtime.getRuntime().totalMemory();

		long startTime = System.currentTimeMillis();
		int[] newArray = new int[intArray.length * 2];
		
		for (int i = 0; i < intArray.length; i++)
			newArray[i] = intArray[i];
		
		long endTime = System.currentTimeMillis();
		
		long finalMemory = Runtime.getRuntime().totalMemory();

		System.out.printf("ReallocateArraySize doubled the arraf of length %d in %d milliseconds. \n", intArray.length, (endTime - startTime));

		System.out.printf("Total memory. initial: %d, final: %d. \n", initialMemory, finalMemory);
		
		return newArray;
	}
	
}
