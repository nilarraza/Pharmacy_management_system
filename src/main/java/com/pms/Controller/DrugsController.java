package com.pms.Controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.criteria.Path;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pms.dao.NonPresDrugsRepository;

import com.pms.dao.PresDrugsRepository;
import com.pms.model.Customer;
import com.pms.model.Drugs;
import com.pms.model.NonPresDrugs;
import com.pms.model.PresDrugs;
import com.pms.service.DrugService;

import antlr.collections.List;

@Controller
public class DrugsController {
	@Autowired
	PresDrugsRepository presdrugRepo;
	@Autowired
	NonPresDrugsRepository nonpresdrugRepo;
	@Autowired
	private DrugService drugService;

	@RequestMapping(value = "/addDrugs", method = RequestMethod.POST)
	public String addDrugs(PresDrugs one, @RequestParam("drugimg") MultipartFile multipartfile) throws Exception {

		// PresDrugs one=new PresDrugs();

		one.getName();		
		one.getPrice();
		one.getDescription();
		one.getAvailability();
	

		String urlpath = saveImage(multipartfile);

		one.setUrl(urlpath);

		presdrugRepo.save(one);


		return "/adddrugs.jsp";
		
	}
	
	@RequestMapping(value = "/addNonPresDrugs", method = RequestMethod.POST)
	public String addDrugs(NonPresDrugs one, @RequestParam("drugimg") MultipartFile multipartfile) throws Exception {

		// PresDrugs one=new PresDrugs();

		one.getName();		
		one.getPrice();
		one.getDescription();
		one.getAvailability();
	

		String urlpath = saveImage(multipartfile);

		one.setUrl(urlpath);

		nonpresdrugRepo.save(one);


		return "/addNonPresDrugs.jsp";
		
	}

	public String saveImage(@RequestParam("drugimg") MultipartFile multipartfile) throws Exception {

		byte[] bytes = multipartfile.getBytes();
		java.nio.file.Path path = Paths
				.get("C:\\spring Workspace\\PMS\\src\\main\\webapp\\img\\" + multipartfile.getOriginalFilename());
		Files.write(path, bytes);

		return multipartfile.getOriginalFilename();
	}

//	@PostMapping("/addDrugs")
	// public String uploadImg(@RequestParam("drugimg") MultipartFile imageFile)
	// throws Exception {
	// String returnvalue="start";
	// try {
	// saveImage(imageFile);
	// } catch (Exception e) {
	// TODO Auto-generated catch block
	// e.printStackTrace();

	// returnvalue="error";
	// }

	// return "adddrugs.jsp";

	// }

	@GetMapping("/getPresDrugs")
	public Collection<PresDrugs> getAllPresDrugs() {
		return drugService.findAllPresDrugs();

	}

	@GetMapping("/showUpdatePres")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelmap) {
		PresDrugs drug = presdrugRepo.findById(id).get();
		modelmap.addAttribute("drug", drug);

		return "editPresDrug.jsp";

	}

	@RequestMapping(value = "/updatePresDrug", method = RequestMethod.POST)
	public String updateDrug(PresDrugs one) {

		presdrugRepo.save(one);
		return "ShowDrug";

	}
	
	@RequestMapping("/searchDrug")
	public String searchDrug(@RequestParam("search") String name,ModelMap modelmap) {
		modelmap.addAttribute("drugs", drugService.findByName(name));
		return "ShowDrugs.jsp";

	}

}
