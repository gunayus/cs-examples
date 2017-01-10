package org.eg.cs.examples.structures.graph.dynamicconnectivity;

import org.eg.cs.examples.utils.Utils;

abstract public class UnionFind {

	protected int[] data; 
	
	public UnionFind(int n) {
		initData(n);
	}
	
	abstract public void union(int p, int q);
	
	abstract public boolean connected(int p, int q);

	public void execute() {
		union(3, 5);
		union(4, 5);
		union(5, 2);
		union(0, 2);
		
		printData();
		
		System.out.printf("%s connected(0, 3) = %s \n", getClass().getSimpleName(), connected(0, 3));
		System.out.printf("%s connected(1, 3) = %s \n", getClass().getSimpleName(), connected(1, 3));
		System.out.printf("%s connected(4, 3) = %s \n", getClass().getSimpleName(), connected(4, 3));
		
		assert(connected(0, 3));
		assert(! connected(1, 3));
		assert(connected(4, 3));
		
		testAllNodesConnectedUnion(10);
		testAllNodesConnectedUnion(100);
		testAllNodesConnectedUnion(1000);
		testAllNodesConnectedUnion(10000);
		testAllNodesConnectedUnion(100000);
		
		// the following does not finish in reasonable times in algorithms at complexity >= O(N)
		testAllNodesConnectedUnion(1000000);
		testAllNodesConnectedUnion(10000000);
	}
	
	/**
	 * executes a full graph union test on n number of items.
	 * 
	 * @param n
	 */
	public void testAllNodesConnectedUnion(int n) {
		initData(n);

		long startTime = System.currentTimeMillis();
		
		// setup graph with 3*n unions
		for (int i = 0; i <= 3*n; i++) {
			int p = Utils.randomInt(n);
			int q = Utils.randomInt(n);
			while (p == q) {
				p = Utils.randomInt(n);
				q = Utils.randomInt(n);
			}
			
			union(p, q);
		}

		long endTime = System.currentTimeMillis();
		System.out.printf("%s testAllNodesConnectedUnion for %d nodes finished in %d milliseconds. \n", getClass().getSimpleName(), n, (endTime - startTime));
	}
	
	protected void initData(int n) {
		data = new int[n];
		
		for (int i = 0; i < n; i++)
			data[i] = i;
	}
	
	protected boolean isValid(int p) {
		return (0 <= p)  && (p < data.length);
	}
	
	protected void printData() {
		for (int i = 0; i < data.length; i++)
			System.out.print(data[i] + " ");
		
		System.out.println();
	}
}
