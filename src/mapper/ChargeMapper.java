package mapper;


/**
* @类名  ChargeMapper.java
* @作者      大大鱼
* @版本  V1.0
* @日期  2019年7月6日-下午11:40:32
* @描述  
*
*/

public interface ChargeMapper {
	//停车时，将车牌号以及停车起始时间写入charge表
	void insertCharge(String car_no);
	//计算取车后，停车时间，单位 minute
	int selectChargeDiffTime(String car_type);
	//取车后，删除停车收费表中的记录
	void deleteCharge(String car_no);
	//检查是否车辆已经停在停车场
	String findChargeByCarNo(String car_no);
}
