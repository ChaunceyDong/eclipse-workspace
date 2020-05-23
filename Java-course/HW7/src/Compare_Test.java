import java.util.Arrays;
import java.util.Comparator;

public class Compare_Test {

	public static void main(String[] args) {
		Athlete[] athletes = new Athlete[3];
		athletes[0] = new Athlete("C", 188, 120);
		athletes[1] = new Athlete("A", 160, 160);
		athletes[2] = new Athlete("B", 150, 180);

		BasketballPlayer[] BP = new BasketballPlayer[3];
		BP[0] = new BasketballPlayer("D", 140, 120, 9);
		BP[1] = new BasketballPlayer("E", 140, 200, 7);
		BP[2] = new BasketballPlayer("F", 190, 130, 10);

		System.out.println("the default comparision between Athletes based on names");
		Arrays.sort(athletes);
		System.out.println(Arrays.toString(athletes) + "\n");//新技巧，是引用arrays的toString函数
//		for(Athlete a: athletes)
//			System.out.println(a);

		System.out.println("sort the name ascending of Athletes");
		Arrays.sort(athletes, new Comparator<Athlete>() { //现配先用！可以不用之后写一个comparator的class，就在这里写
			public int compare(Athlete o1, Athlete o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
//		Arrays.sort(athletes, new Comparator<Athlete>() {
//			public int compare(Athlete o1, Athlete o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		});
		Arrays.sort(athletes, (o1,o2) -> o1.getName().compareTo(o2.getName()));
		System.out.println(Arrays.toString(athletes) + "\n");

		
		System.out.println("sort the name descending of Athletes");
//		Arrays.sort(athletes, new Comparator<Athlete>() {
//			public int compare(Athlete o1, Athlete o2) {
//				return o2.getName().compareTo(o1.getName());
//			}
//		});
		Arrays.sort(athletes,(o1,o2) -> o2.getName().compareTo(o1.getName()));
		System.out.println(Arrays.toString(athletes) + "\n");

		//---
		System.out.println("sort the height descending of Athletes");
		Arrays.sort(athletes, new Comparator<Athlete>() {
			public int compare(Athlete o1, Athlete o2) {
				return o2.getHeight() - o1.getHeight();
			}
		});
		System.out.println(Arrays.toString(athletes) + "\n");

		//---
		System.out.println("the default comparision between BasketballPlayer based on shoootLv");
		Arrays.sort(BP);
		System.out.println(Arrays.toString(BP) + "\n");

		System.out.println("sort the shootLv ascending of basketball players:");
		Arrays.sort(BP, new Comparator<BasketballPlayer>() {

			public int compare(BasketballPlayer o1, BasketballPlayer o2) {
				return o1.getShootLv() - o2.getShootLv();
			}
		});
		System.out.println(Arrays.toString(BP) + "\n");

		//---
		System.out.println("sort the shootLv descending of basketball players: ");
		Arrays.sort(BP, new Comparator<BasketballPlayer>() {

			public int compare(BasketballPlayer o1, BasketballPlayer o2) {
				return o2.getShootLv() - o1.getShootLv();
			}
		});
		System.out.println(Arrays.toString(BP) + "\n");
	}

}

class Athlete implements Comparable<Athlete> {
	private String name;
	private int height;
	private int weight;

	public Athlete(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return String.format("An Athlete %s with height of %d and wieght of %d", name, height, weight);
	}

	public int compareTo(Athlete o) {
		return o.name.compareTo(name);
	}

	public int getHeight() {
		return height;
	}

}

class BasketballPlayer extends Athlete {//extends继承了comparable的性质，而且还继承了泛型的性质，所以下面的compareTo括号里面直接是Athlete而不是Object

	private int shootLv;

	public BasketballPlayer(String name, int h, int w, int shootLv) {
		super(name, h, w);
		this.shootLv = shootLv;
	}

	public String toString() {
		return String.format("A basketball player %s with shooting level of %d.", getName(), shootLv);
	}

	public int compareTo(Athlete o) { //override函数体（函数名+形参）必须一样，所以（）里面不能是Basketball而是Athlete
		BasketballPlayer p = (BasketballPlayer) o;
		return shootLv - p.shootLv;//int类型是基础的数据类型，他不是类，所以只能用加减而不用comparable
	}

	public int getShootLv() {
		return shootLv;
	}
}