package com.sh.mini.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.sh.mini.controller.StoreManager;
import com.sh.mini.model.compare.DistanceAscComparator;
import com.sh.mini.model.compare.StarDesComparator;
import com.sh.mini.model.vo.Store;

public class PrintStoreMenu {
	private Scanner sc = new Scanner(System.in);
	private StoreManager stManager = new StoreManager();
	private MainMenu main = new MainMenu();
	
	// 맛집조회메뉴
	public void printStoreMenu() {
		String searchMenu = "--------------- <맛집 조회> ---------------\n" + 
								"1. 전체목록\n"+
								"2. 거리순\n" + 
								"3. 별점순\n" + 
								"4. 카테고리별\n" + 
								"5. 돌아가기\n" + 
								"----------------------------------------\n" + 
								" >> 메뉴 선택 : ";
		while(true) {
			System.out.print(searchMenu);
			String selected = sc.next();

			switch (selected) {
			case "1": main.printStore(stManager.orderBy(null)); break;
			case "2": main.printStore(stManager.orderBy(new DistanceAscComparator())); break;
			case "3": main.printStore(stManager.orderBy(new StarDesComparator())); break;
			case "4": printCategoryMenu(); break; 
			case "5": return;
			default : System.out.println("잘못 입력하셨습니다.");
			}		
		}
	}
	
	// 카테고리목록 메뉴
	public void printCategoryMenu() {
		String searchCate = "--------------- <카테고리 목록> ---------------\n" + 
								"1. 한식\n"+
								"2. 양식\n" + 
								"3. 중식\n" + 
								"4. 디저트\n" + 
								"5. 돌아가기\n" + 
								"----------------------------------------\n" + 
								" >> 메뉴 선택 : ";
		while(true) {
			System.out.print(searchCate);
			String selected = sc.next();

			switch (selected) {
			case "1": main.printStore(stManager.searchCategory("한식")); break;
			case "2": main.printStore(stManager.searchCategory("양식"));break;
			case "3": main.printStore(stManager.searchCategory("중식"));break;
			case "4": main.printStore(stManager.searchCategory("디저트"));break;
			case "5": return;
			default : System.out.println("잘못 입력하셨습니다.");
			}		
		}
	}
	

}
