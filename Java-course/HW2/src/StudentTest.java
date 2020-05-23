public class StudentTest {

	public static void main(String[] args) {
		// define an array of Student
		Student[] stu = new Student[4];
		// new的是数组
		stu[0] = new Student(150001, "HanMei", 'F', 19, "E-Commerce", 10);// char是单引号'',不是双引号""
		// new的是构造函数Student
		stu[1] = new Student(150002, "Lilei", 'M', 20, "E-Commerce", 10);
		stu[2] = new Student(160001, "Tom", 'M', 19, "Bioinformatics", 10);
		stu[3] = new Student(160002, "Jerry", 'M', 18, "Bioinformatics", 10);

		// 选课enroll

		// 对象名.method名
		// stu[0].enroll("DB")
		// 以下用循环实现

		String[][] S = { { "DB\t", "Java\t", "Econmics" }, { "DB\t", "Java\t", "Data Structures" },
				{ "Biology\t", "Java\t", "Data Structures" }, { "DB\t", "Java\t", "Data Structures" } };

		for (int i = 0; i < 4; ++i) {
			for (int b = 0; b < 3; ++b) {
				stu[i].enroll(S[i][b]);
			}
		}
		System.out.println("ID" + "\t" + "Name" + "\t" + "Gender" + "\t" + "Age" + "\t" + "Major" + "\t");
		for (Student e : stu) {
			System.out.println(
					e.getId() + "\t" + e.getName() + "\t" + e.getGender() + "\t" + e.getAge() + "\t" + e.getMajor());
		}
		for (int a = 0; a < 4; ++a) {
			System.out.println("These are courses of student_" + stu[a].getName() + ":");

			for (String c : stu[a].getCourses())// *************
				if (c != null)
					System.out.print(c);//*********
			System.out.print("\n");

		}
	}
}

class Student {
	// fields
	private long id;
	private String name;
	private char gender;
	private int age;
	private String major;
	private String[] courses;// **********

	// constructor
	public Student(long i, String name, char gender, int age, String major, int maxCourses) { // 注意courses没写，并且加了一个Max数量
		id = i;
		this.name = name;
		this.age = age; // 因为形参和它重名了，所以加一个this
		this.gender = gender;
		this.major = major;
		this.courses = new String[maxCourses]; // ********
	}

	// methods
	public long getId() {// 无输入，有输出
		return id;
	}

	public String getName() {// public不写也行
		return name;
	}

	public char getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String getMajor() {
		return major;
	}

	public String[] getCourses() {
		return courses;
	}

	boolean enroll(String course) {// 把course放在数组courses里，放在第几个？这时候用这个函数
		for (int i = 0; i < courses.length; ++i) {
			if (courses[i] == null) {// 如果这个是空的，那就把这个course放进来
				courses[i] = course;// 数组courses是在17行定义的，后面的course是在course定义的
				return true;// 放进去成功，插入成功，选课成功，返回true
			}
		}
		return false;// 返回false是在for循环之后，全部转完一圈，都没有空的地方给我放课，这时候返回false
	}
}