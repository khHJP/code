package sh.java.io._byte.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

/**
	 * 객체단위 입출력
	 *
	 */
public class ObjectIOStudy {

	public static void main(String[] args) {
		ObjectIOStudy study = new ObjectIOStudy();
//		study.test1();
		study.test2();
	}
	
	/**
	 * User객체 입력하기
	 * 
	 * - User객체를 userFile로부터 읽어오기
	 * 
	 * - target : userFile.ser => FileInputStream(읽어올 대상이 파일), ObjectInputStream(객체단위)
	 */
	private void test2() {
		File userFile = new File("users.ser");
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userFile))){
			// 객체단위 읽기 .readObject()
			Object obj = ois.readObject();  
			// obj는 User객체니까 형변환가능
//			User user = (User) obj;
//			
//			System.out.println(user);
//			System.out.println(user.getUsername());
//			System.out.println(user.getPassword());
//			System.out.println(user.getBirthday());
			
			User[] users = (User[]) obj;
			for(User user : users) {
				System.out.println(user);
				System.out.println(user.getUsername());
				System.out.println(user.getPassword());
				System.out.println(user.getBirthday());
				System.out.println();
			}

		// 상속관계없는 예외 클래스들을 한번에 처리 -> multi - catch 절
		// | 로 여러개 연결
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 * User객체 출력하기
	 * 
	 * - 객체단위로 파일에 쓰기
	 */
	private void test1() {
//		User user = new User("honggd", "1234", LocalDate.of(1999, 9, 9));
//		System.out.println(user);

		// 객체배열이용
		User[] users = {
				new User("honggd", "1234", LocalDate.of(1999, 9, 9)),
				new User("sinsa", "1234", LocalDate.of(1988, 8, 8)),
				new User("leess", "1234", LocalDate.of(1977, 7, 7))
		};
		
		
		// byte단위를 객체단위로 쓰고싶음 -> 기본스트림 FileOUtputStream, 보조스트림 ObjectOutputStream
		
		File userFile = new File("users.ser");
		                                                        // 2진데이터
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userFile))){ // resource문
			// 객체단위 출력 .writeObject(객체)
			oos.writeObject(users); // java.io.NotSerializableException -> user객체에서 Serializable 안했다면 오류.
			System.out.println("users 객체 출력 완료!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	 
	}

}
