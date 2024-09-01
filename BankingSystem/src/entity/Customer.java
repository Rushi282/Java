package entity;

public class Customer {
	
	private String name;
	private String addr;
	private long mobNum;
	public Account acc;

	public Customer() {
		
	}

	public Customer(String name, String addr, long mobNum, Account acc) {
		super();
		this.name = name;
		this.addr = addr;
		this.mobNum = mobNum;
		this.acc = acc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public long getMobNum() {
		return mobNum;
	}

	public void setMobNum(long mobNum) {
		this.mobNum = mobNum;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", addr=" + addr + ", mobNum=" + mobNum + ", acc=" + acc + "]";
	}
	
}
