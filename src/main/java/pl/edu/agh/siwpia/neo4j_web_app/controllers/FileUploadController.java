package pl.edu.agh.siwpia.neo4j_web_app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
public class FileUploadController {

	@RequestMapping(value = "/add_image", method = RequestMethod.GET)
	public String addImage() {
		return "add_image";
	}
	
	@RequestMapping(value = "/uploaded", method = RequestMethod.POST)
	public String getPages() {
		
		
		return "uploaded";
 
	}
}
