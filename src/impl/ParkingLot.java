package impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pojo.Member;

/**
* @类名  ParkingLot.java
* @作者      大大鱼
* @版本  V1.0
* @日期  2019年6月29日-下午8:35:39
* @描述  
*
*/

public class ParkingLot {
	boolean[] park = { true, true, true }; // true 表示可以停车
    Map<Integer, String> map = new HashMap<>();
    
    private int getPos(){
        float ran = (float) Math.random() * 2;
        int pos = Math.round(ran);
        return pos;
    }

	// 返回false表示有车位.true表示停满
	private boolean isFull() {
		int p = 0;
		for (int i = 0; i < 3; i++) {
			if (!park[i]) {
				p++;
			}
		}
		return p == 3;
	}
	//返回true 代表全空
	private boolean isEmpty() { // 判断是否全空
		int p = 0;
		for (int i = 0; i < 3; i++) {
			if (park[i]) {
				p++;
			}
		}
		return p == 3;
	}

	// 判断哪个是车位不是空的
	private int whichEmpty() {
		while (true) {
			int pos = getPos();
			if(park[pos]){
				return pos;
			}		
		}
	}

	// 判断哪个是车位不是空的
	private int whichFull() {
		while (true) {
			int pos = getPos();
			if(!park[pos]){
				return pos;
			}		
		}
	}
		
	
	//实现停车的同步方法
	public synchronized void park(String car_no) {
		notifyAll();
		// 判断是否有空余车位
		if (isFull()) {
			try {
				System.out.println("大鱼停车场车位已满，请选择其它停车场");
				System.out.println("**********************************************");
				Thread.currentThread().sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			
			try {
				if(new ChargeImpl().findChargeByCarNo(car_no)==null) {
					String car_type = new MemberImpl().checkMember(car_no);
//					System.out.println(car_type);
					Set keys = map.keySet(); 
					Iterator it = keys.iterator();
					boolean flag = false;
					for(Object key:keys) {
//						System.out.println(key+"====>"+map.get(key));
						if(car_type.equals(map.get(key))){
							flag=true;
						}
					}
					if (car_type != null && flag==false) {
						System.out.println("您好，欢迎来到大鱼停车场！");
						new ChargeImpl().insertCharge(car_no);
						int num = whichEmpty();
						System.out.println("您的"+car_type + "停在" + num + "车位");
						System.out.println("**********************************************");
						map.put(num, car_type);
						park[num] = false;
						int minutes = (int) (3 + Math.random() * 3) * 1000;
						try {
							Thread.currentThread().sleep(minutes);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("您好，大鱼停车场仅服务会员！");
						System.out.println("**********************************************");
					}
				}else {
					System.out.println("您的车辆已经停在大鱼停车场！");
					System.out.println("**********************************************");
					try {
						wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
					
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	//实现开车的同步方法
	public synchronized void drive() {
		notifyAll();
		try {
			wait();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(isEmpty()) {   
			try {
				System.out.println("您的车辆没有停在该停车场！！");
				System.out.println("**********************************************");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			int num = whichFull();
			int minute = 0;
//			获得车辆停车起始时间
			try {	
				minute = new ChargeImpl().selectChargeDiffTime(map.get(num));
				minute+=(int)(Math.random()*1000);
//				System.out.println("停车时间："+minute);
			} catch (IOException e){
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"将"+map.get(num)+"从"+num+"车位"+"开走了");
			System.out.println("停车时间："+minute/60+"小时"+minute%60+"分钟");
			//计算停车费用
			int charge = 0;
			if(minute<=60) {
					charge=100;
			}else{
				if(minute>60 && minute%60==0) {
					charge = 100+(minute/60)*50;
				}else {
					charge = 100+(minute/60)*50+50;
				}
			}
			System.out.println("停车费用为："+charge+"元");
			//begin 获取并更新该车型绑定的会员卡余额 balance
 			try {
 				int balance = new MemberImpl().findMemberByCarType(map.get(num));
 				balance-=charge;
 				int updateMember = new MemberImpl().updateMember(new Member(balance,map.get(num)));
 				if(updateMember==1) {
 					System.out.println("已从账号成功扣费，账号余额为："+balance+"元");
 					
 				}else {
 					System.out.println("扣费失败，请呼叫管理员！");
 				}
 				System.out.println("**********************************************");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
 			//end	
 			
            try {
				new ChargeImpl().deleteCharge(map.get(num));
			} catch (IOException e) {
				e.printStackTrace();
			}
            map.remove(num);
			park[num]=true;
		}
		
	}
}