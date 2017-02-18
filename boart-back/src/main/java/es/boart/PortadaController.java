package es.boart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortadaController {
	
	@RequestMapping("/")
	public String greeting(Model modelo) {

		modelo.addAttribute("publication.img", "http://i797.photobucket.com/albums/yy260/soyhanechan/01.jpg");
		modelo.addAttribute("publication.text", "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis.");
		
		return "portada_template";
	}
}
