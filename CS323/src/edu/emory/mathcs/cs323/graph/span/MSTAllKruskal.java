package edu.emory.mathcs.cs323.graph.span;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import edu.emory.mathcs.cs323.graph.Edge;
import edu.emory.mathcs.cs323.graph.Graph;
import edu.emory.mathcs.cs323.set.DisjointSet;

public class MSTAllKruskal implements MSTAll
{

	@Override
	public List<SpanningTree> getMinimumSpanningTrees(Graph graph) {
		DisjointSet         forest = new DisjointSet(graph.size());
		PriorityQueue<Edge> queue  = createEdgePQ(graph);
		List<SpanningTree>  trees  = new ArrayList<>();
		SpanningTree        tree   = new SpanningTree();
		
		getMinimumSpanningTrees(graph, forest, queue, trees, tree);
		
		return trees;
	}
	
	private void getMinimumSpanningTrees(Graph graph, DisjointSet forest, 
										 PriorityQueue<Edge> queue, List<SpanningTree> trees,
										 SpanningTree tree)
	{
		if(!trees.isEmpty() && tree.getTotalWeight() > trees.get(0).getTotalWeight()) return;
		
		if(tree.size() + 1 == graph.size())
		{
			trees.add(tree);
			return;
		}
		
		PriorityQueue<Edge> tempQ;
		DisjointSet         tempF;
		SpanningTree        tempT;
		Edge                edge;
		
		do
		{
			edge = queue.poll();
			tempQ = new PriorityQueue<>(queue);
			tempF = new DisjointSet(graph.size());
			tempT = new SpanningTree(tree);
			
			if(!tempF.inSameSet(edge.getTarget(), edge.getSource()))
			{
				tree.addEdge(edge);
				
				if(tree.size() + 1 == graph.size()) break;		
				
				tempF.union(edge.getSource(), edge.getTarget());
				
				getMinimumSpanningTrees(graph, tempF, tempQ, trees, tempT);
			}
			
		} while(!queue.isEmpty() && edge.compareTo(queue.peek()) == 0);
	}
	
	/**
	 * @param graph Graph
	 * @return PriorityQueue that contains all edges in graph sorted by their weights
	 */
	private PriorityQueue<Edge> createEdgePQ(Graph graph)
	{
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		
		for (Edge edge : graph.getAllEdges())
			queue.add(edge);
		
		return queue;
	}

}
