package com.pms.Controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pms.Util.ReportUtil;
import com.pms.dao.SalesRepository;
import com.pms.service.SalesService;

@Controller
public class SalesReportController {
	@Autowired
	SalesRepository salesRepo;
	@Autowired
	ReportUtil reportUtil;
	@Autowired
	ServletContext sc;
	@Autowired
	SalesService salesService;
	
	@RequestMapping("/genReport")
	public String genReport() {
		String path = sc.getRealPath("/");
		
		List<Object[]> data = salesRepo.findPidandPidCount();
		reportUtil.generatePieChart(path, data);
		return "Report.jsp";
	}
	
	
	@RequestMapping("/showSales")
	public String showSales(ModelMap modelmap) {
		modelmap.addAttribute("sales", salesService.findAllSales());

		return "SalesAdmin.jsp";
	}


}
