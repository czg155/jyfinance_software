package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.buy.ModelBuy;

public class BuyDatabase {
	public List<ModelBuy> getBuy() {
		List<ModelBuy> list = new ArrayList<ModelBuy>();
		Connection conn = new DatabaseConnect().getConn();
		if (conn != null) {
			try {
				Statement stmt = (Statement) conn.createStatement();
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
		        conn.close();
		        return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void addBuy(List<ModelBuy> list) {
		Connection conn = new DatabaseConnect().getConn();
		if (conn != null) {
			try {
				Statement stmt = (Statement) conn.createStatement();
				for (int i = 0; i < list.size(); i++) {
					String sql = "insert into buy "
							+ "(number, date, company, product, type, car, weight, tip) "
							+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, list.get(i).getNumber());
					pstmt.setDate(2, new Date(list.get(i).getDate().getTime()));
					pstmt.setString(3, list.get(i).getCompany());
					pstmt.setString(4, list.get(i).getProduct());
					pstmt.setString(5, list.get(i).getType());
					pstmt.setString(6, list.get(i).getCar());
					pstmt.setDouble(7, list.get(i).getWeight());
					pstmt.setString(8, list.get(i).getTip());
					
					int rs = pstmt.executeUpdate();
					if (rs > 0) {
						System.out.println("success");
					}
				}
		        stmt.close();
		        conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
