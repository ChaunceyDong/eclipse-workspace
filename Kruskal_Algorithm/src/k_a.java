import java.util.*;

public class k_a {

	public static void main(String[] args) {
		new k_a().test();
	}

	void test() {
		// set<Vertex>
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex g = new Vertex("g");
		Vertex h = new Vertex("h");
		Vertex i = new Vertex("i");

		Edge ab = new Edge(4, a, b);
		Edge bc = new Edge(8, b, c);
		Edge cd = new Edge(7, c, d);
		Edge de = new Edge(9, d, e);
		Edge ef = new Edge(10, e, f);
		Edge fg = new Edge(2, f, g);
		Edge gh = new Edge(1, g, h);
		Edge hi = new Edge(7, h, i);

		Edge ah = new Edge(8, a, h);
		Edge bh = new Edge(11, b, h);
		Edge ig = new Edge(6, i, g);
		Edge cf = new Edge(4, c, f);
		Edge df = new Edge(14, d, f);
		Edge ic = new Edge(2, i, c);

		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(ab);
		edges.add(bc);
		edges.add(cd);
		edges.add(de);
		edges.add(ef);
		edges.add(fg);
		edges.add(gh);
		edges.add(hi);
		edges.add(ah);
		edges.add(bh);
		edges.add(ig);
		edges.add(cf);
		edges.add(df);
		edges.add(ic);

		ArrayList<Edge> edges2 = new ArrayList<Edge>();
		edges2.add(ab);
		edges2.add(ah);
		edges2.add(bh);

		System.out.println("----Initialization----");
		for (Edge e1 : edges) {
			System.out.println(e1.src.label + " " + e1.weight + " " + e1.dest.label);
		}
		MST(edges);
	}

	ArrayList<Edge> MST(ArrayList<Edge> edges) {
		ArrayList<Edge> mst = new ArrayList<>(); // 结果树
		ArrayList<Set<Vertex>> inMST = new ArrayList<>();

		// put all elements into allE
		Set<Vertex> allE = new HashSet<>();
		for (Edge e : edges) {
			allE.add(e.dest);
			allE.add(e.src);
		}

		// make  sets for every Vertex
		Iterator<Vertex> ite1 = allE.iterator();
		while (ite1.hasNext()) {
			Set<Vertex> s = new HashSet<>();
			s.add(ite1.next());
			inMST.add(s);
		}

		// for (Set<Vertex> sv : inMST) {
		// for (Vertex v : sv)
		// System.out.println(v.label);
		// }

		// Kruskal’s algorithm
		// sort
		edges.sort((e1, e2) -> e1.weight - e2.weight);

		for (Edge e : edges) {
			Set<Vertex> srcS = new HashSet<>();
			Set<Vertex> destS = new HashSet<>();
			Set<Vertex> alS = new HashSet<>();
			for (Set<Vertex> s : inMST) {
				if (s.contains(e.src)) {
					srcS = s;
					alS.addAll(srcS);
				}
				if (s.contains(e.dest)) {
					destS = s;
					alS.addAll(destS);
				}
			}

			if (!srcS.equals(destS)) {
				mst.add(e);
				inMST.remove(srcS);
				inMST.remove(destS);
				inMST.add(alS);
			}
		}
		System.out.println("----Output----");
		for (Edge ms : mst) {
			System.out.println(ms.src.label + " " + ms.weight + " " + ms.dest.label);
		}
		return mst;
	}

	// 用equal函数就行，不用这个
	// boolean isSetEqual(Set set1, Set set2) {
	//
	// if (set1 == null && set2 == null) {
	// return true; // Both are null
	// }
	//
	// if (set1 == null || set2 == null || set1.size() != set2.size() || set1.size()
	// == 0 || set2.size() == 0) {
	// return false;
	// }
	//
	// Iterator ite1 = set1.iterator();
	// Iterator ite2 = set2.iterator();
	//
	// boolean isFullEqual = true;
	//
	// while (ite2.hasNext()) {
	// if (!set1.contains(ite2.next())) {
	// isFullEqual = false;
	// }
	// }
	// return isFullEqual;
	// }

}

class Vertex {
	String label;

	public Vertex(String label) {
		this.label = label;
	}

	// // 用Vertex的名字，来作为它的hash值，作为它的唯一标识符
	// public int hashCode() {
	// return label.hashCode();
	// }
	//
	// // 判断两个相等的条件为hash值的相同与否
	// public boolean equals(Object obj) {
	// return this.hashCode() == obj.hashCode();
	// }

}

class Edge {
	int weight;
	Vertex src;
	Vertex dest;

	public Edge(int weight, Vertex src, Vertex dest) {
		this.weight = weight;
		this.src = src;
		this.dest = dest;
	}

}