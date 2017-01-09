package org.eg.cs.examples.structures.graph.dynamicconnectivity;

abstract public class UnionFind {

	protected int[] data; 
	
	public UnionFind(int n) {
		data = new int[n];
		
		for (int i = 0; i < n; i++)
			data[i] = i;
	}
	
	abstract public void union(int p, int q);
	
	abstract public boolean connected(int p, int q);

	protected void printData() {
		for (int i = 0; i < data.length; i++)
			System.out.print(data[i] + " ");
		
		System.out.println();
	}
}
