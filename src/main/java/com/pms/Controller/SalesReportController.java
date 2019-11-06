package com.pms.Controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pms.Util.ReportUtil;
import com.pms.dao.SalesRepository;

@Controller
public class SalesReportController {
	@Autowired
	SalesRepository salesRepo;
	@Autowired
	ReportUtil reportUtil;
	@Autowired
	ServletContext sc;
	
	@RequestMapping("/genReport")
	public String genReport() {
		String path = sc.getRealPath("/");
		
		List<Object[]> data = salesRepo.findPidandPidCount();
		reportUtil.generatePieChart(path, data);
		return "Report.jsp";
	}

}
