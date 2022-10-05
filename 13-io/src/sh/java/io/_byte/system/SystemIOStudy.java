package sh.java.io._byte.system;
// 패키지 이름으로 byte를 쓸 수 없어서 _byte
// System 표준입력/출력 은 바이트 기반이다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SystemIOStudy {

	public static void main(String[] args) {
		SystemIOStudy study = new SystemIOStudy();
//		study.test1();
//		study.test2();
		study.test3();
		
	}
	/**
	 * 1.5 Scanner 추가 이전엔 사용자 입력값 처리를 어떻게 했을까? 
	 * - Scanner는 예외처리, 형변환 기능을 부가적으로 제공한 것. (직접 할 필요 없음) 
	 * 
	 * - 기본스트림 : 대상과 연결되는 필수스트림(생략불가)
	 * - 보조스트림 : 성능향상/특수한 목적을 위해 추가되는 스트림(선택). 1개 이상 사용가능.
	 *   - 브릿지스트림: byte기반의 주 스트림을 char기반의 보조스트림과 연결하는 목적 (BufferedReader, BufferedWriter와 연결)
	 *   	- InputStreamReader / OutputStreamWriter
	 *   
	 * **보조스트림을 사용하는 경우, 생성된 보조스트림 개게만 제어하면 된다. 
	 */
	private void test3() {
		// 사용 순서가 늘 똑같음. 주스트림 -> 브릿지스트림 -> 보조스트림
		InputStream is = System.in; // 주스트림
		InputStreamReader isr = new InputStreamReader(is); // 브릿지스트림
		BufferedReader br = new BufferedReader(isr); // 보조스트림
		
		// 위 세줄을 한줄로 줄여서 쓴다면
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		is, isr객체는 직접적으로 사용할 일이 없기 때문에 최종 객체만 사용하는 것. 
		System.out.println("아무 글자나 입력하세요...");
		try {
			String data = null;
			while((data = br.readLine()) != null) { // readLine() => Scanner의 nextLine처럼 작동. 문자열 단위로 한줄씩. 
				System.out.println(data);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	

	}

	/**
	 * byte[]을 사용해 read
	 * - 읽어온 byte 수를 반환
	 */
	private void test2() {
		byte[] bf = new byte[256];
		int len = 0; // 읽어온 개수
		System.out.println("아무 글자나 입력하세요...");
		try {
			while((len = System.in.read(bf)) != -1) { // 반복문이 한번 돌았음 -> byte[]에 한번에 읽어옴 (장바구니처럼 사용)
				System.out.println(len + " " + Arrays.toString(bf)); // 읽어온 개수 [byte배열]
			}
		} catch (IOException e) { // 입출력 관련 최상위예외 
			e.printStackTrace();
		}
	}
	

	/**
	 * 표준입력 System.in  사용자 키보드입력
	 *  - byte기반의 입력스트림
	 *  - 입력버퍼가 비어있으면 사용자입력을 기다리는 block상태에 있다가, 
	 *    enter키를 누르면 buffer에서 읽어서 jvm에 전달   
	 * 
	 * 표준출력 System.out 콘솔 (자바를 실행하는 prompt 창)
	 * 
	 * OS별 종료신호(read()의 반환값을 -1로 만듦)
	 * - window cmd ^c (^캐럿 = ctrl)
	 * - mac/unix/linux ^d
	 * - eclipse ^z
	 * 
	 * read() 메소드
	 * - 읽어들인 1바이트의 데이터를 int형으로 반환, 읽어들일 데이터가 없으면 -1반환.
	 */
	private void test1() {
		int data = 0;
		System.out.println("아무 글자나 입력하세요...");
		
		// read()는 더 이상 읽어올 데이터가 없을 때 -1 반환
		try {                      // read()가 IOException 던짐 (checked)
			while((data = System.in.read()) != -1) {  // System.in.read로 데이터를 읽어오고 -1 <- 더이상 읽을 데이터가 없을떄
				System.out.println(data + " " + (char) data); // 1byte씩 반복 읽어옴
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
