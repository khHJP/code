package sh.java.test.array;

import java.util.Scanner;

/**
 *     주민등록번호 성별자리 이후부터 *로 가리기.  
    단, 원본 배열값은 변경 없이 배열 복사본으로 
    변경하세요
     
        힌트) 복사방법
       - for문이용 1:1대입
       - System.arraycopy() 매소드 이용
       - Arrays.copyOf() 매소드 이용
       - clone() 매소드 이용
 * @author USER
 *
 */
public class Test5 {
	public static void main(String[] args) {
		Test5 study = new Test5();
		study.test();
	}
	
	public void test() {
		int resNum[] = new int[13]; 
		Scanner sc = new Scanner(System.in);
		System.out.println("주민등록번호를 입력하세요.");
		
		for (int i = 0; i < resNum.length; i++) {
			resNum [i] = sc.nextInt();
		}
		
		for (int i = 0; i<resNum.length; i++) {
			System.out.println(resNum[i]);
		}
		
	}
}
