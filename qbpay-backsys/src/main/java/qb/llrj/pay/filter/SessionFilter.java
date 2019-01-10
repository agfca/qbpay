package qb.llrj.pay.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
/**
 * @ClassName: SessionFilter
 * @Description: session过滤器
 * @Package: com.ifmtech.wechat.util
 * @author: 
 * @version: v1.0
 * @date: 2015-12-9 上午11:22:58
 */
@Component
public class SessionFilter implements Filter {
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String shotUri = request.getRequestURI().replace("/oilrebate/", "");
		/*
		if(!shotUri.equals("") && isInclude(shotUri)){
			T_UserInfo user = (T_UserInfo) request.getSession().getAttribute("user");
			if(user != null){
				
				S_LogsInfo log = new S_LogsInfo();
				log.setUser_id(user.getUser_id());
				log.setUser_name(user.getUser_name());
				log.setUser_phone(user.getUser_phone());
				log.setLogs_ip(RemoteIpUtils.getRemoteIp(request));
				
				if(shotUri.split("/").length == 2){
					log.setLogs_clazz(shotUri.split("/")[0]);
					log.setLogs_method(shotUri.split("/")[1]);
				}else{
					log.setLogs_clazz("login");
					log.setLogs_method(shotUri.split("/")[0]);
				}
				
				log.setLogs_param(JSON.toJSONString(req.getParameterMap()));
				log.setLogs_date(new Date());
				
				if(shotUri.startsWith("api")){//接口访问过滤
					log.setLogs_type(1);
				}else{//后台访问过滤
					log.setLogs_type(0);
				}
				if(!log.getLogs_method().equals("rechargeRechorReminder.json")){
					logService.saveLogs(log);
				}
				chain.doFilter(request, response);
			}else{
				write(request, response, "login", "尚未登录");
			}
		}else{
			chain.doFilter(request, response);
		}*/
	}
	
	protected static List<String> filterUrl = new ArrayList<String>();
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		filterUrl.add(".js");
		filterUrl.add(".css");
		filterUrl.add(".map");
		filterUrl.add(".font");
		filterUrl.add(".woff2");
		filterUrl.add(".jpg");
		filterUrl.add(".png");
 	}
	
	public void write(HttpServletRequest request, HttpServletResponse response,
			String loginPage, String msg) {
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");

			request.setCharacterEncoding("UTF-8");
			//response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			StringBuilder builder = new StringBuilder();
			builder.append("<script type=\"text/javascript\">");
			builder.append("alert('" + msg + "');");
			System.out.println(request.getContextPath());
			builder.append("window.top.location.href='"+ request.getContextPath()+"/'");
			builder.append("</script>");
			out.print(builder.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        for (String str : filterUrl) {
			if(url.endsWith(str)){
				return false;
			}
		}
        return true;
    }
}
