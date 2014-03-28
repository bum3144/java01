package test;

import java.util.Scanner;

public class StudentMgtSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("명령>");
			String input = scanner.nextLine();
			String[] values = input.split(" ");
			if ("add".equals(values[0])) {
				String[] data = values[1].split(",");
				System.out.println("이름 : " + data[0]);
				System.out.println("국어 : " + data[1]);
				System.out.println("영어 : " + data[2]);
				System.out.println("수학 : " + data[3]);
				System.out.println("등록하시겠습니까?(y/n)");
				input = scanner.nextLine();
				if ("y".equals(input.toLowerCase())) {
					System.out.println("등록되었습니다.");
				} else {
					System.out.println("취소되었다!");
				}
			} else if ("quit".equals(values[0])) {
				System.out.println("프로그램이 종료되었습니다.");
				break;

			} else {
				System.out.println("잘못된 명령어입니다.");
			}
		} while (true);
		scanner.close();
	}

}