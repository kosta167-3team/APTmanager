package bill.mapper;

import java.util.List;

import bill.model.Personal_mgmt_ex;
import bill.model.setIdMonth;

public interface BillMapper {
	List<Personal_mgmt_ex> getMonthBill(setIdMonth setIdMonth);
}
