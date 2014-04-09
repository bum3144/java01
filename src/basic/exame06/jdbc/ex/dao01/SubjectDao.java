package basic.exame06.jdbc.ex.dao01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
	
	public void insert(SubjectVo subject) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb"
					,"study"
					,"study");
			
			stmt = con.prepareStatement(
					"insert SE_COURS(TITLE, DEST, HOURS) values(?, ? ,?)"
					);
			stmt.setString(1, subject.title);
			stmt.setString(2, subject.discription);
			stmt.setInt(3, subject.hour);
			
			stmt.executeUpdate();
		}catch(Throwable e){
			throw e;
		}finally{
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}			
		}
	}
	
	public List<SubjectVo> list(int pageNo, int pageSize) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {		
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb",
					"study", "study");
			
			stmt = con.prepareStatement(
					"select CNO.TITLE,DEST,HOURS from SE_COURS"
					+ " order by CNO desc"
					+ " limit ?, ?"	);
			
			stmt.setInt(1, ((pageNo-1)*pageSize));
			stmt.setInt(2, pageSize);
			
			rs = stmt.executeQuery();
			
			ArrayList<SubjectVo> list = new ArrayList<SubjectVo>();
			SubjectVo subject = null;
			
			while(rs.next()){
				subject = new SubjectVo();
				subject.no = rs.getInt("CNO");
				subject.title = rs.getString("TITLE");
				subject.discription = rs.getString("DEST");
				subject.hour = rs.getInt("HOURS");
				
				list.add(subject);
			}
			return list;			
		
		} catch (Throwable e) {
			throw e;
		} finally {
			try {rs.close();} catch (Throwable e2) {}			
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}			
		}
	}
	
	
	
	public SubjectVo detail(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb"
					,"study","study");
			
			stmt = con.prepareStatement(
					"select CNO,TITLE,DEST,HOURS"
					+ " from SE_COURS"
					+ " where SNO = ?");
			
			stmt.setInt(1, no);
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				SubjectVo subject = new SubjectVo();
				subject.no = rs.getInt("CNO");
				subject.title = rs.getString("TITLE");
				subject.discription = rs.getString("DEST");
				subject.hour = rs.getInt("HOURS");				
				
				return subject;
			}else{
				throw new Exception("해당 과목을 찾을 수 없습니다.");
			}			
			
		} catch (Throwable e) {
			throw e;
		} finally {
			try {rs.close();} catch (Throwable e2) {}			
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}			
		}
		
	}
	
	
	
	
	
	public void update(SubjectVo subject) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb",
					"study", "study");
			
			stmt = con.prepareStatement(
					"update SE_COURS set"
					+ " TITLE=?"
					+ ", DEST=?"
					+ ", HOURS=?");
			
			stmt.setString(1, subject.title);
			stmt.setString(2, subject.discription);
			stmt.setInt(3, subject.hour);
			
			stmt.executeUpdate();
			
			System.out.println("변경 성공");
		} catch (Throwable e) {
			throw e;
		} finally {
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}			
		}
	}
	
	public void delete(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb"
					,"study","study");
			
			stmt = con.prepareStatement(
					"delete from SE_COURS"
					+ " where CNO=?");
			
			stmt.setInt(1, no);
			
			stmt.executeUpdate();
			System.out.println("삭제 성공");
			
		} catch (Throwable e) {
			throw e;
		} finally {
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}			
		}
	}
}



















