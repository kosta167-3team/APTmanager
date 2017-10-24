package AptManagerController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public interface Action {
	public ActionForward excute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
}
