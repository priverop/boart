package es.boart.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.repository.UploadRepository;

@Controller
public class UploadController {
	
	@Autowired
	private UploadRepository repository;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/subir")
	public String greeting(Model modelo) {

		//modelo.addAttribute("", repository.findAll());
		
		return "subir_template";
	}
}
