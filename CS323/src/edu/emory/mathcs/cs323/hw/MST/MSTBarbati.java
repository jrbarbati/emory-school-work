package edu.emory.mathcs.cs323.hw.MST;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import edu.emory.mathcs.cs323.graph.Edge;
import edu.emory.mathcs.cs323.graph.Graph;
//import edu.emory.mathcs.cs323.graph.span.MSTAlgorithm;
import edu.emory.mathcs.cs323.graph.span.MSTAll;
//import edu.emory.mathcs.cs323.graph.span.MSTPrim;
import edu.emory.mathcs.cs323.graph.span.SpanningTree;

/**
 * 
 * @author Joseph Barbati
 *
 */
public class MSTBarbati implements MSTAll
{
	/**
	 * Finds all MSTs in a graph, based on Prim's algorithm
	 * @param graph Graph to be searched for MSTs
	 * @return Returns a list of SpanningTrees (MSTs)
	 */
	@Override
	public List<SpanningTree> getMinimumSpanningTrees(Graph graph) {
		List<SpanningTree>  msts    = new ArrayList<>();
		PriorityQueue<Edge> queue   = new PriorityQueue<>();
		Set<Integer>        visited = new HashSet<>();
		SpanningTree        tree    = new SpanningTree();
		
		if (graph.size() <= 1 || graph.getAllEdges().size() == 0) return msts;
		
		getMinimumSpanningTrees(graph, visited, tree, queue, msts);
		
		if (msts.size() > 0)
		{
			// Gets minimum weight of all SpanningTrees in msts
			// (msts currently holds all non-repeating SpanningTrees)
			double min = getMinWeight(msts);
	
			// Here we remove all SpanningTrees with weight > min weight found in the list.
			removeNonMSTs(msts, min);
		}
		System.out.println(msts.size());
		return msts;
	}

	/**
	 * Recursively finds MSTs
	 * @param graph Graph in which to search
	 * @param visited Set of vertices that have already been visited
	 * @param tree current possible MST
	 * @param queue PQ that holds all possible edges to add
	 * @param msts List of SpanningTrees that are MSTs
	 */
	public void getMinimumSpanningTrees(Graph graph, 
										Set<Integer> visited, 
										SpanningTree tree, 
										PriorityQueue<Edge> queue, 
										List<SpanningTree> msts)
	{
		//Add all connecting vertices from start vertex to the queue
		add(queue, visited, graph, 0);
		
		// If tree is SpanningTree it is MST bc prev if-statement 
		// guarantees tree's weight is not greater than an MST
		// Also check if tree already exists in msts.
		if (tree.size() + 1 == graph.size() && !isSameTree(tree, msts)) {
			msts.add(tree);
			return;
		}
		
		if (queue.isEmpty()) return;
		
		Edge edge;
		
		while(!queue.isEmpty())
		{	
			edge = queue.poll();
			
			if (!visited.contains(edge.getSource()))
			{
				// Copying objects
				SpanningTree        tempT = new SpanningTree(tree);
				PriorityQueue<Edge> tempQ = new PriorityQueue<>(queue);
				Set<Integer>        tempV = new HashSet<>(visited);
			
				tempT.addEdge(edge);
				
				//Add all connecting vertices from current vertex to the queue
				add(tempQ, tempV, graph, edge.getSource());
				
				getMinimumSpanningTrees(graph, tempV, tempT, tempQ, msts);
			}
		}
	}
	
	/**
	 * @param queue Queue of all vertices awaited to explore
	 * @param visited Set of visited vertices
	 * @param graph Graph
	 * @param target Target vertex
	 */
	private void add(PriorityQueue<Edge> queue, Set<Integer> visited, Graph graph, int target)
	{
		visited.add(target);
		
		for (Edge edge : graph.getIncomingEdges(target))
		{
			if (!visited.contains(edge.getSource()))
				queue.add(edge);
		}
	}
	
	/**
	 * Removes all non-MST SpanningTrees from 
	 * @param msts List to remove from
	 */
	private void removeNonMSTs(List<SpanningTree> st, double weight) 
	{
		int size = st.size();
		for(int i = size - 1; i >= 0; i--)
		{
			if (st.get(i).getTotalWeight() > weight)
			{
				st.remove(i);
			}
		}
	}

	/**
	 * gets the minimum weight of all SpanningTrees in msts
	 * @param msts list of SpanningTrees
	 * @return Returns the min weight
	 */
	private double getMinWeight(List<SpanningTree> msts) 
	{
		double currMin = msts.get(0).getTotalWeight();
		for(int i = 1; i < msts.size(); i++)
		{
			double weight = msts.get(i).getTotalWeight();
			if (weight < currMin)
				currMin = weight;
		}
		return currMin;
	}
	
	/**
	 * Checks if s is the same tree as any of the current trees in msts
	 * @param s SpanningTree to compare to MSTs in msts
	 * @return true if the s already exists in the msts list, false otherwise.
	 */
	private boolean isSameTree(SpanningTree s, List<SpanningTree> list)
	{
		boolean isSame = false;
		for(int i = 0; i < list.size(); i++)
		{
			List<Edge> mstEdges = list.get(i).getEdges();
			List<Edge> sEdges   = s.getEdges();
			// If the list of edges has different size 
			// then trees are guaranteed to be different
			if (mstEdges.size() != sEdges.size()) 
			{
				isSame = false;
				continue;
			}
			
			int count = 0;
		
			for(Edge edge : sEdges)
			{
				for(Edge other : mstEdges)
				{
					if  	(other.getSource() == edge.getSource() &&
						 	 other.getTarget() == edge.getTarget() &&
							 other.getWeight() == edge.getWeight()) 
					{
						count++;
					}
					else if (other.getSource() == edge.getTarget() &&
							 other.getTarget() == edge.getSource() &&
							 other.getWeight() == edge.getWeight())
					{
						count++;
					}
				}
			}
			// If the number of same edges equals the total number of edges
			// then they must be the same
			if (count == mstEdges.size()) 
				// Can go ahead and return true, bc a same graph exists in msts
				return true;
		}
		// Otherwise, they aren't the same
		return isSame;
	}
}
