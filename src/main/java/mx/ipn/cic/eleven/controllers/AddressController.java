package mx.ipn.cic.eleven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.eleven.entities.AddressEntity;
import mx.ipn.cic.eleven.entities.UserEntity;
import mx.ipn.cic.eleven.services.AddressService;
import mx.ipn.cic.eleven.services.UserService;

@Controller
@RequestMapping(path="/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@Autowired
	private UserService userService;

	@PostMapping(path="/register")
	public String register(
			@ModelAttribute(name="address") AddressEntity address,
			@ModelAttribute(name="user") UserEntity user
	) {
		UserEntity found = userService.findById(user.getId());
		address.setUser(found);
		this.addressService.register(address);
		return "redirect:/user/all";
	}

	@GetMapping(path="/detail/{id}")
	public ModelAndView detail(@PathVariable(name="id") String id) {
		ModelAndView mav = new ModelAndView("address/detail");
		mav.addObject("address", this.addressService.findByUser_Id(id));
		return mav;
	}
}
