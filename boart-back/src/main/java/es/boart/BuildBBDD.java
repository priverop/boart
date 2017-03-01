package es.boart;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.boart.model.Grupo;
import es.boart.model.Publication;
import es.boart.model.User;
import es.boart.repository.GroupRepository;
import es.boart.repository.PublicationRepository;
import es.boart.repository.UserRepository;

@Controller
public class BuildBBDD {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@PostConstruct
	public void init(){
		
		Date date = new Date();
		
		/* USUARIOS */
		User invitado = new User("invitado", "Guest", "Guest", "¡Hola! Soy el invitado de prueba, registrate amigo",
				"invitado", "http://www.drlaurelshaler.com/wp-content/uploads/2014/11/Guest.gif",
				0, 0, new Timestamp(date.getTime()), new Timestamp(date.getTime()));
		
		invitado.getGaleria().add(new Publication("Pepe", "Holacaracola", "Descripcion1", 
				"http://wallpapermad.com/wp-content/uploads/2016/05/art-nouveau-wallpaper8.jpg", 1, 
				new Timestamp(date.getTime()), 0));
				
		User usuario = new User("usuario1", "prueba", "prueba", 
				"Aficionado a la fotografía, me gusta fotografiar naturaleza, en especial aves.",
				"pass", 
				"https://yt3.ggpht.com/-9lTuNU-MLtM/AAAAAAAAAAI/AAAAAAAAAAA/SjXmBhMb9PA/s176-c-k-no-mo-rj-c0xffffff/photo.jpg",
				0, 0, new Timestamp(date.getTime()), new Timestamp(date.getTime()));
				
		usuario.getGaleria().add(new Publication("usuario1", "Titulo", "Descripcion", 
				"https://iso.500px.com/wp-content/uploads/2016/03/pedroquintela.jpg", 
				1, new Timestamp(date.getTime()), 0));
		
		usuario.getGaleria().add(new Publication("usuario1", "Titulo", "Descripcion", 
				"http://images1.fanpop.com/images/image_uploads/Photography-photography-1201911_1024_768.jpg", 
				1, new Timestamp(date.getTime()), 0));
		
		usuario.getGaleria().add(new Publication("usuario1", "Titulo", "Descripcion", 
				"http://wallpaperspicturesphotos.com/wp-content/uploads/2015/03/photography-images..jpg", 
				1, new Timestamp(date.getTime()), 0));
		
		usuario.getGaleria().add(new Publication("usuario1", "Titulo", "Descripcion", 
				"https://www.nobackgroundimages.com/wp-content/uploads/2014/12/digital-camera-349873_640.jpg", 
				1, new Timestamp(date.getTime()), 0));
		
		usuario.getGaleria().add(new Publication("usuario1", "Titulo", "Descripcion", 
				"http://images5.fanpop.com/image/photos/31600000/Dandelion-Art-photography-31606827-2560-1706.jpg", 
				1, new Timestamp(date.getTime()), 0));
		
		userRepository.save(invitado);
		userRepository.save(usuario);
		userRepository.save(new User("juan", "Juan", "Cuesta", "Presidente de esta nuestra comunidad.",
				"juanjuan", "http://img1.wikia.nocookie.net/__cb20101228214115/seriesspain/es/images/9/98/Juan_cuesta1.jpg",
				0, 0, new Timestamp(date.getTime()), new Timestamp(date.getTime())));
		
		/* PUBLICACIONES */
		publicationRepository.save(new Publication("Juan", "Holacar2acola", "Descr2ipcion1", 
				"http://wallpapermad.com/wp-content/uploads/2016/05/art-nouveau-wallpaper8.jpg", 1, 
				new Timestamp(date.getTime()), 0));
		
		/* GRUPOS */
		groupRepository.save(new Grupo("Fotógrafos de Vallecas", "Loren ipsun dolor sit amet", "https://scontent-lht6-1.xx.fbcdn.net/v/t1.0-9/16427482_1954388194577132_4182519892385252043_n.jpg?oh=798521399440066d618abe05bc535b27&oe=592DAC5D"));

	}
}
