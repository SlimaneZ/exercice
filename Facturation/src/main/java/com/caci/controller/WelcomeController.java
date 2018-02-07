package com.caci.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controleur.
 * 
 * @author Slimane
 *
 */
@Controller
public class WelcomeController {

	/**
	 * Renvoyer la réponse vers la page welcome.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "welcome";
	}

}