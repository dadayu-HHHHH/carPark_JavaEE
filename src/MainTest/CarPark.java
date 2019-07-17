package MainTest;

import java.io.IOException;
import java.util.List;

import impl.ChargeImpl;
//import impl.Check;
import impl.MemberImpl;
import impl.ParkingLot;
import pojo.Member;


/**
* @类名  CarPark.java
* @作者      大大鱼
* @版本  V1.0
* @日期  2019年7月6日-上午11:49:49
* @描述  
*
*/

public class CarPark {

	public static void main(String[] args) throws IOException {
		System.out.println("**********************************************");
		System.out.println("*                                            *");
		System.out.println("*               大鱼停车场收费规则                                                   *");  
		System.out.println("*                                            *");
		System.out.println("**********************************************");
		System.out.println("*  临时停放（无视车型）   第一小时100元，每多一小时50元，不封顶    *");
		System.out.println("*  月卡收费（无视车型）   统一收费2000元                                                   *");
		System.out.println("*  高级会员打8折，普通会员不打折，非会员打骨折                                       *");
		System.out.println("**********************************************");
		System.out.println("*            车场我开的，咋收费我乐意，停车场外车辆损坏不负责*");
		System.out.println("**********************************************");
		ParkingLot pl = new ParkingLot();		
		Park p1 = new Park(pl,"粤B123456");
		Park p2 = new Park(pl,"粤A123456");
		Park p3 = new Park(pl,"粤C123456");
		Park p4 = new Park(pl,"粤D123456");
		Park p5 = new Park(pl,"粤B888888");
		Park p6 = new Park(pl,"粤B666666");
		Drive d1 = new Drive(pl);
		Drive d2 = new Drive(pl);
		Drive d3 = new Drive(pl);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		Thread t4 = new Thread(p4);
		Thread t5 = new Thread(p5);
		Thread t6 = new Thread(p6);
		Thread t7 = new Thread(d1,"大大鱼");
		Thread t8 = new Thread(d2,"叶创伟");
		Thread t9 = new Thread(d3,"马奇");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
	}
}

class Park implements Runnable{
	private ParkingLot p;
//	private Check c;
	private String car_no;	

	public Park(ParkingLot p, String car_no) {
		super();
		this.p = p;
		this.car_no = car_no;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			p.park(car_no);  //调用
		}
	}
}

class Drive implements Runnable{
	private ParkingLot p;
	
	
	public Drive(ParkingLot p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			p.drive();  //调用
		}
	}
}

