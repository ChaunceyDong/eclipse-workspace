import java.util.*;

public class testDFS {
	private int time = 0;

	public static void main(String[] args) {
		new testDFS().test();
	}

	void test() {
		Vertex u = new Vertex("u");
		Vertex v = new Vertex("v");
		Vertex w = new Vertex("w");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		Vertex z = new Vertex("z");

		// Build the adjacency list
		Map<Vertex, List<Vertex>> adjacencyL = new TreeMap<>();
		// ’‚¿Ô”√tree

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

	void DFS(Map<Vertex, List<Vertex>> G) {
		for (Vertex v : G.keySet()) {
			if (v.color == "white") {
				System.out.println("begin\t" + v.name);
				DFSvisit(G, v);
			}
		}
	}

	void DFSvisit(Map<Vertex, List<Vertex>> G, Vertex s) {
		time++;
		s.d = time;
		s.color = "gray";
		for (Vertex v : G.get(s)) {
			if (v.color == "white") {
				v.pi = s;
				System.out.println(v.name);
				DFSvisit(G, v);
			}
		}
		s.color = "black";
		time++;
		s.f = time;
	}

}

class Vertex implements Comparable<Vertex> {
	String name;
	String color;
	Vertex pi;
	int d;
	int f;

	Vertex(String name) {
		this.name = name;
		color = "white";
		pi = null;
	}

	public int compareTo(Vertex v) {
		return name.compareTo(v.name);
	}

}
