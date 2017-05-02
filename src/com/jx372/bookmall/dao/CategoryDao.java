package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.CategoryVo;

public class CategoryDao {
	Connection conn = null;
	private Connection getConnect() throws SQLException{



		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/bookmall?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url,"bookmall","bookmall");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	public List<CategoryVo> getList(){

		Statement stmt = null;
		ResultSet rs = null;
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			String sql = "select no, name from category";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				CategoryVo vo = new CategoryVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				
				list.add(vo);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			//자원 정리
			try {
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
	}
	
	public boolean insert(CategoryVo vo){
		
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnect();
			
			String sql = "insert into category values(null, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			
			int cnt = pstmt.executeUpdate();
			
			return (cnt==1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			//자원 정리
			try {
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public int getCount(){
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			String sql = "select count(*) from category c";
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				int cnt = rs.getInt(1);
				 
				return cnt;
				
			}
			return -1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			//자원 정리
			try {
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
