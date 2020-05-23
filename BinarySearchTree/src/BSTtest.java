//Implement the following functions for a BST:
//
//height, PreOrder, PostOrder, InOrder, 
//
//Tree_MinimumRecursive, Tree_MaximumIterative
//
//Tree_SearchRecursive
//
//Tree_Successor

public class BSTtest {

	public static void main(String[] args) {
		new BSTtest().testBST();
	}

	void testBST() {
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

		System.out.println("Search");
		System.out.println(bst.Tree_SearchRecursive(n8, 10).key);

		System.out.println("Successor");
		System.out.println(bst.Tree_Successor(n7).key);
	}

}

class BST {
	TreeNode tnroot;

	public BST(TreeNode tnroot) {
		this.tnroot = tnroot;
	}

	void addleft(TreeNode tnroot, TreeNode tnleft) {
		tnroot.left = tnleft;
		tnleft.parent = tnroot;
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
		if (root.key > k)
			return Tree_SearchRecursive(root.left, k);
		return Tree_SearchRecursive(root.right, k);
	}

	TreeNode Tree_Successor(TreeNode x) {
		if (x.right != null)
			return Tree_MinimumRecursive(x.right);
		TreeNode y = x.parent;
		for (; y != null && x != y.left;) {
			x = y;
			y = y.parent;
		}
		return y;
	}

}

class TreeNode {
	int key;
	TreeNode left;
	TreeNode right;
	TreeNode parent;

	TreeNode(int key) {
		this.key = key;
		left = right = parent = null;
	}
}