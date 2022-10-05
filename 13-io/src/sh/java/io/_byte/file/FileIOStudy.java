package sh.java.io._byte.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileIOStudy {

	public static void main(String[] args) {
		FileIOStudy study = new FileIOStudy();
//		study.test1();
//		study.test2();
		study.test3();
		System.out.println("---정상종료되었습니다---");
	}
	/**
	 * @실습문제: 
	 * 다운로드에 있는 Stream구분.png 파일을 읽어서 프로젝트루트에 복사하기
	 * 
	 * java 1.7부터 try with resource구문 지원
	 * - 스트림클래스 생성 시 자동으로 반환
	 * - 개수 제한 없이 세미콜론으로 구분
	 * - try(객체1선언; 객체2선언; 객체3선언;){}  => 자동으로 자원반납! 
	 */
	private void test3() {

		String filename = "C:\\Users\\cc894\\OneDrive\\Desktop\\Stream.png"; 
		String copyFilename = "Stream-copy.png";	
		
		// BufferedInputStream 객체 생성
		// BufferedOutputStream 객체 생성

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copyFilename));
				) { // try with resource구문 -> finally로 반환하지 않아도 자동반환!		
			
			// 읽어서 쓰기
			int len = 0;
			byte[] bf = new byte[8192];
			while((len = bis.read(bf)) != -1) {
				System.out.println(len + " " + Arrays.toString(bf));
				bos.write(bf, 0, len); // 읽어 온 개수만큼만 write
			}
			System.out.println("파일 복사 완료!!!");
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}

	/**
	 * 주스트림 + 보조스트림 사용하기
	 * - FileInputStream + BufferedInputStream
	 * - FileOUtputStream + BufferedOutputStream
	 */
	private void test2() {
		String filename = "helloworld.txt";
		String copyFilename = "helloworld-copy2.txt";
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null; // finally 접근을 위해 try문 밖에서 선언
		
		try {
			bis = new BufferedInputStream(new FileInputStream(filename));
			bos = new BufferedOutputStream(new FileOutputStream(copyFilename));
			
			int len = 0;
			byte[] bf = new byte[8192]; // 8kb -> BufferedInputStream 내부적으로 사용하는 버퍼
			while((len = bis.read(bf)) != -1) { // 버퍼로 몇 개 읽었는지 반환하고 -1이 아니라면
				
				System.out.println(len + " " + Arrays.toString(bf)); // 콘솔출력
				bos.write(bf, 0, len); // 0번지부터 ~ 읽어온 마지막 번지까지 파일 출력 // Buffer는 이전에 읽지 않은 내용이 그대로 남아있음. 
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (Exception e) { // NullPointer처리를 위해 Exception으로 받기
				e.printStackTrace();
			}
			try {
				bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 대상이 파일인 입출력
	 *
	 * 파일의 경로
	 * - 상대경로 : 현재위치 기준으로 찾는 경로
	 * 			- 자바프로그램에서는 프로젝트 루트기준(프로젝트 안에서의 최상위)
	 * 			- 파일, 폴더이름부터 시작 
	 * - 절대경로 : 루트부터 시작하는 경로
	 * 			C:\(윈도우), /(맥,리눅스)
	 * 
	 * 모든 스트링객체는 사용후 반납(close)해야 한다. -> 예외 발생 여부와 관계없이 반환해야함 finally
	 * 
	 * - 같은 파일에 대해서는 동시에 입/출력 하지 않아야 함. 문제 발생확률 높음. 
	 * - 예시는 대상 파일이 다르기때문에 ok
	 */
	private void test1() {
//		String copyFilename = "helloworld-copy.txt";
//		String filename = "helloworld.txt"; // 상대경로
		// 위에서 오류 -> finally로 이동 -> fis = null -> NullPointerException 발생
		
		// 절대경로
		String filename = "C:\\Workspaces\\java_workspace\\13-io\\helloworld.txt"; 
		String copyFilename = "C:\\Workspaces\\java_workspace\\13-io\\helloworld-copy.txt";
		
		// try 블럭 밖에서 선언 -> finally에서 접근하기 위해 
		FileInputStream fis = null; // 입력스트림. 
		FileOutputStream fos = null; // 출력스트림. 
		try {
			fis = new FileInputStream(filename); // byte기반 파일 입력 스트림. throws FileNotFoundException
			fos = new FileOutputStream(copyFilename);  
			// 존재하지 않는 파일인 경우 새로 생성. (예외 던지지 않음)
            // 존재하는 파일인 경우 덮어씀. 
			// 기존내용에 실행할 때 마다 이어쓰고 싶다면 (copyFilename, true);
			
			
			int data = 0;
			while((data = fis.read()) != -1) { // throws IOException
				System.out.println(data + " " + (char) data); // 콘솔에 출력
				
				fos.write(data); // 읽어온 1byte를 파일에 출력
			}
		
		} catch(FileNotFoundException e) { // IOException의 자식. 반드시 위에 써야함. // 혹은 부모 하나로 전부 처리 
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally { // 스트링객체 반납
			try {
				fis.close(); // try블럭 내 선언된 변수면 접근 불가. => fis선언을 try문 밖으로 뺴낸다.
				             // throws IOException
				             // fis = null 이라면 NullPointerException 발생 -> Exception으로 처리
				              
			} catch (Exception e) { // finally 내의 예외처리는 try내의 예외처리와 다름! 별개로 처리. 
				e.printStackTrace();
				
			}
			
			// 같은 try절 내에 쓰지 않는 이유? 
			// fis.close(); 에서 예외 발생 -> fos객체는 안닫힘 (try절 예외 발생시 이하 코드 실행 x)
			try {
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
