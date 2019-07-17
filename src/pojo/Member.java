package pojo;

/**
* @类名  Member.java
* @作者      大大鱼
* @版本  V1.0
* @日期  2019年7月6日-上午11:45:31
* @描述  
*
*/

public class Member {

	private Integer id;
	private String name;
	private String car_no;
	private String car_type;
	private int balance;
	private Integer creat_date;
	private String card_type;
	
	public Member() {
		super();
	}
	
	public Member(int balance, String car_type) {
		super();
		this.balance = balance;
		this.car_type = car_type;
	}

	public Member(Integer id, String name, String car_no, String car_type, int balance, Integer creat_date,
			String card_type) {
		super();
		this.id = id;
		this.name = name;
		this.car_no = car_no;
		this.car_type = car_type;
		this.balance = balance;
		this.creat_date = creat_date;
		this.card_type = card_type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Integer getCreat_date() {
		return creat_date;
	}
	public void setCreat_date(Integer creat_date) {
		this.creat_date = creat_date;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", car_no=" + car_no + ", car_type=" + car_type + ", balance="
				+ balance + ", creat_date=" + creat_date + ", card_type=" + card_type + "]";
	}

}
