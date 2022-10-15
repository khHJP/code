package vo;

public class Store implements Comparable<Store> {
	private String storeName;
	private int distance;
	private String category;
	private double averageStar; // 전체 별점 평균
	
	public Store() {
		super();
	}
	public Store(String storeName, int distance, String category, double averageStar) {
		super();
		this.averageStar = averageStar;
		this.storeName = storeName;
		this.distance = distance;
		this.category = category;
	}
	public double getAverageStar() {
		return averageStar;
	}
	public void setAverageStar(double averageStar) {
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
	@Override
	public String toString() {
		return "Store [averageStar=" + averageStar + ", storeName=" + storeName + ", distance=" + distance
				+ ", category=" + category + "]";
	}
	@Override
	public int compareTo(Store o) {
		// TODO Auto-generated method stub
		return this.distance - o.distance;
	}

	

	
}
