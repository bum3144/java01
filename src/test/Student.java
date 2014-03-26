package test;


public class Student {
	String name;	
	int age;
	String tel;
	String email;
	String address;	

	public Student() {
		
	}


	public Student(String name) {
		this.name = name;
	}
	

	public static Student memCSV(String value) {
		String[] data = value.split(",");
		
		Student mem = new Student(data[0]);

		mem.age = Integer.parseInt(data[1]);
		mem.tel = data[2];
		mem.email = data[3];
		mem.address = data[4];
		
		return mem;
	}

	@Override
  public String toString() {
	  return name + "," + age + "," + tel + "," + email + "," + address;
  }
	
	
}
