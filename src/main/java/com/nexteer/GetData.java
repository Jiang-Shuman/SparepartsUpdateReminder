package com.nexteer;

import java.sql.*;
import java.util.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;


public class GetData {

	public static String jsonStr() {
		 // TODO Auto-generated method stub
		 // Create a variable for the connection string.
	      String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
	            "databaseName=Sample; integratedSecurity=true;";
	      String userName = "sa";
	      String passWord = "Nexteer@2021";
	      // Declare the JDBC objects.
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      
	      try {
	         // 连接数据库
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl, userName,  passWord);
	         
	         // 从数据库中取出所有数据
	         String SQL = "SELECT * FROM SpareParts ";
	         stmt = con.createStatement();
	         rs = stmt.executeQuery(SQL);
	         ArrayList<Data> list = new ArrayList<Data>();
	         JSONArray sppJsonArray = new JSONArray();
	         
	         // 将取出的数据放进list中
	         while (rs.next()) {
		         Data spp = new Data();
		         spp.setSp_code(rs.getString("sp_code"));
		         spp.setSp_name(rs.getString("sp_name"));
		         spp.setSp_classification_code(rs.getString("sp_classification_code"));
		         spp.setSp_current_quantity(rs.getInt("sp_current_quantity"));
		         spp.setSp_minimum_quantity(rs.getInt("sp_minimum_quantity"));
		         spp.setSp_unit(rs.getString("sp_unit"));
		         spp.setSp_unit_price(rs.getString("sp_unit_price"));
		         spp.setSp_status(rs.getInt("sp_status"));
	        	 list.add(spp);
		      }

	         // 将list中的数据转化成JSON格式
	         if (list.size() > 0) {
	        	 sppJsonArray = JSONArray.parseArray(JSON.toJSONString(list));
		         String str = sppJsonArray.toJSONString();
		         return str;
	         }
	      }catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      finally {
	         if (rs != null) try { rs.close(); } catch(Exception e) {}
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	         if (con != null) try { con.close(); } catch(Exception e) {}
	      }
	      return "1";
	}
}
