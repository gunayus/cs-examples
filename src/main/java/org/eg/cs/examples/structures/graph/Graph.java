package org.eg.cs.examples.structures.graph;

abstract public class Graph {
	
	public Graph() {
	}
	
	abstract public void addEdges(int[] ... edges);

	abstract public boolean edgeExists(int v1, int v2);
	
	abstract public int getEdgeCount();
	
	abstract public int getNodeCount();
	
	abstract public boolean isConnected(int v1, int v2);
}
