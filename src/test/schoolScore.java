package test;

public class schoolScore {
	String name;
	int kor;
	int eng;
	int math;
	
	public schoolScore(String name) {
	  this.name = name;
  }
	
	

	public static schoolScore fromCSV(String value){
		String[] data = value.split(",");
		
		schoolScore obj = new schoolScore(data[0]);

		obj.kor = Integer.parseInt(data[1]);
		obj.eng = Integer.parseInt(data[2]);
		obj.math = Integer.parseInt(data[3]);
		
		return obj;	
	}
	
	@Override
	public String toString() {
	  return name + "," + kor + "," + eng + "," + math;
	}
	
	
}
