package real_estate.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import real_estate.model.RealStateService;

/*매월 1일*/
//가장 늦은 달 delete
//이번달 insert

/*11일 ,21일*/
//이번달 11~20일 insert
//이번달 21~30일 insert

public class InqRealStateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RealStateService service = RealStateService.getInstance();

		ActionForward forword = new ActionForward();

		Calendar cal = Calendar.getInstance();

		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;

		int day = cal.get(cal.DAY_OF_MONTH);

		System.out.println("년 : " + year);
		System.out.println("월 : " + month);

		//처음 설정 하고 이후에 
		if (day == 1 || day == 11 || day == 22) {
			String date = year + "" + month;
			String strDay = "";
			if (day == 1) {
				service.deleteOldestRealStateService(month);
			}
			strDay = day + "";

			service.inqRealEstateRentApiService(request, date);
			service.InqRealEstateTradeApiService(request, date);
			request.setAttribute("day", strDay);

			forword.setRedirect(false);
			forword.setPath("xmlParser.realEstate");
		} else {
			forword.setRedirect(true);
			forword.setPath("showRentList.realEstate");

			return forword;
		}

		//first
//		int remonth = month + 1;
//		int reyear = year;
//		for (int i = 0; i <= 11; i++) {
//			remonth--;
//
//			String strMonth = "";
//			if (remonth < 1) {
//				remonth += 12;
//				reyear--;
//
//			}
//			if (remonth < 10) {
//				strMonth = "0";
//			}
//
//			strMonth += remonth;
//			String date = reyear + strMonth;
//			System.out.println(date);
//			service.RepeatInqRealEstateRentApiService(request, date, i+1);
//			service.RepeatInqRealEstateTradeApiService(request, date, i+1);
//
//			forword.setRedirect(false);
//			forword.setPath("xmlParser.realEstate");
//		}

		return forword;
	}

}
