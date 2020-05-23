// awt abstract windows toll  事件监听器中用到的
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class testBFS {

	public static void main(String[] args) {
		new testBFS().test();
	}

	void test() {
		Vertex s = new Vertex("s");
		Vertex r = new Vertex("r");
		Vertex v = new Vertex("v");
		Vertex w = new Vertex("w");
		Vertex t = new Vertex("t");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		Vertex u = new Vertex("u");

		// Build the adjacency list
		Map<Vertex, List<Vertex>> adjacencyL = new HashMap<>();

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
		System.out.println(s.hashCode() + " " + s2.hashCode());
		// s和s2 的name都是s，根据重新写的的HashCode()和equal()，判定两者是相同的
		for (Vertex v1 : adjacencyL.get(s2))// 所以这里可以是s，也可以是s2
			System.out.println(v1.name);

		
		// BFS
		System.out.println("Breadth-first Search");
		BFS(adjacencyL, s);
	}

	void BFS(Map<Vertex, List<Vertex>> G, Vertex s) {
		
		s.color = "gray";
		s.d = 0;
		s.pi = null;

		Queue<Vertex> Q = new LinkedList<>();// inqueue/dequeue = add后面加一个/poll前面弹出来
		Q.add(s);
		
		while (!Q.isEmpty()) {
			Vertex u = Q.poll();
			for (Vertex v : G.get(u))
				if (v.color == "white") {
					v.color = "gray";
					++v.d;
					v.pi = u;
					System.out.print(v.name + " ");
					Q.add(v);
				}
			u.color = "black";
		}
		
	}
		
}

class Vertex {
	String name;
	String color;
	Vertex pi;
	int d;

	Vertex(String name) { // 不加public，默认本包内可见
		this.name = name;
		color = "white";
		pi = null;
		d = Integer.MAX_VALUE;
	}

	// 用Vertex的名字，来作为它的hash值，作为它的唯一标识符
	public int hashCode() {
		return name.hashCode();
	}

	// 判断两个相等的条件为hash值的相同与否
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

}
