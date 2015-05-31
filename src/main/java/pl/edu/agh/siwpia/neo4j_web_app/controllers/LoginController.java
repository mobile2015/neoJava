package pl.edu.agh.siwpia.neo4j_web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(value = "/fail", method = RequestMethod.GET)
	public String fail(@RequestParam("password") String password, @RequestParam("email") String email) {
		return "login_failed";
	}

	@RequestMapping(value = "/page")
	public String page() {
		return "login_page";
	}
}
