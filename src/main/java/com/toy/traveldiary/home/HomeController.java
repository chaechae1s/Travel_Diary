package com.toy.traveldiary.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) throws Exception {
		model.addAttribute("data", "home");
		return "home";
	}

}
