package org.eg.cs.examples.structures.graph;

/**
 * Spatial complexity is O(|V|^2)
 * 
 * @author egunay
 *
 */
public class AdjacencyMatrixGraph extends Graph {

	int[][] data;
	
	public AdjacencyMatrixGraph(int nodeCount) {
		data = new int[nodeCount][nodeCount];
	}
	
	
	/**
	 * Runtime complexity is O(1)
	 */
	@Override
	public void addEdges(int[] ... edges) {
		for (int[] edge : edges) {
			assert edge.length == 2 : "an edge has to be an array of two integers pointing to edge index in the graph";
			
			int e1 = edge[0];
			int e2 = edge[1];
						
			data[e1][e2] = 1;
			data[e2][e1] = 1;
		}
	}
	
	/**
	 * Runtime complexity is O(1)
	 */
	@Override
	public boolean edgeExists(int v1, int v2) {
		return data[v1][v2] == 1;
	}
	
	@Override
	public int getNodeCount() {
		return data.length;
	}
	
	/**
	 * Runtime complexity is O(|V|^2)
	 */
	@Override
	public int getEdgeCount() {
		int edgeCount = 0;
		for (int i = 0; i < getNodeCount(); i++)
			for (int j = i+1; j < getNodeCount(); j++)
				edgeCount += data[i][j];
		
		return edgeCount;
	}


	@Override
	public boolean isConnected(int v1, int v2) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
