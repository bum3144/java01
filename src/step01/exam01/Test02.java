package step01.exam01;

/* 2. 자바 변수 선언
 * - 자바에서 변수를 선언할 때는 반드시 그 유형을 지정해야 한다.
 * - 자바에서 제공하는 변수의 유형 :
 * 	정수 : byte, short, int, long
 * 	부동소수점: float, double
 * 	문자: char
 * 	논리: boolean
 * 
 * - 대규모 애플리케이션을 개발하기 위한 프로그래밍 언어들은 메모리의 사용을 철저하게 관리한다.
 * 	변수의 용도를 정의해 놓고, 그 용도 대로만 사용하게 한다. => 소스 코드의 유지보수가 명확해 진다.
 * 
 * - 문법
 * 	변수유형(data type) 변수명(variable);
 */


/*
* 자바에서 값의 표현 : Literal
* 4바이트 이하 정수 (약 -21억 ~ 21억) : 11(10진수) = 013(8진수) = 0xb(16진수), 0Xb,0xB, 0XB
* 5바이트 ~ 8바이트 이하 정수값 : 11L = 11l = 013L ... 숫자 뒤에 접미사 L, l을 붙인다.
* 4바이트 이하 부동 소수점 값 : 1.13F = 0.13f (주로 사용)
* ~ 8바이트 부통 수수점 값 : 0.13
*
* - 크기 : 크기에 따라서 다음 4가지로 분류할 수 있다.
*		byte	1 byte(-128 ~ +127)
*		short	2 byte(-32,768 ~ +32,767)
*		int		4 byte(-2,147,483,648 ~ +2,147,483,647)
*		long	8 byte(-9,223,372,036,854,775,808L ~ +9,223,372,036,854,775,807L)
* 
* 문자값 - 문자집합에 정의된 유니코드값 : 44032(가), 0xAC00(가), '가'
* 논리값 - true, false
* 				"가각간, 홍길동"
* 				내부에서는 유니코드 값 배열로 취급한다. [AC00,AC01,AC04,002D,D64D,AE38,B3D9]
* 
 * << 정수의 표현 >>
 * - 0 ~ 9 까지의 숫자를 사용하여 표현.
 * - 기본적으로 10진수를 사용.
 * - 진수의 표현
 *		10진수 : 65
 *		16진수 : 0x41 또는 0X41 (0x 또는 0X 접두어를 붙이고 0 ~ 9, A ~ Z 까지 숫자로 표현)
 *				 대소문자 구분은 하지 않는다!
 *		8진수 : 0101 (0 접두어를 붙이고 0 ~ 7까지 숫자로 표현)
 *	 즉,		65(10진수) = 0X41(16진수) = 0101(8진수) 가 된다.
 * - 2진수는 표현할 수 없다. 보통 16진수로 표현한다.
 * 
 * << int 형 정수와 long 형 정수 >>
 * - 기본적으로 123 등과 같은 수의 표현은 int 형(4바이트) 정수를 의미한다.
 * - long 형(8바이트) 정수의 표현은 숫자 뒤에 접미사 L 또는 l 을 붙인다.
 *		예) 123L, 0xA3l, 0Xa3L 등
 * - 따라서 123 과 123L은 같은 정수이지만 크기가 틀린 정수이다.
 * 
*/
public class Test02 {


	public static void main(String[] args) {
		// 자바의 기본 연산은 int 이다.
		byte b1 = 1;
		byte b2 = 2;
		//byte b3 = b1 + b2; // + 연산 수행 전에 b1 값을 임시 int 변수에 저장
		byte b4 = 1 + 2;	// 상수와 상수의 연산결과는 상수, 상수는 메모리의 범위를 넘지 않으면 허락
		
		short s1 =1;
		//short s2 = b1 + s1; // 연산 수행전에 b1, s1은 임시 int 변수에 저장
	
	  char c = '가';
	  
	  int r1 = s1 + c;	// OK! s1 -> int, c -> int
	  System.out.println(r1);
	}

	public static void main08(String[] args) {
		//boolean : 1바이트 정수 값 저정 (0(false), 1(true))
		//boolean b1 = 1; //오류!
		boolean b2 = true;
		boolean b3 = false;
		
		//boolean b4 = b2 + b3; //오류!		
	}

	public static void main07(String[] args) {
		//char: 2byte 유니코드 값 저장. ( 0 ~ 65535)
		char c1 = 44032;
		char c2 = 0xAC00;
		char c3 = '가';
		char c4 = '\uAC00';
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);		
		System.out.println(c4);		
	}
	
	public static void main06(String[] args) {
		//bouble : 부동소수점 저장, 8 byte (유효자리수)
		// 64비트 = 1비트(부호) + 8비트(지수부) + 52비트(가수부)
		// 정수로 바꿨을 때 6자리라면 안전하게
		double d1 = 0.00345673;	
		System.out.println(d1);
		
		double d2 = 34567300;	
		System.out.println(d2);		

		double d3 = 324.567;	
		double d4 = 4.45678;	

		System.out.println(d3);
		System.out.println(d4);		
		System.out.println(d3+d4);
	}
	

	public static void main05(String[] args) {
		//float : 부동소수점 저장, 4 byte (-? ~ +?)
		// 32비트 = 1비트(부호) + 8비트(지수부) + 23비트(가수부)
		// 정수로 바꿨을 때 6자리라면 안전하게
		float f1 = 0.00345673f;	//789207352
		System.out.println(f1);
		
		float f2 = 34567300f;	//789207352
		System.out.println(f2);
		

		float f3 = 324.567f;	
		float f4 = 4.45678f;	

		System.out.println(f3);
		System.out.println(f4);
		
		System.out.println(f3+f4);
	}
	
	
	public static void main04(String[] args) {
		//long : 정수값 저장. 8byte(약 -922경 ~ 992경)
		long l1 = 10;	// 10(4 byte 정수) => 8 byte 메모리. OK!
		long l2 = 10L;	
		long l3 = 10L;	
	}

	public static void main03(String[] args) {
		//int : 정수값 저장, 4byte(약 -21억 ~ 21억)
		//int i1 = -2147483649;	// 값 표현 오류이다. 4바이트 정수값을 넘는 수는 접미사 L 또는 l을 붙여야 한다.
		//int i1 = -2147483649L;	// 할당 오류. 메모리 범위를 벗어난다.		
	}

	
	public static void main02(String[] args) {
		//short : 정수값 저장. 2 byte(-32768 ~ 32767)
		short s1 = 11;
	  //s1 = -32769;	// 메모리 크기 넘어감. 오류!
	  //s1 = 32768;		// 오류
	}
	
	
	public static void main01(String[] args) {
		
		// byte : 정수값 저장. 1byte (-128 ~ 127)
		byte b1;
		b1 = 20;
	  //b1 = -129;	// 메모리 크기 초가
	  //b1 = 128;		// 메모리 크그 초가
		b1 = 11;	//10진수		
	  System.out.println(b1);
	  
	  //b1 =013;	//8진수
	  System.out.println(b1);

	  b1 =0xB;	//16진수
	  System.out.println(b1);

	  //b1 =11L;	// 8바이트 정수 값을 1바이트 메모리에 담으려하기 때문에 오류!
	  System.out.println(b1);
	  
	}

}
