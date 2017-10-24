package resident.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import resident.mapper.ResidentMapper;


public class ResidentDao {
	private static ResidentDao residentDao = new ResidentDao();
	
	public static ResidentDao getInstance() {
		return residentDao;
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
	
	public Resident login(String r_id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.getMapper(ResidentMapper.class).login(r_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
	}
	public int getReservationId() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ResidentMapper.class).getReservationId();
			return re;
		} catch (Exception e) {
			e.printStackTrace();
			return re;
		} finally {
			sqlSession.close();
		}
	}
	
	public int createReservation(Reservation reservation) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ResidentMapper.class).createReservation(reservation);
			System.out.println(re);
			if(re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return re;
		} catch (Exception e) {
			e.printStackTrace();
			return re;
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Reservation> searchReservation(String r_id, int requestPage) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Reservation> list;
		try {
			list = sqlSession.getMapper(ResidentMapper.class).searchReservation(r_id);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
	}
	public int getReservationCount(String r_id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.getMapper(ResidentMapper.class).getReservationCount(r_id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}
}
