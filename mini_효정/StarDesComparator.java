package com.sh.mini.model.compare;

import java.util.Comparator;

import com.sh.mini.model.vo.Store;

public class StarDesComparator implements Comparator<Store> {

	@Override
	public int compare(Store o1, Store o2) {
//		if(o1.getAverageStar() == o2.getAverageStar()) {
//			return o1.getStoreName().compareTo(o2.getStoreName());
//		}
		return Double.compare(o2.getAverageStar(), o1.getAverageStar());
	}

}
