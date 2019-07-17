package impl;

import java.io.IOException;

/**
* @类名  Check.java
* @作者      大大鱼
* @版本  V1.0
* @日期  2019年7月7日-下午12:30:18
* @描述  
*
*/

public class Check {

	public void checkInfo(String car_no) {
		try {
			if(new MemberImpl().checkMember(car_no)!=null){
				System.out.println("您好，欢迎来到大鱼停车场！");
			}else {
				System.out.println("您好，大鱼停车场仅服务会员！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
