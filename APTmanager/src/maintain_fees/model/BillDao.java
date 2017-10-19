package maintain_fees.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import maintain_fees.mapper.BillMapper;

public class BillDao {
	private static BillDao billDao = new BillDao();

	public static BillDao getInstance() {
		return billDao;
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
	public List<Personal_mgmt_ex> getMonthBill(setIdMonth setIdMonth){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Personal_mgmt_ex> list = null;
		
		try 
		{
			list = sqlSession.getMapper(BillMapper.class).getMonthBill(setIdMonth);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally {
			sqlSession.close();
		}
		
		return list;
		
	}
}
