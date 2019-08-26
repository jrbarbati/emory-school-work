
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	
	private Node root;

	private class Node {

		private Key key;
		private Value val;
		private Node left, right;
		private int N;		

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	public BinarySearchTree() {}
	
	public boolean isEmpty() {
		return size() == 0;
	}	
	
	public int size() {
		return size(root);
	}
	
	public int size(Node x) {
		if (x == null) return 0;
		else return x.N;
	}
	
	public Value get(Key key) {
		return getHelper(root, key);
	}
	
	private Value getHelper(Node x, Key key) {
		int compare = key.compareTo(x.key);
		if (compare == 0)
			return x.val;
		if (compare > 0)
			return getHelper(x.right, key);
		return getHelper(x.left, key);
	}
	
	public void put(Key key, Value val) {
		if (key == null) throw new NullPointerException("first argument null");
		if (val == null) {
			delete(key);
			return;
		}
		putHelper(root, key, val);
	}
	
	private Node putHelper(Node x, Key key, Value val) {
		if (x == null) 
			return new Node(key, val, 1);
		int compare = key.compareTo(x.key);
		if (compare == 0) {
			x.val = val;
			return x;
		}
		if (compare < 0) {
			x.left = putHelper(x.left, key, val);
		} else {
			x.right = putHelper(x.right, key, val);
		}
		return x;
	}
	
	public boolean contains(Key key) {
		if (key == null) throw new NullPointerException("argument is null");
		return get(key) != null;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0) 
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
                return x.left;

			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public int rank(Key k) {
		return rank(k, root);
	}
	
	private int rank(Key key, Node r) {
		if (r == null) 
			return 0;
		int cmp = key.compareTo(r.key);
		if (cmp < 0) 
			return rank(key, r.left);
		else if (cmp > 0) 
			return 1 + size(r.left) + rank(key, r.right);
		else 
			return size(r.left);
	}

	public Key select(int k) {
		if (k < 0) return null;
		if (k >= size()) return null;
		Node x = select(root, k);
		return x.key;
	}
		
	private Node select(Node x, int k) {
		if (x == null) return null;
		int t = size(x.left);
		if (t > k)
			return select(x.left, k);
		else if (t < k) 
			return select(x.right, k - t - 1);
		else 
			return x;	
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		if (x.left == null) 
			return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
    
	public Key min() {
		return min(root).key;
	}
    
	private Node min(Node x) {
		if (x.left == null)
			return x;
		return min(x.left);
	}
    
    public static void main(String[] args) {
        
    }
}
