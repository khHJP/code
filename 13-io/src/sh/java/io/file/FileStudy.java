package sh.java.io.file;

import java.io.File;
import java.io.IOException;

public class FileStudy {

	public static void main(String[] args) {
		FileStudy study = new FileStudy();
		study.test1();
	}

	/**
	 * java.io.File
	 * - 실제 파일을 가리키는 자바객체 (자체가 파일이 아님)
	 * 
	 */
	private void test1() {
		File file = new File("helloworld.txt");
		System.out.println(file.exists()); // 파일 존재여부
		System.out.println(file.getPath()); // 상대경로
		System.out.println(file.getAbsolutePath()); // 절대경로

		// 존재하지 않는 디렉토리 생성
		File foo = new File("foo");
		System.out.println(foo.exists()); // false
		foo.mkdir(); // foo.라는 디렉토리를 만들어라
		System.out.println(foo.exists()); // true
		System.out.println(foo.isDirectory()); //foo는 디렉토리인가? // true
		
		// 존재하지 않는 디렉토리 여러개 생성
		File kar = new File("foo/bar/too/kar"); // foo디렉토리 밑에 bar, 밑에 too, 밑에 "kar"만을 가리킴
		System.out.println(kar.exists()); // false
		// 여러개의 디렉토리를 만들 때
		kar.mkdirs();
		System.out.println(kar.exists()); // true
		
		// 파일 이동
		File destFile = new File("foo/bar/too/kar/helloworld.txt"); // 존재하지 않는 파일
		file.renameTo(destFile); // 파일 이동
		System.out.println(file.exists()); // false
		System.out.println(destFile.exists()); // true 
		// 기존 file은 사라지고 destFile이 생긴 것. 
		
	}

}
