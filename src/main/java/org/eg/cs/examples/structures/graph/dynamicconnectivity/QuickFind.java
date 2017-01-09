package org.eg.cs.examples.structures.graph.dynamicconnectivity;

public class QuickFind extends UnionFind {

	public QuickFind(int n) {
		super(n);
	}
	
	public static void main(String[] args) {
		UnionFind unionFind = new QuickFind(10);
		
		unionFind.union(3, 5);
		unionFind.union(4, 5);
		unionFind.union(5, 2);
		unionFind.union(0, 2);
		
		unionFind.printData();
		
		System.out.printf("%s connected(0, 3) = %s \n", unionFind.getClass().getSimpleName(), unionFind.connected(0, 3));
		System.out.printf("%s connected(1, 3) = %s \n", unionFind.getClass().getSimpleName(), unionFind.connected(1, 3));
		System.out.printf("%s connected(4, 3) = %s \n", unionFind.getClass().getSimpleName(), unionFind.connected(4, 3));
		
	}
	
	@Override
	public void union(int p, int q) {
		int pValue = data[p];
		int qValue = data[q];
		
		for (int i = 0; i < data.length; i++) {
			if (data[i] == pValue)
				data[i] = qValue;
		}
	}
	
	@Override
	public boolean connected(int p, int q) {
		return data[p] == data[q];
	}
		
}
