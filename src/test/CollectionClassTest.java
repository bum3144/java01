package test;

import java.util.ArrayList;
import java.util.Scanner;


public class CollectionClassTest {
	private static Scanner sc = new Scanner(System.in);	
	private static ArrayList<CollectionClass> scoreList 
											= new ArrayList<CollectionClass>();
	
	private static String[] promptCommand() {
		System.out.print("명령입력>");
		String input = sc.nextLine();
		
		return input.split(" ");
	}
	
	private static void executeList(){
		for(CollectionClass score : scoreList){
			System.out.println(score);
		}
	}
	
	private static void executeAdd(final String value){
		String input;
		
		CollectionClass score = CollectionClass.fromCSV(value);

		System.out.println("이름 : " + score.name);
		System.out.println("국어 : " + score.kor);
		System.out.println("영어 : " + score.eng);
		System.out.println("수학 : " + score.math);
		
		System.out.print("등록하시겠습니까?(y/n)");
		input = sc.nextLine();
		if("y".equals(input.toLowerCase())){
			scoreList.add(score);
			System.out.println("등록완료..OK");
		}else{
			System.out.println("등록취소..!!");
		}
		
	}
	
	
	public static void main(String[] args) {
				
		do{
			String[] values = promptCommand();
			if("add".equals(values[0])){
				executeAdd(values[1]);
			}else if ("list".equals(values[0])){
				executeList();
			}else if ("quit".equals(values[0])){
				System.out.println("바이바이..!!");
				break;
			}else{
				System.out.println("입력명령이 잘못 되었습니다.");
			}
		}while(true);
		
		
	}

}
