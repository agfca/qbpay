package qb.llrj.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import qb.llrj.pay.model.Client;
import qb.llrj.pay.model.DayTotal;
import qb.llrj.pay.service.ClientInfoService;
import qb.llrj.pay.service.DayTotalService;
import qb.llrj.pay.service.MenuService;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/daytotal")
public class DayTotalController {
	@Autowired
	private DayTotalService dayTotalService;
	
	//首页
	@RequestMapping("/index.htm")
	public ModelAndView index(){
		return new ModelAndView("daytotal/index");
	}
	
	//获取数据
	@RequestMapping("/getData.htm")
	@ResponseBody
	public JSONArray getData(){
		JSONArray arrlist = new JSONArray();
		
		try{
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("clientId", 19);
			
			List<DayTotal> list =dayTotalService.findListByMap(map);
			arrlist = JSONArray.parseArray(JSON.toJSONString(list));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrlist;
	}

}
