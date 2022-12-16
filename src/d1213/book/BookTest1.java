package d1213.book;

import java.sql.SQLException;
import java.util.List;

public class BookTest1 {

	public static void main(String[] args) {

		BookRentDao dao = BookRentDao.getInstance();
		System.out.println(":::모든 회원번호(PK) 조회:::");
		List<Integer> members = null;
		try {
			members = dao.selectAllMember();
			System.out.println(members);
			
		} catch (SQLException e) {
			System.out.println("모든 회원번호 조회 실패!!");
			e.printStackTrace();
		}
		
		System.out.println(":::모든 도서코드(PK) 조회:::");
		List<String> books = null;
		try {
			 books = dao.selectAllBook();
			System.out.println(books);
			
		} catch (SQLException e) {
			System.out.println("모든 도서코드 조회 실패!!");
			e.printStackTrace();
		}
		
		
		System.out.println("::: 모든 회원(PK) 대여 가능 현황 ::: ");
		//반복문 10004 만 false
		
		
		System.out.println("::: 모든 도서(PK) 대여 가능 현황 ::: ");
		//반복문 C1101 만 false
			try {
				for(String s : books)
				System.out.println(s + ":" + dao.isAvailableBook(s));
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}