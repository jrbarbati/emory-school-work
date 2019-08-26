public class DepthFirstSearch {
	//Recursive Algorithm
	private boolean[] marked;
	
	public DepthFirstSearch(Graph G) {
		//G.V() is the number of Nodes (vertices) of the graph
		marked = new boolean[G.V()];
	}

	public void dfs(Graph G, int v) {
		if (marked[v] == true)
			return;
		//Mark as seen, then traverse it
		marked[v] = true;
		System.out.println("v: " + v);
		for(int i : G.adj(v)) {
			//i is every single neighbor of vertex v
			dfs(G, i);
		}
	}

	public int connectedComponents(Graph G) {
		int components = 0;
		for(int i = 0; i < G.V(); i++) {
			if (marked[i] == false) 
				dfs(G,i);
			components++;
		}
		return components;
	}

	public static void main(String[] args) {
		if (args.length != 1) 
			System.out.println("Usage: java DepthFirstSearch filename");
		In in = new In(args[0]);
		Graph G = new Graph(in);
		DepthFirstSearch dfs = new DepthFirstSearch(G);
		//dfs.dfs(G, 0);
		System.out.println("Components: " dfs.connectedComponents(G));
	}
}
