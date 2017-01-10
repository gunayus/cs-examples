package org.eg.cs.examples.structures.graph.dynamicconnectivity;

/**
 * 4. Quick Union
 * https://www.youtube.com/watch?v=H0bkmI1Xsxg&list=PLe-ggMe31CTexoNYnMhbHaWhQ0dvcy43t&index=4
 * 
 * @author egunay
 *
 */
public class QuickUnion extends UnionFind {

	public QuickUnion(int n) {
		super(n);
	}
	
	public static void main(String[] args) {
		UnionFind unionFind = new QuickUnion(10);
		unionFind.execute();
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
