package maintain_fees.mapper;

import java.util.List;

import maintain_fees.model.Personal_mgmt_ex;
import maintain_fees.model.SetIdMonthWidth;
import maintain_fees.model.setIdMonth;
import resident.model.Resident;

public interface BillMapper {
	Personal_mgmt_ex getMonthBill(setIdMonth setIdMonth);
	List<Personal_mgmt_ex> getWidthBill(int width);
	List<Personal_mgmt_ex> getAllMonthBill(String p_month);
	Resident getResident(String r_id);
}
