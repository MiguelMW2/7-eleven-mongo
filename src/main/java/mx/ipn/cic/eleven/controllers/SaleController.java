package mx.ipn.cic.eleven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.eleven.entities.SaleEntity;
import mx.ipn.cic.eleven.services.SaleService;

@Controller
@RequestMapping(path="/sale")
public class SaleController {

	@Autowired
	private SaleService saleService;

	@GetMapping(path="/all")
	public ModelAndView s() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sales", this.saleService.allSales());
		return mav;
	}

	@GetMapping(path="/sale")
	public ModelAndView sale() {
		ModelAndView mav = new ModelAndView("/sale/sale");
		return mav;
	}

	@GetMapping(path="/payment/{id}")
	public ModelAndView payment(@PathVariable(name="id") String id) {
		ModelAndView mav = new ModelAndView("/sale/payment");
		mav.addObject("sale", this.saleService.findById(id));
		return mav;
	}

	@PostMapping(path="/register")
	public String register(@ModelAttribute(name="sale") SaleEntity sale) {
		sale.setTotal(this.saleService.calculate(sale));
		this.saleService.register(sale);
		return "redirect:/sale/summary/" + sale.getId();
	}

	@GetMapping(path="/summary/{id}")
	public ModelAndView summary(@PathVariable(name="id") String id) {
		ModelAndView mav = new ModelAndView("sale/summary");
		mav.addObject("sale", this.saleService.findById(id));
		return mav;
	}
}
