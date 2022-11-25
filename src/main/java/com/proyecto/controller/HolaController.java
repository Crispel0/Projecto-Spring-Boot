package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HolaController {
	
	@RequestMapping("/")
	@ResponseBody
	public String Hola() { return "hola";}
}
