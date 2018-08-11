package mx.ipn.cic.eleven.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/sale")
public class SaleController {

	@GetMapping(path="/sale")
	public ModelAndView sale() {
		ModelAndView mav = new ModelAndView("/sale/sale");
		return mav;
	}
}
