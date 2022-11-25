package com.proyecto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
	
	@RequestMapping("/")
	public String Hola() { return "hola";}
}
