package basic.exame06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CourseMgt {

	public static void insert() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", 
				"study", 
				"study");
		
		PreparedStatement stmt = con.prepareStatement(
				"insert SE_SUBJS(TITLE, DEST) values(?, ?)");
		
		stmt.setString(1, "홍길동은 바보다");
		stmt.setInt(2, 3);
		
		stmt.executeUpdate();
		
		System.out.println("입력성공");
		
		stmt.close();
		con.close();
		
	}
	
	public static void list() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", 
				"study", 
				"study");
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select SNO, TITLE, DEST from SE_SUBJS");
		
		while(rs.next()) {
			System.out.print(rs.getInt("SNO") + ",");
			System.out.print(rs.getString("TITLE") + ",");
			System.out.println(rs.getString("DEST"));
		}
		
		rs.close();
		stmt.close();
		con.close(); 

	}
	public static void update() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb",
				"study",
				"study");
		
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate(
				"update SE_SUBJS set"
				+ " TITLE='홍길동'"
				+ " where SNO=1");
		
		System.out.println("변경성공");
		
		stmt.close();
		con.close();
	}
	
	public static void delete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb",
				"study",
				"study");
		
		Statement stmt = con.createStatement(); 
		
		stmt.executeUpdate(
				"delete from SE_SUBJS where SNO=107");
		
		System.out.println("삭제 성공!");
		
		stmt.close();
		con.close();
	}
	
	public static void main(String[] args) throws Exception {
		//insert();
		//list();
		//update();
		//delete();
	}

}















