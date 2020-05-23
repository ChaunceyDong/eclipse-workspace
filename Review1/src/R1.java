//HomeWork 1

//import java.util.Scanner;
//
//public class R1 {
//	public static void main(String[] args) {
//		Scanner sk = new Scanner(System.in);//***
//		int[] a = new int[10];
//		for(int i = 0; i<a.length; ++i) {
//			a[i] = sk.nextInt();
//		}
//		for (int b=0; b<a.length;++b) {
//			System.out.println(a[b]);
//		}
//		
//	}
//	class array() {
//		public array() {
//			
//		}
//	}
//
//}
//

//--------------------------------
//HomeWork 6
//public class R1 {
//
//	public static void main(String[] args) {
//		Athlete[] athletes = new Athlete[3];
//		athletes[0] = new Athlete("Tom", 1, 2);
//		athletes[1] = new BasketballPlayer("Jerry", 3, 4, 5);
//		athletes[2] = new BaseballPlayer("Jordan", 6, 7, 8);
////		for (Athlete a : athletes) 
////			System.out.println(a.getDescription());
//		
//		for (Athlete a : athletes)
//			System.out.println(a);
//		
////		System.out.println(athletes[0]);
//	}
//}
//
//class Athlete {
//	private String name;
//	private int height;
//	private int weight;
//		
//	public Athlete(String name, int height, int weight) {
//		this.name = name;
//		this.height = height;
//		this.weight = weight;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	
////	public String getDescription() {
////		return String.format("An Anlete %s with height of %d and weight of %d", name, height, weight);
////	}
//	
//	public String toString() {
//		return "An Anlete \t" +name+ "\twith height";
//	}
//}
//
//class BasketballPlayer extends Athlete {
//	private int lv;
//	
//	public BasketballPlayer(String name, int height, int weight, int lv) {
//		super(name,height,weight);
//		this.lv = lv;
//	}
//	
//	public int getLv() {
//		return lv;
//	}
//	
////	public String getDescription() {
////		return String.format("Basketbal%s, lv:%d",getName(),lv);
////	}
//	
//	public String toString() {
//		return "An Basketbal \t" + getName()+ "\twith height";
//	}
//}
//
//class BaseballPlayer extends Athlete {
//	private int hitLv;
//	
//	public BaseballPlayer(String name, int height, int weight, int hitLv) {
//		super(name, height, weight);
//		this.hitLv = hitLv;
//	}
//	
//	public int getHitLv() {
//		return hitLv;
//	}
//	
////	public String getDescription() {
////		return String.format("A baseball player %s with hitting level of %d",getName(),hitLv);
////	}
//	
//	public String toString() {
//		return "An baseball\t" + getName() + "\t"+ hitLv;
//	}
//}
//--------------------------------
//HomeWork 4





