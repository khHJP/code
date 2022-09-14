package sh.java.test.array;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Test4 study = new Test4();
//		study.test1();		
		study.test2();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("전화번호를 입력하세요.");
		char[] num = new char[11]; // 11자리 배열
		num = sc.next().toCharArray(); // 배열로 입력값 받기
		
		char[] code = num.clone(); 
				
		char[] fir = new char[3];
		char[] end = new char[4];
			
		System.arraycopy(code, 0, fir, 0, 3);
		System.arraycopy(code, 7, end, 0, 4);
		
		for(int i = 0; i < fir.length; i++)
			System.out.print(fir[i]);
		
		System.out.print("****");
		
		for(int i = 0; i < end.length; i++)
			System.out.print(end[i]);
				
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("전화번호를 입력하세요.");		
		String num = sc.next(); 
		
		System.out.print(num.substring(0, 3));
		System.out.print("****");
		System.out.print(num.substring(7));
		
		
		
	}
	
}
