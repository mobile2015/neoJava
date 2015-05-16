package pl.edu.agh.siwpia.neo4j_web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.siwpia.neo4j_web_app.neo4j.CreateSimpleGraph;





@Controller
public class QueryController {
	CreateSimpleGraph driver = new CreateSimpleGraph();
	String result="";
	
	@RequestMapping(value = "/query")
	public String query(Model model) {
		
		model.addAttribute("query", "");
		model.addAttribute("result", result);
		result="";
		
		return "query";
	}
	
	
	
	
	@RequestMapping(value = "/executeQuery", method = RequestMethod.POST)
	public String executeQuery(@ModelAttribute("query")String query, BindingResult queryResult) {
		
		
		driver.checkDatabaseIsRunning();
		result=driver.sendTransactionalCypherQuery(query);
		
		

		

		return "redirect:/query";
	}


}
