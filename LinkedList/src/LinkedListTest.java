/*
 * Implement a sentinel linkedlist with the following functions:
 * 
 * Insert a new Node x at the beginning of the list
 * Insert a node with key equal to x at the beginning of the list
 * Insert a node x after node cur
 *
 * Delete a node x
 * Delete a node with key of x
 * 
 * Search the node with key equal to x
 * 
 * Print out the list from the beginning
 */

public class LinkedListTest {
	public static void main(String[] args) {
		new LinkedListTest().testLikedList();
	}

	void testLikedList() {
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

}

class Node {
	Node prev;
	Node next;
	int key;

	public Node(int key) {
		this.key = key;
		prev = null;
		next = null;
	}

}

class Linkedlist {
	private Node sentinel;

	public Linkedlist() {
		sentinel = new Node(-1);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
	}

	void insert(Node cur, Node x) {// 先后两个再前两个，之间不能瞎换
		x.next = cur.next;
		cur.next.prev = x;
		cur.next = x;
		x.prev = cur;
	}
	
	//Insert a new Node at the beginning of the list
	void insert(Node x) {
		insert(sentinel, x);
	}

	
	//Insert a new Node with key at the beginning of the list
	void insert(int x) {
		Node cur = new Node(x);
		insert(cur);
	}
//初八

	void delete(Node x) {
		x.prev.next = x.next;
		x.next.prev = x.prev;
	}

	void delete(int x) {
		Node a = search(x);
		delete(a);
	}

	Node search(int x) {
		Node cur = sentinel.next;
		for (; cur != sentinel && cur.key != x; cur = cur.next) {
		}
		return cur;
	}

	void print() {
		Node cur = sentinel.next;
		for (; cur != sentinel; cur = cur.next)
			System.out.print(cur.key);
		System.out.println();
	}

	Node getSentinel() {
		return sentinel;
	}
}
