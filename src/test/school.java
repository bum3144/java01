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
	
	
	
	private static void main(String[] args){
		
		
	do{
		String[] values = promptCommand();
		if("add".equals(values[0])){
			
		}else if("list".equals(values[0])){
			
		}else if("delete".equals(values[0])){
			
		}else if("update".equals(values[0])){
			
		}else if("save".equals(values[0])){
			
		}else if("load".equals(values[0])){
			
		}else if("quit".equals(values[0])){
			break;
		}else{
			System.out.println("사용할수 없는 명령입니다.");
		}
	}while(true);
	
	scanner.close();
	}
	
}
