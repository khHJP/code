package sh.java.io._char.file;
/**
 * 문자기반 스트림
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRWStudy {

	public static void main(String[] args) {
		FileRWStudy study = new FileRWStudy(); // Reader Writer 앞글자
//		study.test1();
		study.test2();
	}

	/**
	 * 문자기반 스트림을 사용한 복사 - text에만 사용
	 */
	private void test2() {
		File file = new File("helloworld.txt"); // "helloworld.txt" 를 가리키는 File 객체
		File copyFile = new File("helloworld-copy3.txt");
		try(
			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter bw = new BufferedWriter(new FileWriter(copyFile))){
			
			String data = null;
			// br.readLine() => 한 줄을 읽어서 개행문자를 제외하고 반환
			while((data = br.readLine()) != null) { // data != null
				bw.write(data); // String출력메소드 지원
				bw.write("\n"); // 개행을 직접 해줘야함 
			}
			System.out.println("파일 복사 완료!!!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * File객체
	 */
	private void test1() {
//		String filename = "helloworld.txt";
		
		// 존재하거나, 존재하지 않는 실제 파일을 가리키는 자바객체. 
		File file = new File("helloworld.txt"); // 자체가 helloworld.txt파일이 아니고 그걸 가리키는 별개의 객체!
		// 해당 파일이 존재하지 않으면 file객체로 생성할수 있음. 

		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file)); 
			BufferedReader br = new BufferedReader(new FileReader(file)); // File객체를 생성자로 받을 수 있다
				){
			int data = 0;
			
			while((data = bis.read()) != -1) {
				System.out.print((char) data + " "); // byte단위 
			}
			
			System.out.println(); // 개행
			
//			while((data = br.read()) != -1) {
//				System.out.print((char) data + " "); // char단위 -> 한글도 깨지지 않음! 
//			}
//			
			System.out.println(); // 개행
			
			// BufferedReader는 라인단위로 읽어오는 기능이 있다.
			String line = null;
			int n = 0; // 라인번호
			while((line = br.readLine()) != null) { // while문 4번 실행해 읽어옴 
				System.out.println(++n + " " + line);
			}
			
		} catch (Exception e) { // FileInputStream이 던짐
		
			e.printStackTrace();
		}
		
	}

}
