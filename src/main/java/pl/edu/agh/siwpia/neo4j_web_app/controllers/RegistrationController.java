package pl.edu.agh.siwpia.neo4j_web_app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.siwpia.neo4j_web_app.dtos.RegistrationDto;
import pl.edu.agh.siwpia.neo4j_web_app.entities.User;
import pl.edu.agh.siwpia.neo4j_web_app.enums.UserRole;
import pl.edu.agh.siwpia.neo4j_web_app.services.UserService;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page() {
		return "register_page";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(@Valid RegistrationDto dto, ModelMap modelMap, BindingResult result) {
		if (!result.hasErrors()) {
			User user = userService.registerUser(dto);
			userService.grantRole(user.getId(), UserRole.USER);
			modelMap.addAttribute("userEmail", user.getEmail());
			modelMap.addAttribute("userId", user.getId());
			return "registered";
		} else {
			return "register_failed";
		}

	}
}
