public class Prim {
	private double weight;
	private Queue<Edge> mst;
	private boolean[] marked;
	private MinPQ<Edge> pq;

	public Prim(EdgeWeightedGraph G) {
		mst = new Queue<Edge>();
		marked = new boolean[G.V()];
		pq = new MinPQ<Edge>();
		for(int v = 0; v < G.V(); v++) 
			if (marked[v] == false)
				prim(G, v);
	}

	//Run prim's algorithm
	private void prim(EdgeWeightedGraph G, int s) {
		visit(G, v);
		while (!pq.isEmpty()) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other();
			if(marked[v] == true && marked[w] == true)
				continue;
			mst.enqueue(e);
			if(marked[v] == false)
				visit(G, v);
			if(marked[w] == false)
				visit(G, w);
		}
	}

	//Add all edges e incident to v onto pq if the other endpoint has not yet been scanned
	private void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;
		for(Edge e : G.adj(v)) {
			int b = e.other(v);
			if (marked[b] == false)
				pq.intsert(e);
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}
}
