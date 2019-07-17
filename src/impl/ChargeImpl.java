package impl;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.ChargeMapper;

/**
* @类名  ChargeImpl.java
* @作者      大大鱼
* @版本  V1.0
* @日期  2019年7月6日-下午11:57:30
* @描述  
*
*/

public class ChargeImpl {
	

	public void insertCharge(String car_no) throws IOException {
		//加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		// 获取session，设置提交为true
		SqlSession session = ssf.openSession(true);
		// 获取mapper实现类对象
		ChargeMapper mapper = session.getMapper(ChargeMapper.class);
		mapper.insertCharge(car_no);
		session.close();
		System.out.println("git test");
	}
	
	public int selectChargeDiffTime(String car_type) throws IOException {
		//加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		// 获取session，设置提交为true
		SqlSession session = ssf.openSession(true);
		// 获取mapper实现类对象
		ChargeMapper mapper = session.getMapper(ChargeMapper.class);
		int minute  = mapper.selectChargeDiffTime(car_type);	
		session.close();
		return minute;
	}
	
	public void deleteCharge(String car_type) throws IOException {
		//加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		// 获取session，设置提交为true
		SqlSession session = ssf.openSession(true);
		// 获取mapper实现类对象
		ChargeMapper mapper = session.getMapper(ChargeMapper.class);
		mapper.deleteCharge(car_type);
		session.close();
	}
	
	public String findChargeByCarNo(String car_no) throws IOException {
		//加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		// 获取session，设置提交为true
		SqlSession session = ssf.openSession(true);
		// 获取mapper实现类对象
		ChargeMapper mapper = session.getMapper(ChargeMapper.class);
		String carNo = mapper.findChargeByCarNo(car_no);
		session.close();
		return carNo;
	}
	

}
