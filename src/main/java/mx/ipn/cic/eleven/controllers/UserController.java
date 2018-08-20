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
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@GetMapping(path="/all")
	public ModelAndView allUsers() {
		ModelAndView mav = new ModelAndView("user/all");
		mav.addObject("users", this.userService.allUsers());
		return mav;
	}

	@GetMapping(path="/newForm")
	public ModelAndView newForm() {
		ModelAndView mav = new ModelAndView("user/newForm");
		mav.addObject("user", new UserEntity());
		return mav;
	}

	@PostMapping(path="/register")
	public String register(@ModelAttribute(name="user") UserEntity user) {
		if (user.getId() != null && user.getId().length() == 0) {
			user.setId(null);
		}
		this.userService.register(user);

		if (this.addressService.findByUser_Id(user.getId()) == null) {
			return "redirect:/address/newForm/" + user.getId();
		}
		return "redirect:/address/edit/" + user.getId();
	}

	@GetMapping(path="/edit/{id}")
	public ModelAndView edit(@PathVariable(name="id") String id) {
		UserEntity found = this.userService.findById(id);
		ModelAndView mav = new ModelAndView("user/newForm");
		mav.addObject("user", found);
		return mav;
	}

	@GetMapping(path="/delete/{id}")
	public String delete(@PathVariable(name="id") String id) {
		try {
			AddressEntity address = this.addressService.findByUser_Id(id);
			this.addressService.delete(address.getId());
		}
		catch (Exception e) {
			System.out.println("No se encontró el elemento");
		}
		this.userService.delete(id);
		return "redirect:/user/all";
	}
}
