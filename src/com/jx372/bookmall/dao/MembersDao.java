package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.jx372.bookmall.vo.MembersVo;

public class MembersDao {
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
	public List<MembersVo> getList(){

		Statement stmt = null;
		ResultSet rs = null;
		List<MembersVo> list = new ArrayList<MembersVo>();
		
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			String sql = "select no, name, tel, email, passwd from members";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				MembersVo vo = new MembersVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setPasswd(rs.getString(5));
				list.add(vo);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		
	}
	
	public boolean insert(MembersVo vo){
		
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnect();
			
			String sql = "insert into members values(null, ?, ?, ?, password(?))";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPasswd());
			
			int cnt = pstmt.executeUpdate();
			
			return (cnt==1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public int getCount(){
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			String sql = "select count(*) from members";
			
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
