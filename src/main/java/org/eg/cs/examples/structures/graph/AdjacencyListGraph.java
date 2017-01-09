package org.eg.cs.examples.structures.graph;

import org.eg.cs.examples.utils.Utils;

/**
 * Spatial complexity is O(|V| + |E|)
 * 
 * @author egunay
 *
 */
public class AdjacencyListGraph extends Graph {

	int[][] data;
	
	public AdjacencyListGraph(int nodeCount) {
		data = new int[nodeCount][0];
	}

	/**
	 * Runtime complexity is O(|E|)
	 */
	@Override
	public void addEdges(int[] ... edges) {
		for (int[] edge : edges) {
			assert edge.length == 2 : "an edge has to be an array of two integers pointing to edge index in the graph";
			
			int e1 = edge[0];
			int e2 = edge[1];
						
			data[e1] = Utils.reallocateArray(data[e1], data[e1].length+1);
			Utils.setLast(data[e1], e2);

			data[e2] = Utils.reallocateArray(data[e2], data[e2].length+1);
			Utils.setLast(data[e2], e1);
		}
	}
	
	/**
	 * Runtime complexity is O(|E|)
	 */
	@Override
	public boolean edgeExists(int v1, int v2) {
		int[] neighbors = data[v1];
		
		for (int i = 0; i < neighbors.length; i++)
			if (neighbors[i] == v2)
				return true;
		
		return false;
	}
	
	@Override
	public int getNodeCount() {
		return data.length;
	}
	
	@Override
	public int getEdgeCount() {
		int edgeCount = 0;
		for (int i = 0; i < getNodeCount(); i++)
			edgeCount += data[i].length;
		
		return edgeCount;
	}
	
	@Override
	public boolean isConnected(int v1, int v2) {
		return false;
	}
	
}
