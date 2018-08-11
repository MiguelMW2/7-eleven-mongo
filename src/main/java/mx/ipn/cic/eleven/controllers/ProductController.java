package mx.ipn.cic.eleven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.eleven.entities.ProductEntity;
import mx.ipn.cic.eleven.services.ProductService;

@Controller
@RequestMapping(path="/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path="/all")
	public ModelAndView allProducts() {
		ModelAndView mav = new ModelAndView("product/all");
		mav.addObject("products", this.productService.allProducts());
		return mav;
	}

	@GetMapping(path="/newForm")
	public ModelAndView newForm() {
		ModelAndView mav = new ModelAndView("product/newForm");
		mav.addObject("product", new ProductEntity());
		return mav;
	}

	@PostMapping(path="/register")
	public String register(@ModelAttribute(name="product") ProductEntity product) {
		this.productService.register(product);
		return "redirect:/product/all";
	}

	/*Cambiar por REST*/
	@GetMapping(path="/search")
	public ModelAndView search(
			@RequestParam(name="name") String name,
			@RequestParam(name="upc") String upc) {

		ModelAndView mav = new ModelAndView("");
		mav.addObject("products", this.productService.search(name, upc));
		return mav;
	}
}
