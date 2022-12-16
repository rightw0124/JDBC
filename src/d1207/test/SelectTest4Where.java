package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.util.OracleUtil;

    //하드코딩 : driver, user,password 중요한 정보들을 소스에서 집적 설정.(값을 변경하려면 소스코드를 변경) -> 프로퍼티 파일 사용으로 변경

    public class SelectTest4Where {

	public static void main(String[] args) {
		//java.sql 패키지의 인터페이스는 자바API 에 구현클래스는 없습니다. 연관된 다른객체를 통해서 객체가 생성.
		Connection conn = OracleUtil.getConnection();
		System.out.print("연결확인 :");
		System.out.println(conn);			//null 이 출력되면 연결실패.
		
		//SQL select 실행해봅시다. - 새로운 객체 2가지 -> 인터페이스를 통해서 DBMS 종류에 따라 구현체의 객체가 생성
		PreparedStatement pstmt = null;			//sql 실행할 객체를 참조
		ResultSet rs = null;					// select 쿼리 결과 객체를 참조
		String sql = "select * from member_tbl_02 where custno = 100005";
		
		try {
			pstmt = conn.prepareStatement(sql);			//sql 명령을 인자로 받아 실행할 객체를 생성하여 pstmt가 참조변수
			rs = pstmt.executeQuery();					//쿼리 실행하고 그 결과를 객체로 생성하여 rs 가 참조변수
			//while 문으로 변경해보세요.
			System.out.println("검색할 회원 번호 입력 >>>");
			Scanner sc = new Scanner(System.in);
			int custno = Integer.parseInt(sc.nextLine());
			pstmt.setInt(1, custno);
			
			rs = pstmt.executeQuery();
			System.out.println(custno + ": 조회 결과");
			System.out.println(":::::::::::::::::::::::");
			
			int cnt=0;
			if(rs.next()) {
			System.out.println(rs.getInt(1) 
			+ "\t" + rs.getNString(2) 
			+ "\t" + rs.getNString(3) 
			+ "\t" + rs.getNString(4) 
			+ "\t" + rs.getDate(5) 
			+ "\t" + rs.getNString(6)
			+ "\t" + rs.getNString(7) );
	        cnt++;
			}
	        if(cnt==0)
			System.out.println("찾는 회원번호가 없습니다");	
		  }  catch (SQLException e) {
				e.printStackTrace();			//??
			}
			
				
		OracleUtil.close(conn);
		
	} // 메인

} // 클래스 


