package facility_reservation.model;

import java.io.InputStream; 
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sun.org.apache.bcel.internal.generic.StackInstruction;

import facility_reservation.mapper.FacilityMapper;

public class FacilityDao {

	public static FacilityDao facilityDao = new FacilityDao();

	public static FacilityDao getinstance() {
		return facilityDao;
	}

	// DB�� �뿰寃�
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

	public List<Facility> getFacilityList() {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Facility> facilityList = new ArrayList<Facility>();

		try {
			facilityList = sqlSession.getMapper(FacilityMapper.class).getFacilityList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return facilityList;
	}

	// �떆�꽕 �젙蹂� 蹂닿린
	public Facility getDetail(int f_id) {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Facility facility = null;

		try {
			System.out.println(f_id);
			return sqlSession.getMapper(FacilityMapper.class).getDetail(f_id);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
	}

	public List<Facility_time> getTimetable() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Facility_time> timeTable = null;

		try {

			timeTable = sqlSession.getMapper(FacilityMapper.class).getTimetable();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return timeTable;
	}

	public Integer getSpot(Facility_reservation reservation) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Integer fr_cnt = 0;
		try {
			fr_cnt = sqlSession.getMapper(FacilityMapper.class).getSpot(reservation);
			if(fr_cnt == null) {
				fr_cnt = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return fr_cnt;
	}

	public Integer checkDoubleBook(Facility_reservation reservation) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Integer f_id = 0;

		try {
			f_id = sqlSession.getMapper(FacilityMapper.class).checkDoubleBook(reservation);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return f_id;
	}
}
