package com.sh.mini.model.compare;

import java.util.Comparator;

import com.sh.mini.model.vo.Store;

public class DistanceAscComparator implements Comparator<Store> {

	@Override
	public int compare(Store o1, Store o2) {
		return o1.getDistance() - o2.getDistance();
	}

}
