package maintain_fees.model;

import java.util.List;

public class BillService {
	private static BillService service = new BillService();
	private static BillDao billDao;
	
	public static BillService getInstance(){
		billDao = BillDao.getInstance();
		
		return service;
	}
	public List<Personal_mgmt_ex> getMonthBill(setIdMonth setIdMonth){
		List<Personal_mgmt_ex> list = billDao.getMonthBill(setIdMonth);
		
		return list;
	}
	
	
	
	
}
