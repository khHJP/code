package com.sh.mini.model.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Store implements Comparable<Store>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String storeName;
	private int distance;
	private String category;
	private double averageStar;
	private List<Review> reviews;


	
	public Store() {}
	
	public Store(String storeName, String category, double averageStar, int distance, List<Review> reviews) {
		super();
		this.storeName = storeName;
		this.distance = distance;
		this.category = category;
		this.averageStar = averageStar;
		this.reviews = reviews;
	}

	public Store(String storeName, String category, int distance, double averageStar) {
		super();
		this.storeName = storeName;
		this.distance = distance;
		this.category = category;
		this.averageStar = averageStar;
	}
	

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAverageStar() {
		return averageStar;
	}

	public void setAverageStar(double averageStar) {
		this.averageStar = averageStar;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int compareTo(Store o) {
		return this.storeName.compareTo(o.storeName);
	}


	@Override
	public String toString() {
		return storeName + "\t " + category + "\t " + distance + "m \t " + averageStar + "\t "+ reviews;
	}

	@Override
	public int hashCode() {
		return Objects.hash(averageStar, category, distance, reviews, storeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		return Double.doubleToLongBits(averageStar) == Double.doubleToLongBits(other.averageStar)
				&& Objects.equals(category, other.category) && distance == other.distance
				&& Objects.equals(reviews, other.reviews) && Objects.equals(storeName, other.storeName);
	}

	
	
	
}
