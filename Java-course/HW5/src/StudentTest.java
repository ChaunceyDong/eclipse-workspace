//亮点在45行

public class StudentTest {

	public static void main(String[] args) {
		Person p = new Person(1501, "Hanmei", 'F', 18);
		Student s = new Student(1502, "Lilei", 'M', 18, 3.4, "Economics");
		System.out.println(p);
		System.out.println(s);
	}
}

class Person {
	private int id;
	private String name;
	private char gender;
	private int age;

	public Person(int id, String name, char gender, int age) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public char getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String toString() {// super只能在construction用
		return id + "\t" + name + "\t" + gender + "\t" + age; // java里面啥都可以转成字符串
	}
}

class Student extends Person {
	private double gpa;
	private String major;

	public Student(int id, String name, char gender, int age, double gpa, String major) {
		super(id, name, gender, age);
		this.gpa = gpa;
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public String getMajor() {
		return major;
	}

	public String toString() {
		return getId() + "\t" + getName() + "\t" + getGender() + "\t" + getAge() + "\t" + gpa + "\t" + major;
	}

}