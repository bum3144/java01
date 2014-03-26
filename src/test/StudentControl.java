package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentControl {

	static Scanner scanner; 
	
	static{
		scanner = StudentMgtSystem.scanner;
	}
	
	// ArrayList에 저장할 인스턴스의 타입을 지정 
	private static ArrayList<Student> memList 
												= new ArrayList<Student>();
	
	
	
	public static void memberAdd(final String value) {
		String input;
		
		Student mem = Student.memCSV(value);
		
		System.out.println("이름:" + mem.name);
		System.out.println("나이:" + mem.age);
		System.out.println("전화번호:" + mem.tel);
		System.out.println("이메일:" + mem.email);
		System.out.println("주소:" + mem.address);
		
		System.out.print("등록하시겠습니까?(y/n)");
		input = scanner.nextLine();
		if ("y".equals(input.toLowerCase())) {
			memList.add(mem);
			//memList.add("okokok"); // StudentScore아니면 넣을 수 없다.
			System.out.println("등록되었습니다.");
		} else {
			System.out.println("등록 취소하였습니다.");
		}
	}
	
	public static void memberList() {
		// ArrayList로부터 꺼낸다.
		// for(변수 : 배열 또는 항목의 타입이 지정된 Collection 구현체)
		int i = 0;
		for (Student mem : memList) {
			System.out.println(i++ + " " + mem);
		}
	}
	
	public static void memberDelete(int no) {
	  if (no >= 0 && no < memList.size()) {
	  	memList.remove(no);
	  	System.out.println("삭제하였습니다.");
	  } else {
	  	System.out.println("유효하지 않은 번호입니다.");
	  }
  }
	
	public static void memberUpdate(int no) {
		if (no >= 0 && no < memList.size()) {
			Student mem = memList.get(no);
			System.out.print("이름(" + mem.name + "):");
			String input = scanner.nextLine();
			Student temp = new Student(input);
			
			System.out.print("나이(" + mem.age + "):");
			input = scanner.nextLine();
			temp.age = Integer.parseInt(input);
			
			System.out.print("전화번호(" + mem.tel + "):");
			input = scanner.nextLine();
			temp.tel = input;
			
			System.out.print("이메일(" + mem.email + "):");
			input = scanner.nextLine();
			temp.email = input;
			
			System.out.print("주소(" + mem.address + "):");
			input = scanner.nextLine();
			temp.address = input;
			
			System.out.print("변경하시겠습니까?(y/n)");
			input = scanner.nextLine();
			if ("y".equals(input.toLowerCase())) {
				memList.set(no, temp);
				System.out.println("변경되었습니다.");
			} else {
				System.out.println("변경 취소하였습니다.");
			}
		} else {
			System.out.println("유효하지 않은 번호입니다.");
		}
  }
	
	public static void memberSave() {
		try {
			FileWriter out = new FileWriter("studentMem.data");
			for(Student score : memList) {
				out.write(score.toString() + "\n");
			}
			out.close();
			System.out.println("저장되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void memberLoad() {
		try {
			FileReader in = new FileReader("studentMem.data");
			Scanner s = new Scanner(in);
			while(true) {
				try {
					memList.add(Student.memCSV(s.nextLine()));
				} catch (NoSuchElementException ex) {
					break;
				}
			}
			s.close();
			in.close();
			System.out.println("로딩되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static void member(){

		do {

			
			String[] values = promptCommandMem();
			
			if ("add".equals(values[0])) {
				memberAdd(values[1]);
			} else if ("list".equals(values[0])) {
				memberList();
			} else if ("delete".equals(values[0])) {
				memberDelete(Integer.parseInt(values[1]));
			} else if ("update".equals(values[0])) {
				memberUpdate(Integer.parseInt(values[1]));
			} else if ("save".equals(values[0])) {
				memberSave();
			} else if ("load".equals(values[0])) {
				memberLoad();
			} else if ("quit".equals(values[0])) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
			
		} while(true);
		
	}
	
	private static String[] promptCommandMem() {
		System.out.print("학생관리>");
		String input = scanner.nextLine(); 
		
		return input.split(" ");
	}
	
	
	
	
}
