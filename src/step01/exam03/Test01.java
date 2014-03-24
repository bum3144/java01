package step01.exam03;

/*
 * 문자열 다루기
 * - C에서는 char[] 배열로 다룬다.
 * - 자바에서도 char[] 배열로 다룬다. 
 * -> 내부의 복잡한 명령어를 감추고 (갭슐화) 
 * -> java.lang.String 클래스 제공
 */
public class Test01 {

	public static void main(String[] args) {
		// 스트링버퍼의 비교
		StringBuffer s1 = new StringBuffer("나는 홍길동이다.");
		StringBuffer s2 = new StringBuffer("나는 홍길동이다.");

		// 주소가 같은지 비교		
		if(s1 == s2) System.out.println("s1 == s2");	// X
		
		// 주소 같은지 비교 => equals만 내용을 비교함. 	
		if(s1.equals(s2)) System.out.println("s1.equals(s2)");	// 0
	}

	public static void main08 (String[] args) {
		// 스트링의 비교
		String s1 = new String("나는 홍길동이다.");
		String s2 = new String("나는 홍길동이다.");

		// 인스턴스가 같은지 비교 => 주소가 같은지 비교		
		if(s1 == s2) System.out.println("s1 == s2");	// X
		
		// 내용물이 같은지 비교 <= String 클래스에서 상속받은 equals()를 재정의 하였다.
		if(s1.equals(s2)) System.out.println("s1.equals(s2)");	// 0
	}
	
	
	
	public static void main07 (String[] args) {
		// Heap에 있는 스트링 인스턴스를 Constant Poll에 복제하기
		String s1 = new String("나는 홍길동이다.");
		String s2 = s1.intern();	// 상수풀에 복제한다.
		String s3 = "나는 홍길동이다.";
		
		if(s2 == s3) System.out.println("s2 == s3");	// o
	}	


	public static void main06 (String[] args) {
		// 상수 스트링의 substring() 리턴값 => Heap에 저장된다.
		String s1 = "나는 홍길동이다.";
		String s2 = s1.substring(3);
		String s3 = s1.substring(3);
		if(s2 == s3) System.out.println("s2 == s3");	// X
	}

	public static void main05 (String[] args) {
		// 상수 스트링
		// - new String() 의 단축 명령이다.
		// - 상수 스트링으로 만든 인스턴스는 Constant Poll에 존재한다.
		// - 중복해서 생성되지 않는다. => 메모리 절약 위해
		String s1 = new String("나는 홍길동이다.");
		String s2 = "나는 홍길동이다.";	// => new String("나는 홍길동이다.")의 단축! 상수 스트링
		String s3 = "나는 홍길동이다.";
		
		System.out.println(s1);		
		System.out.println(s2);		

		if(s1 == s2) System.out.println("s1 == s2");	// X
		if(s1 == s3) System.out.println("s1 == s3");	// X
		if(s2 == s3) System.out.println("s2 == s3");	// 0
	}
	
	
	public static void main04 (String[] args) {
		// mutable vs immutable 테스트
		// String 인스턴의 값은 변경된지 않는다! ==? immutable
		String s1 = new String("나는 홍길동이다.");
		String s2 = s1.replace("홍길동", "슈퍼맨");	// 새 String 인스턴스 생성 후 리턴

		System.out.println(s1);		
		System.out.println(s2);		
		
		// StringBuffer 클래스: mutable
		StringBuffer s3 = new StringBuffer("나는 홍길동이다.");
		s3.replace(3, 6, "임꺽정");
		System.out.println(s3);
	}
	
	
	public static void main03 (String[] args) {
		String s1 = new String("나는 홍길동이다.");
			
		System.out.println(s1.charAt(3));	//해당 인덱스의 문자 찾기
		
		System.out.println(s1.indexOf('홍'));	//해당 문자의 인덱스 찾기
		// String 클래스의 indexOf 메소드를 호출하는데 함수 앞에 있는 변수의 s1 주소값을 indexOf 내부의 
		// 히든 변수 this라는 변수에 저장하고 this라는 변수를 이용하여 
		// indexOf의 파라미터로 넘어온 '홍'의 배열 위치를 찾는다 

		String s2 = s1.substring(3);	// 새 String 인스턴스를 생성하여 리턴
		String s3 = s1.substring(3);	// 새 String 인스턴스를 생성하여 리턴

		System.out.println(s2);
		System.out.println(s3);
		
		if(s2 == s3){
			System.out.println("s2 == s3");			
		}else{
			System.out.println("s2 != s3");	
		}
	}


	public static void main02 (String[] args) {
		String s1 = new String("나는 홍길동이다.");
		String s2 = new String("나는 홍길동이다.");
		
		// s1 과 s2는 주소가 다르다
		if (s1 == s2){
			System.out.println("s1 == s2");
		}else{
			System.out.println("s1 != s2");	
		}
	}

	public static void main01 (String[] args) {

		String s1 = new String("나는 홍길동이다.");
		String s2 = s1;
		String s3 = s2;
		
	
		
		System.out.println(s3);
	}

}
