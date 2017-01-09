package org.eg.cs.examples.algorithms.graph;

import org.eg.cs.examples.structures.graph.AdjacencyListGraph;
import org.eg.cs.examples.structures.graph.AdjacencyMatrixGraph;
import org.eg.cs.examples.structures.graph.Graph;
import org.eg.cs.examples.utils.Utils;

public class GeneralGraphOperations {

	public static void main(String[] args) {
		GeneralGraphOperations generalGraphOperations = new GeneralGraphOperations();
		
		generalGraphOperations.execute(new AdjacencyListGraph(10));
		generalGraphOperations.execute(new AdjacencyListGraph(100));
		generalGraphOperations.execute(new AdjacencyListGraph(1000));
		generalGraphOperations.execute(new AdjacencyListGraph(10000));
		generalGraphOperations.execute(new AdjacencyListGraph(100000));
		generalGraphOperations.execute(new AdjacencyListGraph(1000000));
		
		System.out.println();
		generalGraphOperations.execute(new AdjacencyMatrixGraph(10));
		generalGraphOperations.execute(new AdjacencyMatrixGraph(100));
		generalGraphOperations.execute(new AdjacencyMatrixGraph(1000));
		generalGraphOperations.execute(new AdjacencyMatrixGraph(10000));
		generalGraphOperations.execute(new AdjacencyMatrixGraph(40000));
		
		
}
	
	public void execute(Graph graph) {
		String graphName = graph.getClass().getSimpleName();
		long startTime = System.currentTimeMillis();
		initEdges(graph, graph.getNodeCount() * 2);
		long endTime = System.currentTimeMillis();
		System.out.printf("%s initialized with %d nodes and %d edges in %d milliseconds. \n", 
				graphName, 
				graph.getNodeCount(), 
				graph.getEdgeCount(), 
				(endTime - startTime));
		
		startTime = System.currentTimeMillis();
		graph.getEdgeCount();
		endTime = System.currentTimeMillis();
		System.out.printf("%s getEdgeCount() with %d nodes finished in %d milliseconds. \n", 
				graphName, 
				graph.getNodeCount(), 
				(endTime - startTime));
		
	}
	
	private void initEdges(Graph graph, int edgeCount) {
		int totalEdgeCount = 0;
		while (totalEdgeCount < edgeCount) {
			int v1 = Utils.randomInt(graph.getNodeCount());
			int v2 = Utils.randomInt(graph.getNodeCount());
			
			if (v1 == v2)
				continue;
			
			if (graph.edgeExists(v1, v2))
				continue;
			
			graph.addEdges(new int[] {v1, v2});
			totalEdgeCount++;
		}
	}
}
