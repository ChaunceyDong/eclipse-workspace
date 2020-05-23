package adjacencyLists;

import java.util.*; //   *��ʾ���µĶ���


public class testAdjList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>(); // list�ǳ���class
		List<Integer> neighbors = new ArrayList<Integer>(); // list�ǳ���class�� ����ArrayList����
		neighbors.add(2);
		neighbors.add(5);
		
//		adjList.
		adjList.put(1, neighbors);
		System.out.println(adjList.get(1));
		List<Integer> ls = adjList.get(1);
		

		for(Integer i : ls)
			System.out.println(i);
	}

	
	void listDirect() {
		Map<Integer, List<Integer>> adjL = new TreeMap<>();  //new ����ļ����ſ���ʡ��Integer, List<Integer>����Ϊ��֪����
		
		List<Integer> n1 = new ArrayList<Integer>();

		n1.add(2);
		n1.add(4);
		
		adjL.put(1, n1);
		
	}

}

class Vertex{
	String name;
	String color;
	int d;
	Vertex pi;
	
	public Vertex(String name) {
		this.name = name;
		color = "white";
		d = Integer.MAX_VALUE;
		pi = null;
		
		
	}
	public int hashCode() {
		return name.hashCode();
	}
	
	
	
	
}



