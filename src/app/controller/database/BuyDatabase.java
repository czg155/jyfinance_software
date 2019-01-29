package app.controller.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.buy.ModelBuy;

public class BuyDatabase {
	public List<ModelBuy> getBuy() {
		List<ModelBuy> list = new ArrayList<ModelBuy>();
		Connection conn1 = new DatabaseConnect().getConn();
		if (conn1 != null) {
			try {
				Statement stmt = (Statement) conn1.createStatement();
				ResultSet rs = stmt.executeQuery("select * from buy");
				while (rs.next()) {
					ModelBuy buy = new ModelBuy();
					buy.setNumber(rs.getString("number"));
					buy.setDate(rs.getDate("date"));
				    buy.setCompany(rs.getString("company"));
				    buy.setProduct(rs.getString("product"));
				    buy.setType(rs.getString("type"));
				    buy.setCar(rs.getString("car"));
				    buy.setWeight(rs.getDouble("weight"));
				    list.add(buy);
				}
		        stmt.close();
		        conn1.close();
		        return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
