package mx.ipn.cic.eleven.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.eleven.entities.UserEntity;
import mx.ipn.cic.eleven.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping(value={"", "/", "/login"})
	public ModelAndView login()	{
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new UserEntity());
		return mav;
	}

	@GetMapping(path="/login/home") 
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("user", new UserEntity());
		return mav;
	}

	@PostMapping(path="/login/authenticate")
	public String authenticate(@ModelAttribute(name="user") UserEntity user) {
		if(this.userService.findByUserNameAndPassword(user)) {
			return "redirect:/login/home";
		}
		return "redirect:/login";
	}
}
