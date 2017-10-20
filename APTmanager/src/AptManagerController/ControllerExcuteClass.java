package AptManagerController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerExcuteClass {
	public ActionForward excute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,String commend);
	public ActionForward doProcess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,String commend)throws ServletException, IOException;
    
	
}
