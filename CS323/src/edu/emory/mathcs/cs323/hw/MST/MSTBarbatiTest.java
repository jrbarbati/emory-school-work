package edu.emory.mathcs.cs323.hw.MST;

import java.util.List;

import edu.emory.mathcs.cs323.graph.Graph;
import edu.emory.mathcs.cs323.graph.span.MSTAll;
import edu.emory.mathcs.cs323.graph.span.SpanningTree;

public class MSTBarbatiTest 
{
	public static void main(String[] args)
	{
		MSTAll test = new MSTBarbati();
		
		Graph graph = new Graph(100);
//		graph.setUndirectedEdge(0, 1, 2);
//		graph.setUndirectedEdge(0, 2, 2);
//		graph.setUndirectedEdge(0, 3, 3);
//		graph.setUndirectedEdge(0, 4, 1);
//		graph.setUndirectedEdge(1, 2, 2);
//		graph.setUndirectedEdge(2, 3, 4);
//		graph.setUndirectedEdge(3, 4, 3);
		
		List<SpanningTree> mst = test.getMinimumSpanningTrees(graph);
		
		System.out.println("ALL MSTS");
		for(SpanningTree st : mst)
		{
			System.out.println(mst.indexOf(st) + 1);
			System.out.println(st);
			System.out.println("");
		}
	}
}
