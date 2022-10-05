package com.sh.io.test2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class StudentMain {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		StudentMain main = new StudentMain();
//		main.test1();
		main.test2();		
	}
	
	/**
	 * student.ser의 내용을 불러와(객체 읽어오기)
	 * 다음과 같이 출력
	 * 
	 * 1 홍길동 80 70 75.5 (평균)
	 * 2 신사임당 90 50 70.0
	 */
	
		// 필드는 그대로 두고 계산으로 만들기! 
	private void test2() {
		File studentFile = new File("students.ser"); // 필드로 빼도 됨.
		
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(studentFile)))){
			
			Student[] students = (Student[]) ois.readObject();
			
			for(Student student : students) {
				System.out.printf("%d %s %d %d %.1f\n", 
									student.getNo(), 
									student.getName(), 
									student.getKor(), 
									student.getEng(), 
									(student.getKor() + student.getEng()) / (double) 2);
			}
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 * 학생 2명의 이름, 국어점수, 영어점수를 입력받아 학생객체를 생성 -> 배열에 추가
	 * - 학생 번호는 1부터 순차적으로 부여
	 * - 생성된 배열을 students.ser에 저장(객체 출력)
	 */
	private void test1() {
		// 배열생성
		Student[] students = new Student[2];
		
		// 객체생성 -> 배열추가
		int no = 1;
		
		for(int i = 0; i < students.length; i++) {
			System.out.print("이름: ");
			String name = sc.next();
			System.out.print("국어점수: ");
			int kor = sc.nextInt();
			System.out.print("영어점수: ");
			int eng = sc.nextInt();
			
			students[i] = new Student(no, name, kor, eng);			
			no++;
			// no를 i+1로 처리 해서 new연산자에 함께 넣기 가능. new Student(i+1, name, kor, eng);
		}
		
		// File객체 생성
		File studentFile = new File("students.ser");
		
		// 객체단위 출력 (저장)                            // 완성형! 성능 향상을위해 Buffered도 끼워 씀. 보조스트림 두개, 주스트림 하나.
		try(ObjectOutputStream oos = new ObjectOutputStream (new BufferedOutputStream(new FileOutputStream(studentFile)))){
			oos.writeObject(students);
			System.out.println("학생정보 저장완료!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
						
		
	}

}
