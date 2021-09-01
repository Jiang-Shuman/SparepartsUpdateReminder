package com.nexteer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlOperation  {
	// Create a variable for the connection string.
	PreparedStatement pstat = null;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
          "databaseName=Sample; integratedSecurity=true;";
    String userName = "sa";
    String passWord = "Nexteer@2021";
    // Declare the JDBC objects.
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
	public SqlOperation() {
		try {
			// 连接数据库
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl, userName,  passWord);
		}catch (Exception e) {
	         e.printStackTrace();
	      }
	}
    
    //新增数据
	public void insertData(String sp_code, String sp_name, String sp_classification_code, int sp_current_quantity, 
			int sp_minimum_quantity, String sp_unit, String sp_unit_price, int sp_status) {
		try {
			String seek = "INSERT INTO SpareParts VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			pstat = con.prepareStatement(seek);
			pstat.setString(1, sp_code);
			pstat.setString(2, sp_name);
			pstat.setString(3, sp_classification_code);
			pstat.setInt(4, sp_current_quantity);
			pstat.setInt(5, sp_minimum_quantity);
			pstat.setString(6, sp_unit);
			pstat.setString(7, sp_unit_price);
			pstat.setInt(8, sp_status);
			
			int res = pstat.executeUpdate();
			System.out.println(res > 0 ? "数据新增成功！" : "数据新增失败！");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    
	//删除数据
	public void deleteData(String sp_code) {
		try {
			String seek = "DELETE FROM SpareParts WHERE sp_code = ?";
			pstat = con.prepareStatement(seek);
			pstat.setString(1, sp_code);
						
			int res = pstat.executeUpdate();
			System.out.println(res > 0 ? "数据删除成功！" : "数据删除失败！");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改数据
	public void updateData(String sp_code, int sp_current_quantity, String sp_unit_price, int sp_status) {
		try {
			String seek = "UPDATE SpareParts SET sp_current_quantity = ?, sp_unit_price = ?, "
					+ "sp_status = ? WHERE sp_code = ?"; //修改备件数量、单价、状态
			pstat = con.prepareStatement(seek);
			pstat.setInt(1, sp_current_quantity);
			pstat.setString(2, sp_unit_price);
			pstat.setInt(3, sp_status);
			pstat.setString(4, sp_code);
						
			int res = pstat.executeUpdate();
			System.out.println(res > 0 ? "数据更新成功！" : "数据更新失败！");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//查询数据
	public void queryData(String sp_code) {
		try {
			String seek = "SELECT * FROM SpareParts WHERE sp_code = ?";
			pstat = con.prepareStatement(seek);
			pstat.setString(1, sp_code);
			rs = pstat.executeQuery();
			System.out.println("编码\t\t名称\t类别\t\t数量\t安全库存\t单位\t单价\t状态");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3)
				 + "\t" + rs.getString(4) + "\t"+rs.getString(5) + "\t"+rs.getString(6) + "\t" + rs.getString(7)
				 + "\t" + rs.getString(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
