package real_estate.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import real_estate.mapper.RealEstateMapper;

public class RealEstateDAO {

	private static RealEstateDAO reDao = new RealEstateDAO();

	public RealEstateDAO() {
	}

	public static RealEstateDAO getInstance() {
		return reDao;
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

	// DB에 부동산 정보 insert (전세)
	public void insertRealEstate_Rent(RealEstate_rent real_rent) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(RealEstateMapper.class).insertRealEstate_Rent(real_rent);

			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}
	
	// DB에 부동산 정보 insert (매매)
	public void insertRealEstate_Trade(RealEstate_trade real_trade) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(RealEstateMapper.class).insertRealEstate_Trade(real_trade);
			
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}

	// 오래된 달의 전세 내역 삭제
	public void deleteOldestRealEstate(int month) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(RealEstateMapper.class).deleteRealEstate_Rent(month);
			if (re > 0) {
				sqlSession.commit();
				re = sqlSession.getMapper(RealEstateMapper.class).deleteNRealEstate_Trade(month);
				if(re > 0){
					sqlSession.commit();
				}else{
					sqlSession.rollback();
				}
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	
	}



	// 내 아파트 DB에 있는 지난달 전세내역,
	public RealEstate_rent showMyAptRent() {
		List<RealEstate_rent> list = new ArrayList<RealEstate_rent>();
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			// 전세에 대한 list
			return sqlSession.getMapper(RealEstateMapper.class).showMyAptRent();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return null;

	}
	
	// 내 아파트 DB에 있는 지난달 매매내역,

	public RealEstate_trade showMyAptTrade() {
		RealEstate_trade realEstate_trade = new RealEstate_trade();
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
			realEstate_trade =  sqlSession.getMapper(RealEstateMapper.class).showMyAptTrade();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return realEstate_trade;
		
	}


	// 내 아파트 1년간 전세 내역
	public List<RealEstate_rent> showMyAptRentAnnual() {
		List<RealEstate_rent> list = new ArrayList<RealEstate_rent>();
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			list = sqlSession.getMapper(RealEstateMapper.class).showMyAptRentAnnual();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return list;

	}
	// 내 아파트 1년간 매매 내역
	public List<RealEstate_trade> showMyAptTradeAnnual() {
		List<RealEstate_trade> list = new ArrayList<RealEstate_trade>();
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			list = sqlSession.getMapper(RealEstateMapper.class).showMyAptTradeAnnual();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return list;
		
	}
	

}
