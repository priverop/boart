package es.boart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortadaController {
	@RequestMapping("/")
	public String greeting(Model modelo) {

		modelo.addAttribute("publication.img", "img");
		modelo.addAttribute("publication.text", "HOLA GABRI JAJ");
		
		return "portada_template";
	}
}
