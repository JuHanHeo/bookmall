package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.OrderListVo;
import com.jx372.bookmall.vo.OrdersVo;


public class OrdersDao {
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
	public List<OrdersVo> getOList(){

		Statement stmt = null;
		ResultSet rs = null;
		List<OrdersVo> list = new ArrayList<OrdersVo>();
		
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			String sql = "select o.no, concat(m.name,\'/\',m.email), o.price, o.address from orders o, members m where m.no = o.mem_no";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				OrdersVo vo = new OrdersVo();
				vo.setNo(rs.getLong(1));
				vo.setMemName(rs.getString(2));
				vo.setPrice(rs.getLong(3));
				vo.setAdd(rs.getString(4));
				
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
	
	public boolean insertO(OrdersVo vo){
		
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnect();
			
			String sql = "insert into orders values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getMemNo());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setString(3, vo.getAdd());
			
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
	public List<OrderListVo> getOLList(){

		Statement stmt = null;
		ResultSet rs = null;
		List<OrderListVo> list = new ArrayList<OrderListVo>();
		
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			String sql = "select o.no, o.or_no, o.book_no, o.cnt, b.name from order_list o, books b where o.book_no = b.no";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				OrderListVo vo = new OrderListVo();
				vo.setNo(rs.getLong(1));
				vo.setOrNo(rs.getLong(2));
				vo.setBookNo(rs.getLong(3));
				vo.setCnt(rs.getLong(4));
				vo.setBookName(rs.getString(5));
				
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
	
	public boolean insertOL(OrderListVo vo){
		
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnect();
			
			String sql = "insert into order_list values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getOrNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getCnt());
			
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
	public int getOCount(){
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			String sql = "select count(*) from orders";
			
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
	public int getOLCount(){
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			String sql = "select count(*) from order_list";
			
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
