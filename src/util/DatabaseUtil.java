package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseUtil {
	
	public static Connection getConnection(){
		
		try {
		
			String dbURL = "jdbc:mysql://localhost:3306/LectureEvaluation?characterEncoding=UTF-8&serverTimezone=UTC"; //���� ȣ��Ʈ 3306��Ʈ�� ����ϴ� mysql Ʃ�丮�󸮾� �����ͺ��̽� ���
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
