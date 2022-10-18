package com.sh.mini.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.sh.mini.model.vo.Store;
import com.sh.mini.controller.StoreIO;

public class StoreManager {
	private StoreIO storeIO = new StoreIO();
	private List<Store> storeList;
	private Store store;
	
	{   store.setStoreName("짬뽕지존");
	    store.setCategory("중식");
	    store.setDistance(91);
	    store.setAverageStar(3.7);

	    storeList.add(store);
//		storeList.add(new Store("짬뽕지존", "중식", 91, 3.7));
//		storeList.add(new Store("쁠랑커피", "디저트", 71, 4.75));
//		storeList.add(new Store("뢰벤돈까스", "양식", 177, 4.1));
//		
	}
		
	// 파일에 저장
	public StoreManager() {
		List<Store> storeList = storeIO.loadStoreList();
		this.storeList = storeList != null ?
						 storeList : new ArrayList<>();
	}
	
	public List<Store> selectStore(){
		return storeList;
	}
	
	public void addList(Store s) {
		storeList.add(s);
		storeIO.saveStoreList(storeList);
	}
	
	// 정렬메소드
	public List<Store> orderBy(Comparator<Store> c){		
		List<Store> storeList = (List<Store>)((ArrayList<Store>) this.storeList).clone();
		storeList.sort(c);
		
		return storeList;
	}
	
    // 카테고리별 출력 메소드
	public List<Store> searchCategory(String category) {
		List<Store> searchCate = new ArrayList<>();
		for (int i = 0; i < storeList.size(); i++) {
			if (storeList.get(i).getCategory().contains(category))
				searchCate.add(storeList.get(i));
		}

		return storeList;
	}

}
