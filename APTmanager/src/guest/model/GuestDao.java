package guest.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import guest.mapper.guestMapper;

import maintain_fees.mapper.BillMapper;
import maintain_fees.model.Personal_mgmt_ex;

public class GuestDao {
	private static GuestDao guestDao = new GuestDao();
	
	public static GuestDao getInstance(){
		return guestDao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public List<Guest> selectedGuest(String date){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
			List<Guest> list = sqlSession.getMapper(guestMapper.class).selectedGuest(date);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			sqlSession.close();
		}
		return null;
		
	}
	
	public int insertRe(GuestRe review) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(guestMapper.class).insertRe(review);
			if(re > 0) {
				sqlSession.commit(); // insert�릺�뿀�쓣 寃쎌슦 commit�쓣 �빐二쇱뼱�빞�븳�떎.
			} else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;
	}
	public int getMaxRev_id(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			Integer num = sqlSession.getMapper(guestMapper.class).getMaxRev_id();
			if(num == null ){
				return 0;
			}
			else{
				return num+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			sqlSession.close();
		}
		return 0;
	}
	
	public List<GuestRe> listRe(int f_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
			List<GuestRe> list = sqlSession.getMapper(guestMapper.class).listRe(f_id);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			sqlSession.close();
		}
		return null;
		
	}
	
	
}
