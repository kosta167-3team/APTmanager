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

	// DB와 연결
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

	// 시설 정보 보기
	public Facility getDetail(int f_id) {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Facility facility = null;

		try {

			facility = sqlSession.getMapper(FacilityMapper.class).getDetail(f_id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return facility;
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
		System.out.println("re"+reservation.getF_id() + reservation.getT_id()+reservation.getFr_date());
		try {
			fr_cnt = sqlSession.getMapper(FacilityMapper.class).getSpot(reservation);
			System.out.println("dao" + fr_cnt);
			if(fr_cnt == null){
				fr_cnt = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return fr_cnt;
	}

}
