package org.eg.cs.examples.structures.graph.dynamicconnectivity;

import org.eg.cs.examples.utils.Utils;

/**
 * 6. Union Find Applications
 * https://www.youtube.com/watch?v=zeF_d5ok_1k&list=PLe-ggMe31CTexoNYnMhbHaWhQ0dvcy43t&index=6
 * 
 * @author egunay
 *
 */
public class PercolationApplication extends WeightedQuickUnionWithPathCompression {

	// number of sites in a raw. data is an NxN grid from 0..N*N-1 
	int N = 0;
	int topLineIndex;
	int bottomLineIndex;
	boolean[] siteStates;
	int openSiteCount = 0;
	
	public PercolationApplication(int N) {
		super(N*N);
		this.N = N;
	}
	
	public static void main(String[] args) {
		PercolationApplication percolationApplication = new PercolationApplication(10);
		
		percolationApplication.tryPercolation();
	}

	private void tryPercolation() {
		int iterationCount = 0;
		
		while (!isPercolated()) {
			iterationCount++;
			
			// find a random closed site
			int p = Utils.randomInt(siteStates.length);
			
			while (siteStates[p]) {
				p = Utils.randomInt(siteStates.length);
			}
			
			siteStates[p] = true;
			openSiteCount++;
			pringGrid();
			
			// check the neighbours and make union with open neighbours
			int[] neighbourSites = new int[] {p-1, p+1, p-N, p+N};
			for (int i = 0; i < neighbourSites.length; i++) {
				int q = neighbourSites[i];
				if (!isValid(q))
					continue;
				
				if (siteStates[q]) {
					union(p, q);
				}
			}
			
			System.out.printf("Iteration# %d, probability: %.2f, openedSite: %d, openSiteCount: %d, isPercolated: %s \n", 
					iterationCount, 
					((float)openSiteCount / siteStates.length), 
					p, 
					openSiteCount, 
					isPercolated());
		}
		
		
	}

	@Override
	protected void initData(int n) {
		this.N = (int) Math.sqrt(n);
		
		super.initData(n+2);
		siteStates = new boolean[n];
		
		topLineIndex = n;
		bottomLineIndex = n+1;
		
		// make virtual unions from topLineIndex to topLine sites 
		for (int i = 0; i < N; i++)
			union(i, topLineIndex);

		// make virtual unions from bottomLineIndex to bottomLine sites
		for (int i = n-N; i < n; i++)
			union(i, bottomLineIndex);
		
		isPercolated();
	}
	
	@Override
	protected boolean isValid(int p) {
		return (0 <= p) && (p < N*N);
	}
	
	public boolean isPercolated() {
		return connected(topLineIndex, bottomLineIndex);
	}
	
	private void pringGrid() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print((siteStates[i*N + j] ? "W" : "B") + " ");
			
			System.out.println();
		}
	}
}
