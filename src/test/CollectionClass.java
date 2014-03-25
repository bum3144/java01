package test;

public class CollectionClass {
	String name;
	int kor;
	int eng;
	int math;
	
	public CollectionClass(String name) {
	  this.name = name;
  }
	

	public static CollectionClass fromCSV(String value){
		String[] data = value.split(",");
		
		CollectionClass obj = new CollectionClass(data[0]);
		obj.kor = Integer.parseInt(data[1]);
		obj.eng = Integer.parseInt(data[2]);
		obj.math = Integer.parseInt(data[3]);
		
		return obj;
	}
	
	@Override
	public String toString() {
	  return "이름 : " + name + ", 국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math; 
	}
	
}
