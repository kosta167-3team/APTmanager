package maintain_fees.model;

import java.util.List;

import resident.model.Resident;

public class BillService {
	private static BillService service = new BillService();
	private static BillDao billDao;
	
	public static BillService getInstance(){
		billDao = BillDao.getInstance();
		
		return service;
	}
	public Personal_mgmt_ex getMonthBill(setIdMonth setIdMonth){
		Personal_mgmt_ex pme = billDao.getMonthBill(setIdMonth);
		
		return pme;
	}
	public List<Personal_mgmt_ex> getWidthBill(int width){
		return billDao.getWidthBill(width);
	}
	public List<Personal_mgmt_ex> getAllMonthBill(String p_month){
		return billDao.getAllMonthBill(p_month);
	}
	public Resident getResident(String r_id){
		return billDao.getResident(r_id);
	}
	
	
	
	
}
