import java.util.*;

public class DijkstraAlgorithm {

	public static void main(String[] args) {

		new DijkstraAlgorithm().test();
	}

	void test() {
		// Vertex
		Vertex s = new Vertex('s');
		Vertex t = new Vertex('t');
		Vertex y = new Vertex('y');
		Vertex x = new Vertex('x');
		Vertex z = new Vertex('z');

		// Neighbors
		List<Edge> sn = new ArrayList<>();
		Edge st = new Edge(s, t, 10);
		Edge sy = new Edge(s, y, 5);
		sn.add(st);
		sn.add(sy);

		List<Edge> tn = new ArrayList<>();
		Edge ty = new Edge(t, y, 2);
		Edge tx = new Edge(t, x, 1);
		tn.add(ty);
		tn.add(tx);

		List<Edge> yn = new ArrayList<>();
		Edge yt = new Edge(y, t, 3);
		Edge yz = new Edge(y, z, 2);
		Edge yx = new Edge(y, x, 9);
		yn.add(yt);
		yn.add(yz);
		yn.add(yx);

		List<Edge> xn = new ArrayList<>();
		Edge xz = new Edge(x, z, 4);
		xn.add(xz);

		List<Edge> zn = new ArrayList<>();
		Edge zx = new Edge(z, x, 6);
		Edge zs = new Edge(z, s, 7);
		zn.add(zx);
		zn.add(zs);

		// Graph
		Map<Vertex, List<Edge>> graph = new HashMap<>();
		graph.put(s, sn);
		graph.put(t, tn);
		graph.put(y, yn);
		graph.put(x, xn);
		graph.put(z, zn);

		System.out.println("---Initialization---");
		for (List<Edge> es : graph.values()) {
			for (Edge e : es)
				System.out.println(e.srcs.name + " " + e.d + " " + e.dest.name);
		}
		System.out.println("---Dijkstra---");

		DijkstraA(graph, s);

		System.out.println("---Output---");
		System.out.println("Weight of each Vertex:");
		for (Vertex v : graph.keySet()) {
			System.out.println(v.name + " " + v.d);
		}
		System.out.println("Distance:");
		for (List<Edge> es : graph.values()) {
			for (Edge e : es) {
				System.out.println(e.srcs.name + " " + e.d + " " + e.dest.name);
			}
		}
	}

	void DijkstraA(Map<Vertex, List<Edge>> graph, Vertex s) {
		s.d = 0;
		PriorityQueue<Vertex> Q = new PriorityQueue<>(new Comparator<Vertex>() {

			public int compare(Vertex o1, Vertex o2) {
				return o1.d - o2.d;
			}
		});

		Q.addAll(graph.keySet());
		while (!Q.isEmpty()) {

			System.out.println("循环开始");
			Iterator<Vertex> v = Q.iterator();
			while (v.hasNext()) {
				Vertex x = v.next();
				System.out.print(x.name + "" + x.d + "\t");
			}
			System.out.println();

			Vertex u = Q.poll();
			for (Edge e : graph.get(u)) {
				if (e.dest.d > e.srcs.d + e.d) {
					e.dest.d = e.srcs.d + e.d;
					e.dest.pi = e.srcs;
				}
			}

			System.out.println("去掉U");
			Iterator<Vertex> v22 = Q.iterator();
			while (v22.hasNext()) {
				Vertex x = v22.next();
				System.out.print(x.name + "" + x.d + "\t");
			}
			System.out.println();

			// re-order
			Iterator<Vertex> v3 = Q.iterator();
			if (v3.hasNext()) {
				Vertex xx = v3.next();
				Q.remove(xx);
				Q.offer(xx);
			}

			System.out.println("re-sort后");
			Iterator<Vertex> v2 = Q.iterator();
			while (v2.hasNext()) {
				Vertex x = v2.next();
				System.out.print(x.name + "" + x.d + "\t");
			}
			System.out.println();

			System.out.println("循环结束");
			System.out.println();
		}
	}
}

class Vertex {
	char name;
	int d;
	Vertex pi;

	Vertex(char name) {
		this.name = name;
		d = Integer.MAX_VALUE;
		pi = null;
	}
}

class Edge {
	Vertex srcs;
	Vertex dest;
	int d;

	Edge(Vertex srcs, Vertex dest, int d) {
		this.srcs = srcs;
		this.dest = dest;
		this.d = d;

	}
}