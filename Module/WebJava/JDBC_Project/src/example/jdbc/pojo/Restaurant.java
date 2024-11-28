package example.jdbc.pojo;

public class Restaurant {
	
	private int restId;
	private String name;
	private String cuisin;
	private int branchCount;
	
	public Restaurant() {
		
	}

	public Restaurant(int restId, String name, String cuisin, int branchCount) {
		super();
		this.restId = restId;
		this.name = name;
		this.cuisin = cuisin;
		this.branchCount = branchCount;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisin() {
		return cuisin;
	}

	public void setCuisin(String cuisin) {
		this.cuisin = cuisin;
	}

	public int getBranchCount() {
		return branchCount;
	}

	public void setBranchCount(int branchCount) {
		this.branchCount = branchCount;
	}

	@Override
	public String toString() {
		return "Restaurant [restId=" + restId + ", name=" + name + ", cuisin=" + cuisin + ", branchCount=" + branchCount
				+ "]";
	}
}
