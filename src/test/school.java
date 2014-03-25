package test;

import java.util.ArrayList;
import java.util.Scanner;

public class school {

	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<schoolScore> scoreList = new ArrayList<schoolScore>();
	private static String[] promptCommand() {
		System.out.println("명령입력>");
		String input = scanner.nextLine();
		
		return input.split(" ");
	}
	private static void executeAdd(final String value){
		String input;
		
		schoolScore score = schoolScore.fromCSV(value);
		System.out.println("이름:" + score.name);
		System.out.println("국어:" + score.kor);
		System.out.println("영어:" + score.eng);
		System.out.println("수학:" + score.math);
		
		System.out.println("등록할래?(y/n)");
		input = scanner.nextLine();
		if("y".equals(input.toLowerCase())){
			System.out.println("등록됨");
		}else{
			System.out.println("취소됨");
		}		
	}
	
	
	
	
	
}
