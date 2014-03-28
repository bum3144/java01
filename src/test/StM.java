package test;

import java.util.Scanner;

public class StM {

	static Scanner	scanner	  = new Scanner(System.in);


	public static String promptMenu() {
		System.out.print("메뉴>");
		return scanner.nextLine().toLowerCase();
	}

	public static void main(String[] args) {
		do {
			String menu = promptMenu();

			if ("1".equals(menu)) {
				StC.execute();
			} else if ("2".equals(menu)) {
				StC.execute();
			} else if ("list".equals(menu)) {
				System.out.println("1 학생관리");
				System.out.println("2 성적관리");
				System.out.println("q 종료");
			} else if ("q".equals(menu)) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}

		} while (true);
		scanner.close();
	}

}
