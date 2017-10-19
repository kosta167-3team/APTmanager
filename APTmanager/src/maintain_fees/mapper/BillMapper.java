package maintain_fees.mapper;

import java.util.List;

import maintain_fees.model.Personal_mgmt_ex;
import maintain_fees.model.setIdMonth;

public interface BillMapper {
	List<Personal_mgmt_ex> getMonthBill(setIdMonth setIdMonth);
}
