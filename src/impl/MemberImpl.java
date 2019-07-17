package impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.MemberMapper;
import pojo.Member;

/**
 * @类名 CheckVip.java
 * @作者 大大鱼
 * @版本 V1.0
 * @日期 2019年7月6日-下午3:13:55
 * @描述
 *
 */

public class MemberImpl {

	public String checkMember(String car_no) throws IOException {
		// 加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		// 获取session，设置提交为true
		SqlSession session = ssf.openSession(true);
		// 获取mapper实现类对象
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		// 通过车牌号判断是否已经注册会员
		String car_type = mapper.findMemberByCarNo(car_no);
		session.close();
		return car_type;
	}
	
	public int findMemberByCarType(String car_type) throws IOException {
		// 加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		// 获取session，设置提交为true
		SqlSession session = ssf.openSession(true);
		// 获取mapper实现类对象
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		// 通过车牌号判断是否已经注册会员
		int balance = mapper.findMemberByCarType(car_type);
		session.close();
		return balance;
	}
	
	
	public int updateMember(Member member) throws IOException {
		// 加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		// 获取session，设置提交为true
		SqlSession session = ssf.openSession(true);
		// 获取mapper实现类对象
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		// 通过车牌号判断是否已经注册会员
		int updateMember = mapper.updateMember(member);
		session.close();
		return updateMember;
	}
}
