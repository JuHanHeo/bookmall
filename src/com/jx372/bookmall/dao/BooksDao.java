package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.BooksVo;

public class BooksDao {
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
	public List<BooksVo> getList(){

		Statement stmt = null;
		ResultSet rs = null;
		List<BooksVo> list = new ArrayList<BooksVo>();
		
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			String sql = "select b.no, b.isbn, b.name, b.price, c.name from books b, category c where b.cate_no = c.no order by 1";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				BooksVo vo = new BooksVo();
				vo.setNo(rs.getLong(1));
				vo.setIsbn(rs.getLong(2));
				vo.setName(rs.getString(3));
				vo.setPrice(rs.getLong(4));
				vo.setCateName(rs.getString(5));
				
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
	
	public boolean insert(BooksVo vo){
		
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnect();
			
			String sql = "insert into Books values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getIsbn());
			pstmt.setString(2,vo.getName());
			pstmt.setLong(3, vo.getPrice());
			pstmt.setLong(4, vo.getCateNo());
			
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
			String sql = "select count(*) from books";
			
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