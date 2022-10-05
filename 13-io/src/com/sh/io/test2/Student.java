package com.sh.io.test2;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * Serialize 완료
	 */
	private static final long serialVersionUID = 1L;
	private int no;
	private String name;
	private int kor;
	private int eng;
	
	public Student() {
		super();
	}
	

	
	public Student(int no, String name, int kor, int eng) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}



	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + "]";
	}

	
}
