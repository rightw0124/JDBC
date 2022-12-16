package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest3 {
public static void main(String[] args) {
	
	String sql = "SELECT mt.custno,custname,decode(grade,'A','VIP','B','일반','C','직원') agrade,psum \r\n"
    + "FROM MEMBER_TBL_02 mt\r\n"
	+ "JOIN\r\n"
    + "(  \r\n"
    + "SELECT custno, sum(price) psum \r\n "
    + "FROM MONEY_TBL_02 \r\n "
    + "GROUP BY custno \r\n"
    + ") sale \r\n"
    + "ON mt.custno = sale.custno\r\n"
    + "ORDER BY psum desc";

	Connection conn = OracleUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {pstmt = conn.prepareStatement(sql);			//sql 명령을 인자로 받아 실행할 객체를 생성하여 pstmt가 참조변수
	rs = pstmt.executeQuery();				
	System.out.println("회원매출현황");
	System.out.println(":::::::::::::::::::::");
	while(rs.next()) {
	System.out.println(
	rs.getInt(1) + "\t" + rs.getNString(2) + "\t" + rs.getNString(3) + "\t" + rs.getInt(4) + "\t" );
	}
	} 
	
	
	catch (SQLException e) {
System.out.println(e.getErrorCode());
	}




  }
}
