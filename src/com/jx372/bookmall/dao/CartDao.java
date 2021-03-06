package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.CartVo;


public class CartDao {
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
	public List<CartVo> getList(){

		Statement stmt = null;
		ResultSet rs = null;
		List<CartVo> list = new ArrayList<CartVo>();
		
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			String sql = "select c.no, b.name, c.cnt, c.price from cart c, books b where b.no = c.book_no";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				CartVo vo = new CartVo();
				vo.setNo(rs.getLong(1));
				vo.setBookName(rs.getString(2));
				vo.setCnt(rs.getLong(3));
				vo.setPrice(rs.getLong(4));
				
				
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
	
	public boolean insert(CartVo vo){
		
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnect();
			
			String sql = "insert into cart values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1,vo.getMemNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getCnt());
			pstmt.setLong(4, vo.getPrice());
			
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
			String sql = "select count(*) from cart";
			
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
