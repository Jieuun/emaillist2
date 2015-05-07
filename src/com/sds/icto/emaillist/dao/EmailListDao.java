package com.sds.icto.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.sds.icto.emaillist.vo.EmailListVo;


public class EmailListDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2 디비 콘 생성
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dburl, "webdb", "webdb");

		return conn;

	}

	public void insert(EmailListVo vo) throws SQLException,
			ClassNotFoundException {

		// connection 생성
		Connection conn = getConnection();

		// statement sql 준비
		String sql = "insert into EMAIL_LIST VALUES(EMAIL_LIST_no_seq.nextval, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 바인딩
		pstmt.setString(1, vo.getFirstName());
		pstmt.setString(2, vo.getLastName());
		pstmt.setString(3, vo.getEmail());

		// query 설정
		pstmt.executeUpdate();

		// 자원정리

		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

	public List<EmailListVo> fetchlist() throws ClassNotFoundException,
			SQLException {
		List<EmailListVo> list = new ArrayList<EmailListVo>();

		// 1 connection 생성
		Connection conn = getConnection();

		Statement stmt = conn.createStatement();

		String sql = "select * from email_list";
		ResultSet rs = stmt.executeQuery(sql);

		// 4 결과처리
		while (rs.next()) {
			Long no = rs.getLong(1);
			String first_name = rs.getString(2);
			String last_name = rs.getString(3);
			String email = rs.getString(4);
			
			EmailListVo vo = new EmailListVo();
			vo.setNo(no);
			vo.setFirstName(first_name);
			vo.setLastName(last_name);
			vo.setEmail(email);
			

			list.add(vo);
		}
		// 5 자원정리
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}

		return list;

	}
	
	public void delete() throws ClassNotFoundException, SQLException{
	
		// 1 connection 생성
		Connection conn = getConnection();

		Statement stmt = conn.createStatement();

		String sql = "delete from email_list";
		stmt.executeUpdate(sql);
		
		//4. 자원정리
		
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		
	}
	
}
