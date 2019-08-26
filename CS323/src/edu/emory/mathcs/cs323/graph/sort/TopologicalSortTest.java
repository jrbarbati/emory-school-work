package edu.emory.mathcs.cs323.graph.sort;

import java.util.List;

import edu.emory.mathcs.cs323.graph.Graph;

public class TopologicalSortTest 
{
	public static void main(String[] args)
	{
		Graph g = new Graph(8);
		g.setDirectedEdge(0, 3, 1);
		g.setDirectedEdge(0, 4, 1);
		g.setDirectedEdge(1, 3, 1);
		g.setDirectedEdge(2, 4, 1);
		g.setDirectedEdge(2, 7, 1);
		g.setDirectedEdge(3, 5, 1);
		g.setDirectedEdge(3, 6, 1);
		g.setDirectedEdge(3, 7, 1);
		g.setDirectedEdge(4, 6, 1);
		
		TopologicalSort t     = new TopologicalSort();
		List<Integer>   order = t.sort(g);
		
		for(int i = 0; i < order.size(); i++)
			System.out.println(order.get(i));
	}
}
