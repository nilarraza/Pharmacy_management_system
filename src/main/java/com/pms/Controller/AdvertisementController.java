package com.pms.Controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pms.dao.AdvertismentRepository;
import com.pms.model.Advertisement;
import com.pms.service.AdvertisementService;

@Controller
public class AdvertisementController {
	@Autowired
	AdvertismentRepository adverRepo;
	@Autowired
	AdvertisementService advService;
	
	@RequestMapping("/addAdvertisement")
	public String addAdvertisement( Advertisement adv,@RequestParam("img") MultipartFile multipartfile) throws Exception {
		String urlpath = savePresImage(multipartfile);
		adv.setUrl(urlpath);
		adverRepo.save(adv);
		
		return "redirect:/success";

	}
	
	public String savePresImage(@RequestParam("img") MultipartFile multipartfile) throws Exception {

		byte[] bytes = multipartfile.getBytes();
		java.nio.file.Path path = Paths
				.get("C:\\spring Workspace\\PMS\\src\\main\\webapp\\Promotion\\" + multipartfile.getOriginalFilename());
		Files.write(path, bytes);

		return multipartfile.getOriginalFilename();
	}
	
	@RequestMapping("/deleteAdvertisement")	
	public String deleteAdvertisement() {
		adverRepo.deleteAll();
		
		
		return "redirect:/success";

	}
	

	
	@RequestMapping("/showAdvertisement")	
	public String showAdvertisement(ModelMap modelmap) {
		modelmap.addAttribute("img",advService.findAllPromotions());
		
		
		return "Customer.jsp";

	}
	

	


	
	
	

}
