package com.appgestion.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ErrorController {

	@RequestMapping(value = "/errors")
	public String error() {
		
		return "errors/errors";
	}
}
