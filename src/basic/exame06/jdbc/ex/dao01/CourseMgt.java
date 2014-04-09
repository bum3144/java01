package basic.exame06.jdbc.ex.dao01;

import java.util.List;
import java.util.Scanner;

import basic.exame06.jdbc.up2.SubjectDao;
import basic.exame06.jdbc.up2.SubjectVo;

public class CourseMgt {

	public static void insert() throws Throwable{
		SubjectVo subject = new SubjectVo();
		subject.title = "요가 수업";
		subject.discription = "젊은 사람들의 웰빙 운동";
		subject.hour = 2;
		
		SubjectDao dao = new SubjectDao();
		dao.insert(subject);
		
		System.out.println("입력 성공!");
	}

	
	
	
	public static void list() throws Throwable{
		SubjectDao dao = new SubjectDao();
		Scanner sc = new Scanner(System.in);
		
		int pageNo = 1, pageSize = 10;
		do{
			List<SubjectVo> list = dao.list(pageNo, pageSize);
			
			System.out.println("[" + pageNo + "]----------------------");
			for(SubjectVo subject : list){
				System.out.print(subject.no);
				System.out.println(subject.title);
			}
			
			pageNo = Integer.parseInt(sc.nextLine());
			
		} while(pageNo > 0);
		
		sc.close();
	}
	
	
	
	public static void update() throws Throwable{
		SubjectDao dao = new SubjectDao();
		SubjectVo subject = new SubjectVo();
		
		subject.no = 100;
		subject.title = "홍길동 노래";
		subject.discription = "홍길동의 역사에 대한 고찰";
		subject.hour = 3;		
		
		dao.update(subject);
		
	}
	
	public static void delete() throws Throwable{
		SubjectDao dao = new SubjectDao();
		Scanner sc = new Scanner(System.in);
		
		dao.delete(Integer.parseInt(sc.nextLine()));
	
		sc.close();
	}	
	
	
	
	public static void detail() throws Throwable {


		SubjectDao dao = new SubjectDao();
		Scanner sc = new Scanner(System.in);
		
		SubjectVo subject = dao.detail(Integer.parseInt(sc.nextLine()));

		System.out.println(subject.no);
		System.out.println(subject.title);
		System.out.println(subject.description);
		
		sc.close();
		
	}
	
	public static void main(String[] args) throws Throwable{
		//insert();
		//list();
		//update();
		//delete();
	}

}















