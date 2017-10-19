package maintain_fees.mapper;

import java.util.List;

import maintain_fees.model.Personal_mgmt_ex;
import maintain_fees.model.SetIdMonthWidth;
import maintain_fees.model.setIdMonth;

public interface BillMapper {
	Personal_mgmt_ex getMonthBill(setIdMonth setIdMonth);
	List<Personal_mgmt_ex> getWidthBill(int width);
}
