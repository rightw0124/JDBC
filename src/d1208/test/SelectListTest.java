package d1208.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.OracleUtil;

public class SelectListTest {
  //selcet 조회 결과를 ArrayList 타입의 객체로 저장하기 (리스트이 제너릭 타입은 테이블의 구조와 맞는 클래스 정의)
	public static void main(String[] args) throws SQLException {
       
	Connection conn = OracleUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	String sql = "selcet * from member_tbl_02";
	
	pstmt = conn.prepareStatement(sql); //Exeception 처리는 jvm에게 throw
	rs = pstmt.executeQuery();
	List<Member> memberList = new ArrayList<Member>();
	int cnt =0;
	while(rs.next()) {
		Member m = new Member(
		rs.getInt(1),
		rs.getString(2),
		rs.getString(3),
		rs.getString(4),
		rs.getDate(5),
		rs.getString(6),
		rs.getString(7)
		);
	   cnt++;
	   memberList.add(m);
		
	}
	System.out.println("리스트의 크기 : " + memberList.size());
	System.out.println("카운트 값:" + cnt);
      
 }	   
}	  


