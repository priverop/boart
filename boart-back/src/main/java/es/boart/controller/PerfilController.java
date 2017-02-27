package es.boart.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.model.Galeria;
import es.boart.model.Usuario;
import es.boart.repository.GaleriaRepository;
import es.boart.repository.UsuarioRepository;

@Controller
public class PerfilController {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private GaleriaRepository galleryRepository;
	
	@PostConstruct
	public void init(){
		Date date = new Date();
		
		Usuario usuario = new Usuario("usuario1", "prueba", "prueba", 
				"Aficionado a la fotografía, me gusta fotografiar naturaleza, en especial aves.",
				"pass", 
				"https://yt3.ggpht.com/-9lTuNU-MLtM/AAAAAAAAAAI/AAAAAAAAAAA/SjXmBhMb9PA/s176-c-k-no-mo-rj-c0xffffff/photo.jpg",
				0, 0, new Timestamp(date.getTime()), new Timestamp(date.getTime()), new Galeria());
				
		usuario.getGaleria().getImgs().add("https://iso.500px.com/wp-content/uploads/2016/03/pedroquintela.jpg");
		usuario.getGaleria().getImgs().add("http://images1.fanpop.com/images/image_uploads/Photography-photography-1201911_1024_768.jpg");
		usuario.getGaleria().getImgs().add("http://wallpaperspicturesphotos.com/wp-content/uploads/2015/03/photography-images..jpg");
		usuario.getGaleria().getImgs().add("https://www.nobackgroundimages.com/wp-content/uploads/2014/12/digital-camera-349873_640.jpg");
		usuario.getGaleria().getImgs().add("http://images5.fanpop.com/image/photos/31600000/Dandelion-Art-photography-31606827-2560-1706.jpg");
		
		userRepository.save(usuario);

	}
	
	@RequestMapping("/perfil_publico/{nombreUsuario}")
	public String greeting(Model modelo, @PathVariable String nombreUsuario) {

		Usuario usuario = userRepository.findByNombreUsuario(nombreUsuario);
		modelo.addAttribute("usuario", usuario);
		
		//Galeria galeria = galleryRepository.findByUsuario(usuario);
		//modelo.addAttribute("galeria", galeria);
		
		return "perfil_publico_template";
	}
}