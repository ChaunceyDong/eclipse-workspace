import java.util.*;

public class review {

	int heapsize;
	int time;
	public static void main(String[] args) {
		new review().testDFS_Graph();
	}
	
	void testDFS_Graph() {

		Vertex u = new Vertex("u");
		Vertex v = new Vertex("v");
		Vertex w = new Vertex("w");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		Vertex z = new Vertex("z");

		// Build the adjacency list
		Map<Vertex, List<Vertex>> adjacencyL = new TreeMap<>();
		// 这里用tree

		// Build neighbors
		List<Vertex> nu = new ArrayList<>();
		nu.add(v);
		nu.add(x);
		adjacencyL.put(u, nu);

		List<Vertex> nv = new ArrayList<>();
		nv.add(y);
		adjacencyL.put(v, nv);

		List<Vertex> nw = new ArrayList<>();
		nw.add(y);
		nw.add(z);
		adjacencyL.put(w, nw);

		List<Vertex> nx = new ArrayList<>();
		nx.add(v);
		adjacencyL.put(x, nx);

		List<Vertex> ny = new ArrayList<>();
		ny.add(x);
		adjacencyL.put(y, ny);

		List<Vertex> nz = new ArrayList<>();
		nz.add(z);
		adjacencyL.put(z, nz);

		// DFSvisit(adjacencyL, u);
		DFS(adjacencyL);

	}
	

	void testBFS_Graph() {

		Vertex s = new Vertex("s");
		Vertex r = new Vertex("r");
		Vertex v = new Vertex("v");
		Vertex w = new Vertex("w");
		Vertex t = new Vertex("t");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		Vertex u = new Vertex("u");

		// Build the adjacency list
		Map<Vertex , List<Vertex>> adjacencyL = new HashMap<>();
		
		// Build neighbors
		List<Vertex> nv = new ArrayList<>();
		nv.add(r);
		adjacencyL.put(v, nv);

		List<Vertex> nr = new ArrayList<>();
		nr.add(v);
		nr.add(s);
		adjacencyL.put(r, nr);

		List<Vertex> ns = new ArrayList<>();
		ns.add(r);
		ns.add(w);
		adjacencyL.put(s, ns);

		List<Vertex> nw = new ArrayList<>();
		nw.add(s);
		nw.add(t);
		nw.add(x);
		adjacencyL.put(w, nw);

		List<Vertex> nt = new ArrayList<>();
		nt.add(w);
		nt.add(x);
		nt.add(u);
		adjacencyL.put(t, nt);

		List<Vertex> nx = new ArrayList<>();
		nx.add(w);
		nx.add(t);
		nx.add(u);
		nx.add(y);
		adjacencyL.put(x, nx);

		List<Vertex> nu = new ArrayList<>();
		nu.add(t);
		nu.add(x);
		nu.add(y);
		adjacencyL.put(u, nu);

		List<Vertex> ny = new ArrayList<>();
		ny.add(x);
		ny.add(u);
		adjacencyL.put(y, ny);
		
		
		// test hash
		System.out.println("Test Hashcode");
		Vertex s2 = new Vertex("s");
		System.out.println(s.hashCode() + " " + s2.hashCode());	// s和s2 的name都是s，根据重新写的的HashCode()和equal()，判定两者是相同的

		System.out.println("Neighbors of \"s\" ");
		for (Vertex v1 : adjacencyL.get(s2))// 所以这里可以是s，也可以是s2
			System.out.print(v1.name + " " );

		
		// BFS
		System.out.println("\n\n"+ "Breadth-first Search");
		BFS(adjacencyL, s);
	}
	
	void BFS(Map<Vertex, List<Vertex>> l, Vertex s) {
		s.color = "gray";
		s.d= 0;
		s.pi = null;
		
		Queue<Vertex> Q = new LinkedList<Vertex>() ;
		Q.add(s);

		while(!Q.isEmpty()) {
			Vertex u = Q.poll();
			for(Vertex v : l.get(u)) {
				if(v.color == "white") {
					++v.d;
					v.pi = u;
					v.color = "gray";
					Q.add(v);
					System.out.print(v.name + " ");
				}
				u.color = "black";
			}
		}		
	}

	void DFS(Map<Vertex, List<Vertex>> G) {
		time = 0;
		for( Vertex u : G.keySet()){
			if(u.color == "white") {
				System.out.println("begin\t" + u.name);
				DFSvisit(G,u);
			}
		}
	}
	
	void DFSvisit(Map<Vertex, List<Vertex>> G, Vertex u) {
		u.color = "gray";
		u.b = ++time;
		for(Vertex v : G.get(u)) {
			if(v.color == "white") {
				v.pi = u;
				System.out.println(v.name);
				DFSvisit(G, v);
			}
		}
		u.color = "black";
		u.f = ++time;
	}
	
	
	
	void testBSTree() {
		// Create Node
		TreeNode n8 = new TreeNode(8);
		TreeNode n3 = new TreeNode(3);
		TreeNode n10 = new TreeNode(10);
		TreeNode n1 = new TreeNode(1);
		TreeNode n6 = new TreeNode(6);
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n14 = new TreeNode(14);
		TreeNode n13 = new TreeNode(13);

		// Create Binary Search Tree
		BST bst = new BST(n8);
		bst.addleft(n8, n3);
		bst.addright(n8, n10);
		bst.addleft(n3, n1);
		bst.addright(n3, n6);
		bst.addleft(n6, n4);
		bst.addright(n6, n7);
		bst.addright(n8, n10);
		bst.addright(n10, n14);
		bst.addleft(n14, n13);

		// test method
		System.out.println("Inorder");
		bst.inorder(n8);

		System.out.println("\n" + "preorder");
		bst.preorder(n8);

		System.out.println("\n" + "postorder");
		bst.postorder(n8);

		System.out.println("\n" + "Height");
		System.out.println(bst.height(n8));

		System.out.println("Minimum");
		System.out.println(bst.Tree_MinimumRecursive(n8).key);

		System.out.println("Maximum");
		System.out.println(bst.Tree_MaximumRecursive(n8).key);

		System.out.println("Search by recurision");
		System.out.println(bst.Tree_SearchRecursive(n8, 10).key);
		
		System.out.println("Search by iteration");
		System.out.println(bst.TreeSearchIterative(n8, 10).key);

		
		
		System.out.println("Successor");
		System.out.println(bst.Tree_Successor(n7).key);

		System.out.println(bst.isBST(n8));

	}

	void testLinkedList() {
		Linkedlist ll = new Linkedlist();
		Node n1 = new Node(1);
		Node n3 = new Node(3);
		Node n4 = new Node(4);

		// test insertion
		System.out.println("Insert a new Node n1 at the beginning of the list");
		ll.insert(n1);
		ll.print();
		System.out.println("Insert a node with key equal to 2 at the beginning of the list");
		ll.insert(2);
		ll.print();
		System.out.println("Insert a node n3 after node cur=sentinel");
		ll.insert(ll.getSentinel(), n3);
		ll.print();
		System.out.println("Insert a node n4 after node cur=n3");
		ll.insert(n3, n4);
		ll.print();

		// test delete
		System.out.println("Delete a node n4");
		ll.delete(n4);
		ll.print();
		System.out.println("Delete a node with key of 2");
		ll.delete(2);
		ll.print();
		System.out.println("Delete a node with key of 1");
		ll.delete(1);
		ll.print();

	}

	void testSort() {

		int[] a = new int[20];
		// int[] b = new int[20];
		for (int j = 0; j < a.length; j++) {
			a[j] = (int) (Math.random() * 200);
		}

		// int[] a = new int[] {49, 40, 30, 4, 2, 65, 89, 0, 14};
		// int[] b = new int[] { 1, 5, 10, 0, 4, 4 };

		// MergeSort
		System.out.println(Arrays.toString(a));

		// mergeSort(a, 0, a.length - 1);
		// HeapSort(a);
		insertionSort(a);
		// quickSort(a, 0, a.length - 1);

		// countingSort(a, b);

		System.out.println(Arrays.toString(a));

	}

	
	// MergeSort
	void mergeSort(int[] a, int p, int r) {
		if (p == r)
			return;
		int q = (p + r) / 2;
		mergeSort(a, p, q);
		mergeSort(a, q + 1, r);
		merge(a, p, q, r);
	}

	void merge(int[] a, int p, int q, int r) {
		//
		int[] left = new int[q - p + 1];
		for (int i = p; i <= q; i++) {
			left[i - p] = a[i];
		}

		int[] right = new int[r - q];
		for (int i = q + 1; i <= r; i++) {
			right[i - q - 1] = a[i];
		}

		//
		int i1 = 0;
		int i2 = 0;
		for (int i = p; i <= r; i++) {
			if (i1 == left.length) {
				a[i] = right[i2++];
				continue;
			}
			if (i2 == right.length) {
				a[i] = left[i1++];
				continue;
			}
			if (left[i1] < right[i2]) {
				a[i] = left[i1];
				i1++;
			} else {
				a[i] = right[i2];
				i2++;
			}
		}

	}

	// InsertionSort
	void insertionSort(int[] A) {
		for (int i = 1; i < A.length; ++i) {
			int key = A[i];
			int j = i - 1;
			for (; j >= 0 && A[j] > key; --j) { // 这里不能把 A[i] > key放在后面。
				// 因为最后一次循环i=0进去，走完，i-- = -1。再判断条件时，A[-1]会报错
				A[j + 1] = A[j];
			}
			A[j + 1] = key;
		}
	}

	// HeapSort
	void MaxHeapify(int[] A, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		if (l <= heapsize - 1 && A[l] > A[i])
			largest = l;
		if (r <= heapsize - 1 && A[r] > A[largest])
			largest = r;
		if (i != largest) {
			swap(A, i, largest);
			MaxHeapify(A, largest);
		}

	}

	void swap(int[] A, int a, int b) {
		int swap = A[a];
		A[a] = A[b];
		A[b] = swap;
	}

	void BuildHeap(int[] A) {
		heapsize = A.length;
		for (int i = heapsize / 2 - 1; i >= 0; i--)
			MaxHeapify(A, i);

	}

	void HeapSort(int[] A) {
		BuildHeap(A);
		for (int i = heapsize - 1; i >= 1; --i) {
			swap(A, 0, i);
			--heapsize;
			MaxHeapify(A, 0);
		}
	}

	// QuickSort
	int partition(int[] A, int p, int r) {
		int i = p - 1;
		for (int j = p; j < r; ++j) {
			if (A[j] < A[r]) {
				++i;
				swap(A, i, j);
			}
		}
		swap(A, r, ++i);
		return i;
	}

	void quickSort(int[] A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
		}
	}

	// CountingSort
	void countingSort(int[] A, int[] B) {
		int[] C = new int[maxEle(A, A.length) + 1];

		for (int i = 0; i < A.length; i++) {
			// ++C[A[i]];
			C[A[i]] = C[A[i]] + 1;
		}
		for (int i = 1; i < C.length; ++i) {
			C[i] = C[i - 1] + C[i];
		}
		System.out.println(Arrays.toString(C));

		for (int j = A.length - 1; j >= 0; --j) {
			B[ C[A[j]] - 1] = A[j];
			--C[A[j]];
		}

	}

	int maxEle(int[] A, int n) {
		if (n == 1)
			return A[0];
		return Math.max(maxEle(A, n - 1), A[n - 1]);
		// 最后一个数，和前n-1个数的max比
	}

}

class Stack {
	int point;
	int size;
	int[] array;

	Stack(int size) {
		this.size = size;
		array = new int[size];
		point = -1;
	}

	int pop() throws Exception {
		if (isEmpty())
			throw new Exception("Underflow");
		return array[point--];
	}

	void push(int a) {
		if (point == array.length - 1)
			System.out.println("error");
		else
			array[++point] = a;
	}

	boolean isFull() {
		return point == size - 1;
	}

	boolean isEmpty() {
		return point == -1;
	}

}

class Node {
	int key;
	Node prev;
	Node next;

	public Node(int key) {
		this.key = key;
		prev = null;
		next = null;
	}

}

class Linkedlist {
	Node sentinel;

	public Linkedlist() {
		sentinel = new Node(-1);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
	}

	void insert(Node cur, Node x) {
		x.next = cur.next;
		cur.next.prev = x;
		x.prev = cur;
		cur.next = x;
	}

	void insert(Node x) {
		insert(sentinel, x);
	}

	void insert(int x) {
		Node n = new Node(x);
		insert(n);
	}

	void print() {
		for (Node n = sentinel.next; n != sentinel; n = n.next) {
			System.out.print(n.key);
		}
		System.out.println();
	}

	Node getSentinel() {
		return sentinel;
	}

	Node search(int x) {
		Node n = sentinel.next;
		for (; n.key != x && n != sentinel; n = n.next) {
		}
		return n;
	}

	void delete(Node x) {
		x.prev.next = x.next;
		x.next.prev = x.prev;
	}

	void delete(int x) {
		Node n = search(x);
		delete(n);
	}

}

class TreeNode {
	int key;
	TreeNode left;
	TreeNode right;
	TreeNode parent;

	public TreeNode(int key) {
		this.key = key;
		left = right = parent = null;
	}
}

class BST {
	TreeNode tnroot;

	public BST(TreeNode tnroot) {
		this.tnroot = tnroot;
		tnroot.parent = null;
	}

	void addleft(TreeNode t1, TreeNode t2) {
		t1.left = t2;
		t2.parent = t1;
	}

	void addright(TreeNode tnroot, TreeNode tnright) {
		tnroot.right = tnright;
		tnright.parent = tnroot;
	}

	void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.key + " ");
		inorder(root.right);
	}

	void preorder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.key + " ");
		preorder(root.left);
		preorder(root.right);
	}

	void postorder(TreeNode root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.key + " ");
	}

	int height(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	TreeNode Tree_MinimumRecursive(TreeNode root) {
		if (root.left == null)
			return root;
		return Tree_MinimumRecursive(root.left);
	}

	TreeNode Tree_MaximumRecursive(TreeNode root) {
		if (root.right == null)
			return root;
		return Tree_MaximumRecursive(root.right);
	}

	TreeNode Tree_SearchRecursive(TreeNode root, int k) {
		if (root.key == k || root == null)
			return root;
		if (k < root.key)
			return Tree_SearchRecursive(root.left, k);
		
		return Tree_SearchRecursive(root.right, k);
	}
	
	TreeNode TreeSearchIterative(TreeNode root, int k) {	
		for(; root != null && root.key != k;) {
			
			if( k > root.key) {
				root = root.right;
				continue;
			}
			else if (k < root.key) {
				root = root.left;
				continue;
			}
		}
		return root;
	}

	TreeNode Tree_Successor(TreeNode x) {
		if (x.right != null)
			return Tree_MinimumRecursive(x.right);

		TreeNode y = x.parent;
		for (; y != null && y.right == x;) {
			x = y;
			y = y.parent;
		}
		return y;
	}

	boolean isBST(TreeNode root) {
		if (root == null)
			return true;
		else if (root.left != null && Tree_MaximumRecursive(root.left).key > root.key)
			return false;
		else if (root.right != null && Tree_MinimumRecursive(root.right).key < root.key)
			return false;
		else
			return isBST(root.left) && isBST(root.right);
	}

}

class Vertex implements Comparable<Vertex>{
	String name;
	String color;
	int d;
	Vertex pi;
	int b;
	int f;
	
	Vertex(String name){
		this.name = name;
		color = "white";
		pi = null;
		d = Integer.MAX_VALUE;
		f = b = 0;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}
	
	public int compareTo(Vertex v) {
		return name.compareTo(v.name);
	}
}
