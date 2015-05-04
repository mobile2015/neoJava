package pl.edu.agh.siwpia.neo4j_web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(value = "/failed", method = RequestMethod.GET)
	public String fail() {
		return "login_failed";
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page() {
		return "login_page";
	}
}
