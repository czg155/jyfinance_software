package test;

import java.sql.*;
import app.controller.database.DatabaseConnect;

public class Database {
	public static void main(String[] args) {
		//�޸�һ�²���git
		//�޸Ĳ���.gitignore
//		try {
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        System.out.println("�ɹ�����sql����");
//	    } catch (ClassNotFoundException e) {
//	        System.out.println("�Ҳ���sql����");
//	        e.printStackTrace();
//	    }
//	    String url="jdbc:mysql://localhost:3306/jyfinance?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";   
//	    Connection conn;
//	    try {
//	        conn = (Connection) DriverManager.getConnection(url,"root","155cheng");
//	        //����һ��Statement����
//	        Statement stmt = (Statement) conn.createStatement(); //����Statement����
//	        System.out.print("�ɹ����ӵ����ݿ⣡");
//	        ResultSet rs = stmt.executeQuery("select * from buy");
//	        //user Ϊ��������
//	        System.out.println(rs.toString());
//	        while (rs.next()) {
//	            System.out.println(rs.getString("tip"));
//	        }
//	
//	        stmt.close();
//	        conn.close();
//	    } catch (SQLException e){
//	        System.out.println("fail to connect the database!");
//	        e.printStackTrace();
//	    }
		
		Connection conn1 = new DatabaseConnect().getConn();
		Connection conn2 = new DatabaseConnect().getConn();
		if (conn1 != null) {
			try {
				Statement stmt = (Statement) conn1.createStatement();
				ResultSet rs1 = stmt.executeQuery("select * from buy");
				Statement stmt2 = (Statement) conn2.createStatement();
				ResultSet rs2 = stmt2.executeQuery("select * from sale");
				System.out.println(rs2.toString());
		        while (rs2.next()) {
		            System.out.println(rs2.getString("id"));
		        }
				System.out.println(rs2.toString());
		        while (rs1.next()) {
		            System.out.println(rs1.getString("tip"));
		        }
		        stmt.close();
		        conn1.close();
		        stmt2.close();
		        conn2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
