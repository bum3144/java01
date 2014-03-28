package test;

import java.util.Scanner;

public class StudentMgtSystem04 {
private static 	Scanner scanner = new Scanner(System.in);
	
private static StudentScore[] scoreList = new StudentScore[3];
private static int scoreSize;
	private static String[] promptCommend() {
		System.out.print("명령>");
		String input = scanner.nextLine();
		return  input.split(" ");
		
	}
	
	private static void executeAdd(String values) {
	  String input;
	  
	//  StudentScore score = StudentScore.fromCSV(values);
	  
	  if(scoreSize >=0 && scoreSize > 3){
	  	scoreList[scoreSize++] = StudentScore.fromCSV(values);
	  }
	  
	  System.out.println("이름 : " + scoreList[scoreSize - 1].name);
	  System.out.println("국어 : " + scoreList[scoreSize - 1].kor);
	  System.out.println("영어 : " + scoreList[scoreSize - 1].eng);
	  System.out.println("수학 : " + scoreList[scoreSize - 1].math);
	  
	  System.out.print("등록하시겠습니까?(y/n)");
	  input = scanner.nextLine();
	  if ("y".equals(input.toLowerCase())) {
	  	System.out.println("등록되었습니다.");
	  } else {
	  	System.out.println("취소되었다!");
	  }
  }


	public static void main(String[] args) {
		do {
			String input;
      String[] values = promptCommend();
      
			if ("add".equals(values[0])) {
				executeAdd(values[1]);
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