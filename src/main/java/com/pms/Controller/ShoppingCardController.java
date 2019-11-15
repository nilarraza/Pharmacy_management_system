package com.pms.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pms.Util.EmailUtil;
import com.pms.dao.DrugRepository;
import com.pms.dao.PresDrugsRepository;
import com.pms.dao.PromotionRepository;
import com.pms.dao.SalesRepository;
import com.pms.dao.ShoppingCardRepository;
import com.pms.dao.checkTotalRepository;
import com.pms.model.Drugs;
import com.pms.model.Promotion;
import com.pms.model.Sales;
import com.pms.model.ShoppingCard;
import com.pms.model.checkTotal;
import com.pms.service.PersonUserDetails;
import com.pms.service.PromotionService;
import com.pms.service.ShoppingCardService;

@Controller
public class ShoppingCardController {
	@Autowired
	ShoppingCardRepository shopCardRepo;
	@Autowired
	PresDrugsRepository presDrugRepo;
	@Autowired
	DrugRepository DrugRepo;
	@Autowired
	ShoppingCardService shopCardService;
	@Autowired
	checkTotalRepository checktRepo;
	@Autowired
	SalesRepository saleRepo;

	@Autowired
	EmailUtil email;
	@Autowired
	PromotionRepository prom;
	@Autowired
	PromotionService proservice;

	@RequestMapping("/addtoCard")
	public String addtoPresCard(int id, ShoppingCard card) {

		Drugs drug = DrugRepo.findById(id).get();
		String pname = drug.getName();
		String price = drug.getPrice();

		card.setPname(pname);
		card.setPrice(price);

		shopCardRepo.save(card);

		return "/CustShowPresDrug";
	}

	private Collection<Drugs> drugs;

	@RequestMapping("/Mycardadd")
	public String Mycardadd(Drugs drug) {
		drugs = new ArrayList<Drugs>();
		drugs = (Collection<Drugs>) drug;

		return "Shoppingcard.jsp";
	}

	@RequestMapping("/Mycard")
	public String showMycard(HttpServletRequest req, Authentication authentication) {
		req.setAttribute("drugs", shopCardService.findAllDrugs());
		System.out.println(shopCardService.findAllDrugs());

		java.lang.Object principal = authentication.getPrincipal();

		int userId = 0;
		String mail = null;
		if (principal instanceof UserDetails) {

			userId = ((PersonUserDetails) principal).getPerson().getUser_id();
			mail = ((PersonUserDetails) principal).getPerson().getEmail();
		}

		double pr = 0;
		Collection<checkTotal> calc = new ArrayList<checkTotal>();

		for (checkTotal calc1 : shopCardService.findAllDrugsPrice()) {
			double p = Double.parseDouble(calc1.price);
			pr = pr + p;
		}
//		 double doll=(double) pr/180;

		req.setAttribute("total", pr);

		System.out.println(pr);

		return "Shoppingcard.jsp";
	}

	@RequestMapping("/deleteDrugSp")
	public String deleteDrugSp(int id) {
		deleteMethodDrugSp(id);

		return "redirect:/Mycard";
	}

	public void deleteMethodDrugSp(int id) {
		shopCardRepo.deleteById(id);

	}

	@RequestMapping("/checkoutTotal")
	public String checkoutTotal(int id, String price, checkTotal check) {

		check.setPid(id);
		check.setPrice(price);

		checktRepo.save(check);

		return "redirect:/CustShowPresDrug";
	}

	@RequestMapping("/purchase")
	public String calculateTotal(String promo, double total, ModelMap modelmap) {

		for (Promotion calc1 : proservice.findAllProm()) {
			System.out.println(calc1.getPromocode());
			String a = calc1.getPromocode();

			if (promo.equals(a)) {
				String Discount = calc1.getDiscountValue();
				double price = Double.parseDouble(Discount);
				total = total - price;
				double doll = (double) total / 180;
				System.out.println("Total =" + doll);
				modelmap.addAttribute("total", doll);

				for (checkTotal tot : checktRepo.findAll()) {
					String saleprice=tot.getPrice();
					int salePid=tot.getPid();
					
					Sales sale=new Sales();
					LocalDate date = LocalDate.now();
					LocalTime time = LocalTime.now();
					sale.setPid(salePid);
					sale.setPrice(saleprice);
					sale.setDate(date);
					sale.setTime(time);
					saleRepo.save(sale);

				}

				checktRepo.deleteAll();
				return "Paypal.jsp";
			} else {
				
				double doll = (double) total / 180;
				modelmap.addAttribute("total", doll);

			
					
					for (checkTotal tot : checktRepo.findAll()) {
						String saleprice=tot.getPrice();
						int salePid=tot.getPid();
						
						Sales sale=new Sales();
						LocalDate date = LocalDate.now();
						LocalTime time = LocalTime.now();
						sale.setPid(salePid);
						sale.setPrice(saleprice);
						sale.setDate(date);
						sale.setTime(time);
					
						saleRepo.save(sale);

					}


				

				checktRepo.deleteAll();
				return "Paypal.jsp";
			}

		}

//		String p=prom.findBypromocode(promo).getPromocode();
//		String Discount=prom.findBypromocode(promo).getDiscountValue();

//		 email.sendEmail(mail, "Total Checkout Amount", "Order succesfully placed.You have to pay USD"+doll);

		return "redirect:/success";
	}

}
