
public class Hierarchies_Test {

	public static void main(String[] args) {
		Athlete[] athletes = new Athlete[3];
		athletes[0] = new Athlete("Tom", 1, 2);
		athletes[1] = new BasketballPlayer("Jerry", 3, 4, 5);
		athletes[2] = new BaseballPlayer("Jordan", 6, 7, 8);

		for (Athlete a : athletes) {// ****************
			System.out.println(a.getDescription());// ***********
		}
	}
}

class Athlete {
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

	public String getDescription() {// ***********下一行
		return String.format("An Anlete %s with height of %d and weight of %d", getName(), height, weight);
	}
}

class BasketballPlayer extends Athlete {
	private int shootLv;

	public BasketballPlayer(String name, int height, int weight, int shootLv) {
		super(name, height, weight);
		this.shootLv = shootLv;
	}

	public String getDescription() {
		return String.format("A basketball player %s with shooting level of %d.", getName(), shootLv);
	}
}

class BaseballPlayer extends Athlete {
	private int hitLv;

	public BaseballPlayer(String name, int height, int weight, int hitLv) {
		super(name, height, weight);
		this.hitLv = hitLv;
	}

	public String getDescription() {
		return String.format("A baseball player %s with hitting level of %d", getName(), hitLv);
	}
}