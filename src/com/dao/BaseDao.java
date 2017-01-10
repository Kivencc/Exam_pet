package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {
	public Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/exam_pet";
			String user="root";
			String password="123";
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	public void closeAll(ResultSet set,PreparedStatement st,Connection conn){
		if(set!=null){
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int executeUpdate(String sql,Object[] params){
		Connection conn=null;
		PreparedStatement st=null;
		int r=0;
		try {
			conn=getConnection();
			st=conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					st.setObject(i+1, params[i]);
				}
			}
			r=st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, st, conn);
		}
		return r;
	}
}
