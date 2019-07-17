package pojo;

/**
* @类名  Charge.java
* @作者      大大鱼
* @版本  V1.0
* @日期  2019年7月6日-下午11:37:50
* @描述  
*
*/

public class Charge {

	private int car_no;
	private int start_time;
	
	public Charge() {
		super();
	}

	public Charge(int car_no, int start_time) {
		this.car_no = car_no;
		this.start_time = start_time;
	}

	public int getCar_no() {
		return car_no;
	}

	public void setCar_no(int car_no) {
		this.car_no = car_no;
	}

	public int getStart_time() {
		return start_time;
	}

	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}

	@Override
	public String toString() {
		return "Charge [car_no=" + car_no + ", start_time=" + start_time + "]";
	}
	
	
	
}
