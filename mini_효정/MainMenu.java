package com.sh.mini.view;

import java.util.List;
import java.util.Scanner;

import com.sh.mini.model.vo.Member;
import com.sh.mini.model.vo.Review;
import com.sh.mini.model.vo.Store;

public class MainMenu {
	Scanner sc = new Scanner(System.in);
	LoginMenu loginMN = new LoginMenu();
	JoinMenu joinMN = new JoinMenu();
	PrintStoreMenu pStMN = new PrintStoreMenu();
	InputReviewMenu iRvMN = new InputReviewMenu();
	MyReviewMenu myRvMN = new MyReviewMenu();

	public void startMenu() {
		
		
	}
	
	public void mainMenu() {
		String menu = "=============== <OMG Menu> ===============\n" + 
				"1. 로그인\n" + 
				"2. 회원가입\n" + 
				"3. 맛집 조회\n" + 
				"4. 리뷰 작성\n" + 
				"5. 종료\n" + 
				"============================================\n" + 
				">> 메뉴 선택 : ";
	
		while (true) {
			System.out.print(menu);
			String selected = sc.next();
			
//			boolean result = false;
			// 사용자입력에 따른 분기
			switch (selected) {
			case "1": loginMN.loginMenu(); break;
			case "2": joinMN.joinMenu(); break;
			case "3": pStMN.printStoreMenu(); break;
			case "4": iRvMN.inputReviewMenu(); break;
			case "5": return;
			default : System.out.println("잘못 입력하셨습니다.");
			}

		}

	}
	/**
	 * 사용자 입력메소드
	 */
	// 1. 닉네임, 패스워드 => 멤버객체
	public Member inputMemberInfo() {
		System.out.print("닉네임 : ");
		String nickName = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		// 맴버객체 생성 -> 닉네임, 패스워드 대입
		Member member = new Member();
		member.setNickName(nickName);
		member.setPassword(password);
		
		return member;
	}	
	// 2. 가게이름
	public String inputStoreName() {
		System.out.print("가게 이름을 입력하세요: ");
		String storeName = sc.next();
		
		return storeName;
	}	
	// 3. 사용자리뷰, 개별별점 => 리뷰객체
	public Review inputUserReview() {
		System.out.print("별점을 입력하세요(1,2,3,4,5): ");
		int star = sc.nextInt();
		System.out.print("리뷰를 입력하세요: ");
		String userRv = sc.nextLine();
		
		Review review = new Review();
//		Member member = new Member();
//		review.setReviewer(member.getNickName()); 리뷰작성자 받아오는 기능? => InputReviewMenu클래스 처리
		review.setStar(star);
		review.setUserRv(userRv);
		
		return review;
	}
	
	/**
	 * 출력용 메소드(내부출력문) - 출력형식 손보기
	 */
	// 1. Store출력
	public void printStore(List<Store> storeList) {
		System.out.println("==========================================");

		System.out.println("가게이름\t\t카테고리\t\t거리\t\t평균별점");
		System.out.println("------------------------------------");

		for (Store s : storeList)
			System.out.println(s);

		System.out.println("------------------------------------\n");
	}
	// 2. Review출력
	public void printReview(List<Review> reviewList) {
		System.out.println("==========================================");

		System.out.println("가게이름\t\t카테고리\t\t작성자\t\t개별별점\t\t리뷰내용");
		System.out.println("------------------------------------");

		for (Review r : reviewList)
			System.out.println(r);

		System.out.println("------------------------------------\n");

	}

}
