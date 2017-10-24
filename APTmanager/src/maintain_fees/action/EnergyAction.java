package maintain_fees.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import maintain_fees.model.BillService;
import maintain_fees.model.Personal_mgmt_ex;
import maintain_fees.model.setIdMonth;

public class EnergyAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)	throws Exception {
		
		
		BillService service = BillService.getInstance();
		
		Calendar cal = Calendar.getInstance();
		
		int now_year = cal.get(Calendar.YEAR)-2000;
		int now_month = cal.get(Calendar.MONTH)+1;
		
		Personal_mgmt_ex energyBill = service.getMonthBill(new setIdMonth("dmsql123", now_year + "-" + now_month));
		
		List<Personal_mgmt_ex> allEnergyBill = service.getAllMonthBill(now_year + "-" + now_month);
		int elec_sum = 0;
		int heat_sum = 0;
		int water_sum = 0;
		int count = 0;

		for(int i = 0; i < allEnergyBill.size(); i++)
		{

			elec_sum += allEnergyBill.get(i).elec_bill();
			heat_sum += allEnergyBill.get(i).heat_bill();
			water_sum += allEnergyBill.get(i).water_bill();
			
			count = i;
		}
		
		Double allElec = (double)(elec_sum/count);
		Double allHeat = (double)(heat_sum/count);
		Double allWater = (double)(water_sum/count);
		
		System.out.println(allElec);

		httpServletRequest.setAttribute("allElec", allElec);
		httpServletRequest.setAttribute("allHeat", allHeat);
		httpServletRequest.setAttribute("allWater", allWater);
		
		httpServletRequest.setAttribute("meBill", energyBill);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/maintain_fees/energy.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
