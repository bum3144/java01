package test;

public class CardTest{
	public static void main(String[] args){
		System.out.println("카드의 넓이는 : " + Card.width);
		System.out.println("카드의 높이는 : " + Card.height);
		
		Card c1 = new Card();
		c1.kind = "spade";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "heart";
		c2.number = 9;
		
		Card.height = 80;
		Card.width = 100;
		
		c1.height = 500;
		
		System.out.println(c2.height);
		

		System.out.println("카드의 넓이는 : " + Card.width);
		System.out.println("카드의 높이는 : " + Card.height);
	}
}

class Card{
	String kind;
	int number;
	
	static int width = 100;
	static int height = 250;
}