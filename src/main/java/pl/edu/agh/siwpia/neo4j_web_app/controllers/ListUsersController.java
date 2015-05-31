package pl.edu.agh.siwpia.neo4j_web_app.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.siwpia.neo4j_web_app.entities.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.siwpia.neo4j_web_app.entities.Role;
import pl.edu.agh.siwpia.neo4j_web_app.services.UserService;



@Controller
@RequestMapping(value = "/list")
public class ListUsersController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(ModelMap modelMap) {
		
		List<User> users = new LinkedList<>();
		users = userService.selectAll();
		modelMap.addAttribute("users", users);
		return "list_users";
	}
}
