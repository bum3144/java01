package basic.exame06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// Statement 사용
// - DBMS에 질의를 수행하는 역할
// - executeQuery() : select 문 수행
// - executeUpdate() :
//				SQL에서 DDL, DML (Data Manipulation Language)을 다룰 때 사용,
//				create, drop, alter, insert, update, delete
// - execute(): DDL(Data Definition Language), DML, DQL(select)
// SQL - insert
// insert 테이블명(컬럼명, 컬럼명,...) values(값, 값,...)
// - 문자열 값은 '' 기호 안에 작성한다. "" 사용불가
// - 숫자는 그냥 작성한다.

public class test02 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.159.1:3306/studydb", // jdbc url
				"study", // username
				"study");	// password
		
		// Connection으로부터 Statement 구현체를 얻는다.
		Statement stmt = con.createStatement();
		
		// DBMS에 질의하기
		// 서베에 질의할 insert 문
		// insert SE_SUBJS(TITLE, DEST) values ('Java기초','자바 기초 문법 강의')
		stmt.executeUpdate("insert SE_SUBJS(TITLE, DEST)"
				+ " values ('Java고급','자바스레드 네트워킹 프로그램')");
		
		System.out.print("입력성공!");
		
		stmt.close();
		con.close();	// 서버에 연결 종료를 요청한다.
		// 만약, close()를 호출하지 않으면 서버는 타임아웃 될 때까지 연결을 유지한다.

	}

}
