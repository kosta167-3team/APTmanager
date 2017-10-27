package maintain_fees.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = httpServletRequest.getSession();
		String r_id = (String)session.getAttribute("r_id");
		if( r_id == null){
			r_id = "a";
		}
		r_id = "alstlr123";
		
		Personal_mgmt_ex energyBill = service.getMonthBill(new setIdMonth(r_id, now_year + "-" + now_month));
		
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
		
//		
		Date today = new Date();
		SimpleDateFormat year_format = new SimpleDateFormat("yy");

		String year = year_format.format(today);
		
		String month = String.valueOf(cal.get(Calendar.MONTH)+1);
		
		Personal_mgmt_ex me = service.getMonthBill(new setIdMonth(r_id,year + "-" + month));
		System.out.println(me);
		
		List<Personal_mgmt_ex> list = service.getWidthBill(me.getWidth());
		Double All_sum =0.0;
		Double average = 0.0;
		int count1=0;
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i) );
			All_sum += Double.valueOf(list.get(i).allBill());
			count1 = i;
		}
		average = All_sum / count1;
		
		Double result = Double.valueOf(me.allBill()/17) - average/17;
		
		httpServletRequest.setAttribute("me", Double.valueOf(me.allBill()/17));
		httpServletRequest.setAttribute("average", average/17);
		httpServletRequest.setAttribute("result", result);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("/maintain_fees/EnergyBill.jsp");
		actionForward.setRedirect(false);
		return actionForward;
	}

}
