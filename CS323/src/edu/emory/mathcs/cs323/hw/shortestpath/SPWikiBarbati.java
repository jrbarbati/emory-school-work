/**
 * Copyright 2015, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.mathcs.cs323.hw.shortestpath;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

import edu.emory.mathcs.cs323.graph.Edge;
import edu.emory.mathcs.cs323.graph.Graph;
import edu.emory.mathcs.cs323.graph.path.VertexDistancePair;

public class SPWikiBarbati
{
	List<String> titles;
	int[][]      links;
	double[]     distances;
	Integer[]    previous;
	
	public SPWikiBarbati(InputStream inTitles, InputStream inLinks) throws Exception
	{
		titles = getTitles(inTitles);
		links  = getLinks(inLinks, titles.size());
		
		Graph g = new Graph(titles.size());
		
		setEdges(g);
		
//		int randSource = (int)(Math.random() * 1000) + 1;
//		int randTarget = (int)(Math.random() * 1000) + 1;
		
		int source = 5 * 19;
		int target = 1 + 5 * 13;
		
		try
		{
			getShortestPath(g, source, target);
			String path = buildPath(source);
			System.out.println(path);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Error: either source or target is not a valid index.");
		}
	}
	
//  ###########################################################################
//	Taken of AStar.java and Dijkstra.java
	private void getShortestPath(Graph graph, int source, int target)
	{
		PriorityQueue<VertexDistancePair> queue = new PriorityQueue<>();
		previous  = new Integer[graph.size()];
		distances = new double [graph.size()];
		Set<Integer> visited = new HashSet<>();

		init(target);
		queue.add(new VertexDistancePair(target, 0));
		
		while (!queue.isEmpty())
		{
			VertexDistancePair u = queue.poll();
			visited.add(u.vertex);
			
			for (Edge edge : graph.getIncomingEdges(u.vertex))
			{
				//Vertex that can be reached through current vertex
				int v = edge.getSource();
				
				//If the vertex has yet been visited
				if (!visited.contains(v))
				{
					//Calculated distance from target to v
					double dist = distances[u.vertex] + edge.getWeight();
					
					if (dist < distances[v])
					{
						distances[v] = dist + heuristic(v, target);
						previous [v] = u.vertex;
						queue.add(new VertexDistancePair(v, dist));
					}
				}
			}
		}
	}
	
	private void init(int target)
	{
		for (int i=0; i<distances.length; i++)
		{
			//Set distance from target to target as the heuristic value
			if (i == target)
				distances[i] = heuristic(i, target);
			else
			{
				//Initialize all distance to infinity
				distances[i] = Double.MAX_VALUE;
				//Initialize all previous vertices to null
				previous[i]  = null;
			}
		}
	}
	
	private double heuristic(int source, int target)
	{
		return 0;
	}
//	###########################################################################
	
	public List<String> getTitles(InputStream in) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		List<String> list = new ArrayList<>();
		String line;
		
		while ((line = reader.readLine()) != null)
			list.add(line.trim());
		
		reader.close();
		return list;
	}
	
	public int[][] getLinks(InputStream in, int size) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Pattern p = Pattern.compile(" ");
		int[][] array = new int[size][];
		int[] links;
		String line;
		String[] t;
		int i, j;
		
		for (i=0; (line = reader.readLine()) != null; i++)
		{
			line = line.trim();
			
			if (line.isEmpty())
				array[i] = new int[0];
			else
			{
				t = p.split(line);
				links    = new int[t.length];
				array[i] = links;

				for (j=0; j<links.length; j++)
					links[j] = Integer.parseInt(t[j]);	
			}
		}
		
		return array;
	}
	
	/**
	 * Sets the edges in the graph based on the links
	 * @param graph Graph of disconnected vertices 
	 */
	private void setEdges(Graph graph)
	{
		for(int i = 0; i < links.length; i++)
			for(int j = 0; j < links[i].length; j++)
				graph.setDirectedEdge(i, links[i][j], 1);
	}

	/**
	 * Builds path from shortest path given by Dijkstra's
	 * @param prev Array of Integers representing the previous vertex
	 * @param source Source of path
	 * @return Returns a string representation of the shortest path
	 */
	private String buildPath(int source)
	{
		String path   = "";
		int    i      = source;
		while(true)
		{
			if (distances[i] == 0.0)
			{
				path += titles.get(i);
				break;
			}
			path += titles.get(i);
			path += " -> ";
			// If distance is > 0 and prev[i] is null, no path exists.
			// Example: when target is 0, no title links to vertex 0, 
			// so no path can be found
			if (previous[i] == null)
				return "No path found from source to target";
			i = previous[i];
		}
		return path;
	}
	
	static public void main(String[] args) throws Exception
	{
		final String TITLE_FILE = "/Users/josephbarbati/Documents/codefiles/Emory/CS323/src/edu/emory/mathcs/cs323/hw/shortestpath/wiki-titles-small.txt";
		final String LINK_FILE  = "/Users/josephbarbati/Documents/codefiles/Emory/CS323/src/edu/emory/mathcs/cs323/hw/shortestpath/wiki-links-small.txt";
	
		new SPWikiBarbati(new FileInputStream(TITLE_FILE), new FileInputStream(LINK_FILE));
	}
}