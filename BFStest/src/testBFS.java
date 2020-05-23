// awt abstract windows toll  �¼����������õ���
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
		// s��s2 ��name����s����������д�ĵ�HashCode()��equal()���ж���������ͬ��
		for (Vertex v1 : adjacencyL.get(s2))// �������������s��Ҳ������s2
			System.out.println(v1.name);

		
		// BFS
		System.out.println("Breadth-first Search");
		BFS(adjacencyL, s);
	}

	void BFS(Map<Vertex, List<Vertex>> G, Vertex s) {
		
		s.color = "gray";
		s.d = 0;
		s.pi = null;

		Queue<Vertex> Q = new LinkedList<>();// inqueue/dequeue = add�����һ��/pollǰ�浯����
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

	Vertex(String name) { // ����public��Ĭ�ϱ����ڿɼ�
		this.name = name;
		color = "white";
		pi = null;
		d = Integer.MAX_VALUE;
	}

	// ��Vertex�����֣�����Ϊ����hashֵ����Ϊ����Ψһ��ʶ��
	public int hashCode() {
		return name.hashCode();
	}

	// �ж�������ȵ�����Ϊhashֵ����ͬ���
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

}
