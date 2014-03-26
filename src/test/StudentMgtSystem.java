package test;

/* FileReader 사용
 * - 문자 데이터를 읽어들일 때 사용하는 클래스
 * - 문자 데이터 읽기에 관련된 메서드가 들어 있다.
 * - 바이너리 데이터(메모장에서 편집 불가 데이터)의 읽기는 
 *  FileInputStream 클래스 사용
 * 
 */
import java.util.Scanner;

public class StudentMgtSystem {
	static Scanner scanner = new Scanner(System.in);
	
	private static String promptMenu() {
		System.out.print("명령을 입력>");
		return scanner.nextLine().toLowerCase(); 
		
	}
	
	public static void main(String[] args) {
		do {

			System.out.println("┌─────┐");
			System.out.println("│1 학생관리│");
			System.out.println("│2 점수관리│");
			System.out.println("│q 종료    │");
			System.out.println("└─────┘");
			System.out.println();
			
			String menu = promptMenu();
			if ("1".equals(menu)) {
				StudentControl.member();
			} else if ("2".equals(menu)) {
				StudentScoreControl.execute();
			} else if ("list".equals(menu)) {
				System.out.println("1 학생관리");
				System.out.println("2 점수관리");
				System.out.println("q 종료");

			} else if ("q".equals(menu)) {
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
			
		} while(true);

		scanner.close();
	}




}













