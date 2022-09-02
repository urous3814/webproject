package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseUtil {
	
	public static Connection getConnection(){
		
		try {
		
			String dbURL = "jdbc:mysql://localhost:3306/LectureEvaluation?characterEncoding=UTF-8&serverTimezone=UTC"; //로컬 호스트 3306포트를 사용하는 mysql 튜토리얼리얼 데이터베이스 사용
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(dbURL,dbID,dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
