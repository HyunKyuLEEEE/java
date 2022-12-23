package db.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentDB {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	public StudentDB(String url, String id, String pw)throws Exception {
		connect(url, id, pw);
		stmt = con.createStatement();
	}
	
	private void connect(String url, String id, String pw) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, id, pw);
        System.out.println("[DB연결 성공]");

	}
}
