package controller;

import java.util.Set;
import java.util.TreeSet;

import vo.Store;

public class Manager {
	
	private Set<Store> storeSet = new TreeSet<>();
	
	public Manager() {
		// storeSet에 요소추가
		storeSet.add(new Store("짬뽕지존", 200, "중식", 3.5));
		storeSet.add(new Store("빽다방", 300, "디저트", 4.0));		
	}
	
	public void printStore() {
		System.out.println("===============================================================\r\n"
				+ "이름                거리               카테고리                   별점\r\n"
				+ "----------------------------------------------------------------------\r\n"
				);
		System.out.println(storeSet);
		System.out.println();
		}

}
