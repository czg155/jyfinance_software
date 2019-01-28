package app.controller.database;

import java.sql.*;

public class DatabaseConnect {
	public Connection getConn() {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        System.out.println("ÕÒ²»µ½sqlÇý¶¯");
	        return null;
	    }
	    String url="jdbc:mysql://localhost:3306/jyfinance?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";   
	    Connection conn;
	    try {
	        conn = (Connection) DriverManager.getConnection(url,"root","155cheng");
	        return conn;
	    } catch (SQLException e){
	        System.out.println("fail to connect the database!");
	        e.printStackTrace();
	        return null;
	    }
	}
}
