package test;
class Tv {
	String color;
	boolean power;
	int channel;
	byte a;
	short b;
	long c;
	float d;
	double e;
	
	void power() { power = !power;	}
	void channerUp() {	++channel; }
	void channerdown() { 	--channel; }
}

public class TvTest {
	public static void main(String[] args) {
	  Tv t1 = new Tv();
	  Tv t2 = new Tv();
	  System.out.println("t1의 채널 : " + t1.channel);
	  System.out.println("t2의 채널 : " + t2.channel);
	  
	  
	  t2 = t1;
	  t1.channel = 7;
	  t2.channerdown();
	  
	  System.out.println("t1의 채널 : " + t1.channel);
	  System.out.println("t2의 채널 : " + t2.channel);

	  System.out.println("---------");
	  System.out.println("boolean : " + t2.power);
	  System.out.println("byte : " + t2.a);
	  System.out.println("short : " + t2.b);
	  System.out.println("long : " + t2.c);
	  System.out.println("float : " + t2.d);
	  System.out.println("double : " + t2.e);
  }
}
