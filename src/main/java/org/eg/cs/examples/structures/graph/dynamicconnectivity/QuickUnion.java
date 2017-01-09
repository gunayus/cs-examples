package org.eg.cs.examples.structures.graph.dynamicconnectivity;

public class QuickUnion extends UnionFind {

	public QuickUnion(int n) {
		super(n);
	}
	
	public static void main(String[] args) {
		UnionFind unionFind = new QuickUnion(10);
		
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
		data[findRoot(p)] = findRoot(q);
	}
	
	@Override
	public boolean connected(int p, int q) {
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);
		
		return pRoot == qRoot;
	}
	
	private int findRoot(int p) {
		if (data[p] == p)
			return p;
		
		return findRoot(data[p]);
	}
	
}
