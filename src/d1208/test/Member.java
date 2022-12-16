package d1208.test;

import java.sql.Date;

import lombok.Data;




//DTO클래스 : Data Transfer Object ,데이터를 전달하는 목적으로 정의
public class Member {			//불변객체(setter 없으므로 값을 변경못함.) 
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Date joindate;
	private String grade;
	private String city;
	
	public Member(int custno, String custname, String phone, String address, Date joindate, String grade, String city) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Member [custno=" + custno + ", custname=" + custname + ", phone=" + phone + ", address=" + address
				+ ", joindate=" + joindate + ", grade=" + grade + ", city=" + city + "]";
	}
	//
	public int getCustno() {
		return custno;
	}

	

	public String getCustname() {
		return custname;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public Date getJoindate() {
		return joindate;
	}

	public String getGrade() {
		return grade;
	}

	public String getCity() {
		return city;
	}
	
	
	
}