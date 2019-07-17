package mapper;

import java.util.List;

import pojo.Member;

/**
* @类名  MemberMapper.java
* @作者      大大鱼
* @版本  V1.0
* @日期  2019年7月6日-下午2:12:42
* @描述  
*
*/

public interface MemberMapper {
	//检查是否已经注册停车场会员，并返回车类型
	String findMemberByCarNo(String car_no);
	
	int findMemberByCarType(String car_type);
	
	//离开车场，根据停车时间扣费，并更新会员账号中余额
	int updateMember(Member member);
}
