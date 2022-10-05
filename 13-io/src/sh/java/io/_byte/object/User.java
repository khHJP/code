package sh.java.io._byte.object;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 객체입출력스트림으로 읽기/쓰기할 클래스는 Serializable 인터페이스 구현 필요
 * serialize : 직렬화
 * 
 * - implements Serializable
 * - serialVersionUID값을 지정(지정하지 않으면 random부여)
 *
 */
public class User implements Serializable { // Serializable 상속 -> 포함한 추상메소드가 하나도없음 : 이런 인터페이스를 marker interface 라고 함!
	                                        // 그냥 하나의 타입으로 제어하려는 목적. 
	                                        // 각 User 객체를 Serializable타입 (부모 인터페이스) 하나로 제어. 
	                                        // 더 찾아보기 
	
	/**
	 * 직렬화/ 역직렬화시 동일한 클래스 검증용으로 사용하는 코드: serialVersionUID 
	 */
	private static final long serialVersionUID = 1L; // private! 공유목적아님		
	       // The serializable class User does not declare a static final serialVersionUID field of type long
			// add default로 UID 지정
	private String username;
	private String password;
	private LocalDate birthday;
	
	public User() {
		super();
	}

	public User(String username, String password, LocalDate birthday) {
		super();
		this.username = username;
		this.password = password;
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	// toString 오버라이드 자동생성가능 
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", birthday=" + birthday + "]";
	}
	
	
}
