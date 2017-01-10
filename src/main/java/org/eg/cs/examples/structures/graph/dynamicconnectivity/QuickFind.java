package org.eg.cs.examples.structures.graph.dynamicconnectivity;

/**
 * 3. Quick Find
 * https://www.youtube.com/watch?v=4SZTsQO9d6k&index=3&list=PLe-ggMe31CTexoNYnMhbHaWhQ0dvcy43t
 * 
 * @author egunay
 *
 */
public class QuickFind extends UnionFind {

	public QuickFind(int n) {
		super(n);
	}
	
	public static void main(String[] args) {
		UnionFind unionFind = new QuickFind(10);
		unionFind.execute();
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
