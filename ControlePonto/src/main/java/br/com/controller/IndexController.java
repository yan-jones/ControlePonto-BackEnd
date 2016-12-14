package br.com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index");
	}
}
