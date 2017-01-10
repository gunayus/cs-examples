package org.eg.cs.examples.structures.graph.dynamicconnectivity;

/**
 * 5. Quick Union Improvements
 * https://www.youtube.com/watch?v=RE-Xho-gwlo&list=PLe-ggMe31CTexoNYnMhbHaWhQ0dvcy43t&index=5
 * 
 * @author egunay
 *
 */
public class WeightedQuickUnion extends UnionFind {

	int[] size;
	
	public WeightedQuickUnion(int n) {
		super(n);
	}
	
	public static void main(String[] args) {
		UnionFind unionFind = new WeightedQuickUnion(10);
		unionFind.execute();
	}

	@Override
	protected void initData(int n) {
		super.initData(n);
		size = new int[n];
	}
	
	@Override
	public void union(int p, int q) {
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);
		
		if (pRoot == qRoot)
			return;
		
		if (size[qRoot] < size[pRoot]) {
			size[pRoot] += size[qRoot];
			data[qRoot] = pRoot;
		} else {
			size[qRoot] += size[pRoot];
			data[pRoot] = qRoot;			
		}
	}
	
	@Override
	public boolean connected(int p, int q) {
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);
		
		return pRoot == qRoot;
	}
	
	private int findRoot(int p) {
        while (p != data[p])
            p = data[p];
		
		return p;
	}
	
}
