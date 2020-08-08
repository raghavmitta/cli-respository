package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.entity.Product;

public class ProductDao {
	public Product select(int id) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			String url="jdbc:derby://localhost:1527/trainingdb";
			String username="raghav";
			String pass="raghav";
			conn=DriverManager.getConnection(url,username,pass);
			System.out.println("Connection Successful");
			String sql="SELECT * FROM tbl_product where id=?";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			if(rs.next()) {
				Product product=new Product();
				product.setName(rs.getString("name"));
				product.setId(rs.getInt("id"));
				product.setPrice(rs.getDouble("price"));
				return product;
			}
			return null;
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
		finally {
			try {conn.close();}catch (Exception e) {}
		}
	}
	public List<Product> selectAll(){
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			String url="jdbc:derby://localhost:1527/trainingdb";
			String username="raghav";
			String pass="raghav";
			conn=DriverManager.getConnection(url,username,pass);
			System.out.println("Connection Successful");
			String sql="SELECT * FROM tbl_product";
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Product product=new Product();
				product.setName(rs.getString("name"));
				product.setId(rs.getInt("id"));
				product.setPrice(rs.getDouble("price"));
				list.add(product);
			}
			return list;
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
		finally {
			try {conn.close();}catch (Exception e) {}
		}
		
	}
	public void insert(Product product) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			String url="jdbc:derby://localhost:1527/trainingdb";
			String username="raghav";
			String pass="raghav";
			conn=DriverManager.getConnection(url,username,pass);
			System.out.println("Connection Successful");
			String sql="INSERT INTO tbl_product values(?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1,product.getId());
			stmt.setString(2,product.getName());
			stmt.setDouble(3,product.getPrice());
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally {
			try {conn.close();}catch (Exception e) {}
		}

		
	}

}
