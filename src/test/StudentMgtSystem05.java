package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMgtSystem05 {
private static 	Scanner scanner = new Scanner(System.in);
	

private static ArrayList<StudentScore> scoreList = new ArrayList<StudentScore>();

	private static String[] promptCommend() {
		System.out.print("명령>");
		String input = scanner.nextLine();
		return  input.split(" ");		
	}
	
	private static void executeAdd(String values) {
	  String input;
	  
	  StudentScore score = StudentScore.fromCSV(values);
	  
	  System.out.println("이름 : " + score.name);
	  System.out.println("국어 : " + score.kor);
	  System.out.println("영어 : " + score.eng);
	  System.out.println("수학 : " + score.math);
	  
	  System.out.print("등록하시겠습니까?(y/n)");
	  input = scanner.nextLine();
	  if ("y".equals(input.toLowerCase())) {
	  	scoreList.add(score);
	  	System.out.println("등록되었습니다.");
	  } else {
	  	System.out.println("취소되었다!");
	  }
  }
	
	private static void executeList() {	
		for(int i=0;i<scoreList.size();i++){
			System.out.println(i + " " + scoreList.get(i));
		}
		
	}

	private static void executeSave() {
		
	  try {
	    FileWriter out = new FileWriter("test1.dat");
	    for(StudentScore score : scoreList){
	    	out.write(score + "\n");
	    	System.out.println("저장완료");
	    }
	    out.close();	    
    } catch (IOException e) {
	    e.printStackTrace();
    }	  
  }

	private static void executeLoad() {
	  try {
	    FileReader in = new FileReader("test1.dat");
	    Scanner s = new Scanner(in);
	    while(true){
	    	
	    	scoreList.add(StudentScore.fromCSV(s.nextLine()));
	    	
	    }
	    
    } catch (Exception e) {
	    e.printStackTrace();
    }
	  
  }

	
	public static void main(String[] args) {
		do {
			String input;
      String[] values = promptCommend();
      
			if ("add".equals(values[0])) {
				executeAdd(values[1]);
			} else if ("list".equals(values[0])) {
				executeList();
			}  else if ("save".equals(values[0])) {
				executeSave();
			}  else if ("load".equals(values[0])) {
				executeLoad();
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