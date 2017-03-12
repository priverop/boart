package es.boart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.boart.model.Comment;
import es.boart.model.Grupo;
import es.boart.model.Publication;
import es.boart.model.Tag;
import es.boart.model.User;
import es.boart.repository.GroupRepository;
import es.boart.repository.PublicationRepository;
import es.boart.repository.TagRepository;
import es.boart.repository.UserRepository;

@Controller
public class BuildBBDD {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PublicationRepository publicationRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private TagRepository tagRepository;

	@PostConstruct
	public void init() {

		/* USUARIOS */
//
		User usuario = new User("usuario1", "prueba", "prueba", "pass", "ROLE_USER");
//
//		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", "imgEjemplo2.jpg", 0));
//
//		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", "113585294", 1));
//
//		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", "gw5LxIOsaBo", 2));
//
//		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", "imgEjemplo4.jpg", 0));
//
//		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", "imgEjemplo3.jpg", 0));
//
		
		User juan = new User("juan", "Juan", "Cuesta", "juanjuan", "ROLE_USER");
		
		List<User> lUsers = new ArrayList<>();		
		lUsers.add(new User("m0scar", "Oscar", "Ballesteros", "1234", "ROLE_USER"));
		lUsers.add(new User("nexmaniosis", "Pablo", "Rivero", "juanjuan", "ROLE_USER"));
		lUsers.add(new User("gcuencam", "Gabriel", "Cuenca", "1234", "ROLE_USER"));
		lUsers.add(new User("aitorGaleano", "Aitor", "Galeano", "124", "ROLE_USER"));
		lUsers.add(new User("ramonCapitan", "Ramón", "Capitán", "1234", "ROLE_USER"));
		lUsers.add(new User("celiaGaspar", "Celia", "Gaspar", "1234", "ROLE_USER"));
		lUsers.add(new User("carlaNavarro", "Carla", "Navarro", "1234", "ROLE_USER"));
		lUsers.add(new User("montserratDelValle", "Monstserrat", "Del Valle", "1234", "ROLE_USER"));
		lUsers.add(new User("mRosarioAyala", "María Rosario", "Ayala", "1234", "ROLE_USER"));
		lUsers.add(new User("nataliaTorras", "Natalia", "Torras", "1234", "ROLE_USER"));
		lUsers.add(new User("joseMariaNieves", "José María", "Nieves", "1234", "ROLE_USER"));
		lUsers.add(new User("ismaelMoreno", "Ismael", "Moreno", "1234", "ROLE_USER"));
		lUsers.add(new User("albertMesa", "Albert", "Mesa", "1234", "ROLE_USER"));
		lUsers.add(new User("hugoPariente", "Hugo", "Pariente", "1234", "ROLE_USER"));
		lUsers.add(new User("vicenteGuash", "Vicente", "Guash", "1234", "ROLE_USER"));
		lUsers.add(new User("consueloCasas", "Consuelo", "Casas", "1234", "ROLE_USER"));
		lUsers.add(new User("cristinaCrespo", "Cristina", "Crespo", "1234", "ROLE_USER"));
		lUsers.add(new User("pilarGarzon", "Pilar", "Garzón", "1234", "ROLE_USER"));

		for (User u: lUsers){
			userRepository.save(u);
		}
		

		
		
		juan.getComments().add(new Comment(usuario, "Váyase señor Juan!!"));

		userRepository.save(usuario);
		userRepository.save(juan);

		for (int i = 0; i < 25; i++) {
			User newUser = new User("user" + i, "name" + i, "surname" + i, "pass" + i, "ROLE_USER");
			userRepository.save(newUser);
		}

		juan.addFollowing(usuario);
		userRepository.save(juan);
		
		
		
		/* PUBLICACIONES */
		//Publication publication = new Publication(juan, "", "", ".jpg", 0);
		List<Publication> lPublications = new ArrayList<>();		
								
		lPublications.add(new Publication(juan, "Lisístrata", "Gata Cattana, Lisístrata", "GsMDU8gb5sQ", 2));
		lPublications.add(new Publication(juan, "ANCIENT GOD", "An old machine which was destroyed in war. Now it's just a garbage - perfect source of resources for pirates.", "1.jpg", 0));		
		lPublications.add(new Publication(juan, "Werewolf", "werewolf lurking REIMAGINED", "2.jpg", 0));
		lPublications.add(new Publication(juan, "Epiclesis", "\"When we doubt about everything we know\".", "3.jpg", 0));
		lPublications.add(new Publication(juan, "Chinese Dragon", "Last year I was fortunate enough to get the opportunity to work on a dragon book for Scholastic by way of Becker&Mayer Books. I got to take a crack at designing 16 different mythical dragons from all over the world for a book called Sink Your Teeth Into Dragons.", "4.jpg", 0));
		lPublications.add(new Publication(juan, "Red dragon", "The dragon IS A MODERN DAY PICTURE REPRESENTING HOW FURIOUS A WOMEN CAN BE ON HER PERIOD. that's what he says to me when i look at this art.", "5.jpg", 0));
		lPublications.add(new Publication(juan, "Dragon Cove", "I made the background for this about a year ago and then forgot about it. I recently found it and had the inspiration to finish it! I am really happy with how it turned out, one of the few of my works that actually turned out exactly like I envisioned. ", "6.jpg", 0));
		lPublications.add(new Publication(juan, "Forbidden Kingdom", "Forbidden Kingdom", "7.jpg", 0));
		lPublications.add(new Publication(juan, "Angelus of Hope", "Personal work, completed early 2012.", "8.jpg", 0));
		
		lPublications.add(new Publication(juan, "Cant Forgive", "Album: Temptation of Wife","113585294", 1));
		lPublications.add(new Publication(juan, "Chopin Nocturne in F Minor-Op. 55", "Produced by Chad Lawson & Alejandro Clavijo. Mixed by Stephen Lee Price. Mastered by Michael Graves of Osiris Studios (Atlanta, GA).", "164691599", 1));
		lPublications.add(new Publication(juan, "Sibelius Violin Concerto 1st Movement", "Performed live on March 26th, 2015 with the Gothenburg Symphony Orchestra and Maestro Kent Nagano","206466890", 1));
		lPublications.add(new Publication(juan, "300 Violin Orchestra", "300 Violin orchestra has become a sports anthem and very well known among the pump up songs category. ","12417512",  1));
		lPublications.add(new Publication(juan, "Mozart: Concerto for Piano no 25", "The New England Conservatory Philharmonia led by guest conductor Jefferey Kahane at the keyboard, present Mozart's Concerto for Piano no 25 in C major","121863093",  1));
		lPublications.add(new Publication(juan, "Yiruma - River Flows in You", "Cello & Piano Orchestral Version ft. Yiruma - River Flows in You","129893792",  1));
		lPublications.add(new Publication(juan, "Beethoven - Moonlight Sonata", "I was just practicing tonight and felt like recording one of the pieces.","24880470",  1));
		lPublications.add(new Publication(juan, "Fur Elise", "Ludwig Van Beethoven-- Fur Elise","65833474",  1));
		lPublications.add(new Publication(juan, "LaLa Land movie Theme", "Piano Cover","301212235",  1));
		lPublications.add(new Publication(juan, "Bullet Train", "by Stephen Swartz ft. Joni Fatora","57809396",  1));
		lPublications.add(new Publication(juan, "Asylum", "STRANGUH - Asylum","311584848",  1));
		lPublications.add(new Publication(juan, "Mortal Kombat Dance", "Valentino Jorno - Mortal Kombat Dance","264398016",  1));
		lPublications.add(new Publication(juan, "Hysteria", "Boombox Cartel - Hysteria (WTF Is Festival Trap Anthem)","98264534",  1));
		lPublications.add(new Publication(juan, "Reload ", "Sebastian Ingrosso & Tommy Trash - Reload (BARE Remix)","86616680",  1));
		
		lPublications.add(new Publication(juan, "Triple concerto", "Beethoven, Concerto for piano, violin, cello and orchestra", "hZZaztTNsEc", 2));
		lPublications.add(new Publication(juan, "The Greatest", "Sia (Piano Cover) - Costantino Carrara", "AYRb9WqYEzA", 2));
		lPublications.add(new Publication(juan, "Faded", "Faded - Alan Walker (fingerstyle guitar cover by Peter Gergely)", "69A2xXbI7QA", 2));
		lPublications.add(new Publication(juan, "See You Again", "See You Again - Wiz Khalifa ft. Charlie Puth (fingerstyle guitar cover by Peter Gergely)", "gnGA1o43UOI", 2));
		lPublications.add(new Publication(juan, "Rogue One Trailer", "STAR WARS - Rogue One Trailer (Orchestral/Piano Cover)", "RPuwzdkUEFo", 2));
		lPublications.add(new Publication(juan, "The Force Awakens Trailer", "STAR WARS - The Force Awakens Trailer (Orchestral/Piano Cover)", "aaanIU3fW40", 2));
		lPublications.add(new Publication(juan, "America's Great Spaces", "Dazzling Time-Lapse Reveals America's Great Spaces | National Geographic", "9d8wWcJLnFI", 2));
		lPublications.add(new Publication(juan, "NORWAY", "NORWAY - A Time-Lapse Adventure 4K", "Scxs7L0vhZ4", 2));
		lPublications.add(new Publication(juan, "Street Traffic", "Watch Time Lapse - Street Traffic at Night", "05pdi-MzvAI", 2));
		lPublications.add(new Publication(juan, "The magnificent landscape of Iceland", "Drone and time lapse footage I've shot while travelling and guiding photographers in the magnificent landscape of Iceland.", "wN8_eb3l0mw", 2));
		lPublications.add(new Publication(juan, "Alone in the Night", "Time-lapse footage of the Earth as seen from the ISS", "FG0fTKAqZ5g", 2));
		lPublications.add(new Publication(juan, "POILUS Short Film", "CGI 3D Animated Short Film HD: \"POILUS Short Film\" by ISART DIGITAL", "Cwn3Ru0o8Io", 2));
		lPublications.add(new Publication(juan, "Fat Animated Short Film", "Funny 3D Animation Short Film For Kids - Fat Animated Short Film", "gzi9r20misE", 2));


		List<String> lComments = new ArrayList<>();
		lComments.add("WOW");
		lComments.add("Wonderful");
		lComments.add("Beautiful!");
		lComments.add("So elegant");
		lComments.add("I love it");
		lComments.add("This is epic");
		lComments.add("looks nice!");
		lComments.add("Amazing work!");
		lComments.add("awesome");
		lComments.add("Absolutely gorgeous!");
		lComments.add("Impressive");
		lComments.add("amazing piece");
		lComments.add("Gorgeous!");
		lComments.add("what a tremendous work!");
		lComments.add("Such style and skill!");
		lComments.add("It's absolute amazing.");
		lComments.add("cool!");
		lComments.add("Beautiful <3 ");
		lComments.add("Looks great!");
		lComments.add("insaaaneeely good and stunning :d");
		lComments.add("i have no words");
		lComments.add("Inspiring!");
		lComments.add("sooooo coooool");
		lComments.add("so pretty");
		lComments.add("Aaah! this is amazing!");
		lComments.add("beautiful artwork");
		lComments.add("Awesome job!");
		lComments.add("This is beautiful and cute");

		publicationRepository.save(lPublications);
//		publication.getComments().add(new Comment(usuario, "Gabri no me espies"));
		
		addTags(lPublications.get(0), Arrays.asList("rap", "gata", "cattana", "dep"));
		addTags(lPublications.get(1), Arrays.asList("epic", "galaxy", "god", "dark", "photo", "boart"));
		addTags(lPublications.get(2), Arrays.asList("epic", "dark", "wolf"));
		addTags(lPublications.get(3), Arrays.asList("saint", "boart", "conceptual", "religion", "symbolism"));
		addTags(lPublications.get(4), Arrays.asList("alligator", "china", "lizard", "epic", "dragon"));
		addTags(lPublications.get(5), Arrays.asList("dragon", "boart", "red", "epic"));
		addTags(lPublications.get(6), Arrays.asList("dragon", "pink", "dark"));
		addTags(lPublications.get(7), Arrays.asList("kingdom", "cascade", "dark", "god"));
		addTags(lPublications.get(8), Arrays.asList("heaven", "angel", "wings", "god", "beauty"));
		addTags(lPublications.get(9), Arrays.asList("sad", "piano", "violin", "nostalgia", "boart", "beauty"));
		addTags(lPublications.get(10), Arrays.asList("piano", "violin", "cello", "chopin"));
		addTags(lPublications.get(11), Arrays.asList("violin", "concert", "boart", "orchestra"));		
		addTags(lPublications.get(12), Arrays.asList("violin", "orchestra", "concert"));
		addTags(lPublications.get(13), Arrays.asList("concert", "orchestra", "mozart", "piano"));
		addTags(lPublications.get(14), Arrays.asList("piano", "orchestra", "boart", "music"));
		addTags(lPublications.get(15), Arrays.asList("piano", "beethoven", "sonata", "epic", "dark", "beauty"));
		addTags(lPublications.get(16), Arrays.asList("piano", "beethoven", "religion", "music"));	
		addTags(lPublications.get(17), Arrays.asList("piano", "cover", "lalaland", "boart"));
		addTags(lPublications.get(18), Arrays.asList("music", "dubstep", "electronic", "epic"));
		addTags(lPublications.get(19), Arrays.asList("music", "dubstep", "electronic"));
		addTags(lPublications.get(20), Arrays.asList("music", "electronic", "dance", "techno", "boart"));
		addTags(lPublications.get(21), Arrays.asList("music", "electronic", "techno"));
		addTags(lPublications.get(22), Arrays.asList("music", "electronic", "techno", "house", "epic"));
		addTags(lPublications.get(23), Arrays.asList("music", "orchestra", "concert", "beethoven", "piano", "violin", "cello"));
		addTags(lPublications.get(24), Arrays.asList("music", "piano", "cover", "boart"));
		addTags(lPublications.get(25), Arrays.asList("guitar", "cover", "epic", "god"));
		addTags(lPublications.get(26), Arrays.asList("guitar", "cover", "boart", "music"));
		addTags(lPublications.get(27), Arrays.asList("cover", "piano", "star wars"));
		addTags(lPublications.get(28), Arrays.asList("cover", "piano", "star wars"));
		addTags(lPublications.get(29), Arrays.asList("landscape", "america", "heaven", "time-lapse"));
		addTags(lPublications.get(30), Arrays.asList("landscape", "norway", "beauty", "time-lapse"));
		addTags(lPublications.get(31), Arrays.asList("time-lapse", "steet", "boart"));
		addTags(lPublications.get(32), Arrays.asList("landscape", "iceland", "beauty"));
		addTags(lPublications.get(33), Arrays.asList("galaxy", "earth", "time-lapse", "epic", "iss", "dark"));
		addTags(lPublications.get(34), Arrays.asList("short film", "animation" + "3d"));
		addTags(lPublications.get(35), Arrays.asList("short film", "animation" + "3d", "boart"));

		Random ran = new Random();
		int x = ran.nextInt(lComments.size());
		for(Publication p: lPublications){
			for (int i = ran.nextInt(lComments.size()); i < lComments.size(); i++){
				p.getComments().add(new Comment(lUsers.get(ran.nextInt(lUsers.size())),lComments.get(ran.nextInt(lComments.size()))));
				p.setNumberOfComments(p.getComments().size());
			}
		}

		publicationRepository.save(lPublications);
		
		/* GRUPOS */
		groupRepository.save(new Grupo("Fotógrafos de Vallecas", "http://i.imgur.com/WZ9qZwH.jpg", "Loren ipsun dolor sit amet"));

//		Tag t1 = new Tag("tag1");
//		Tag t2 = new Tag("tag2");
//		Tag t3 = new Tag("tag3");
//		Tag t4 = new Tag("tag3");
//
//
//		for (Publication p : publicationRepository.findAll()) {
//			if (p.getId() % 3 == 0)
//				t1.getPublications().add(p);
//			// p.getTags().add(t1);
//			if (p.getId() % 3 == 1)
//				t2.getPublications().add(p);
//			// p.getTags().add(t2);
//			if (p.getId() % 3 == 2)
////				t4.getPublications().add(p);
//			// p.getTags().add(t3);
//		}
//
//		tagRepository.save(t1);
//		tagRepository.save(t2);
//		tagRepository.save(t3);
//		tagRepository.save(t4);

	}
	
	Map<String, Tag> mTags = new HashMap<>();
	public void addTags(Publication p, List<String> tags){
		for (String s:tags){
			Tag tag = mTags.get(s);			
			if (tag == null){ 
				tag = new Tag(s);
				mTags.put(s,tag);
			}
			tag.getPublications().add(p);
			tagRepository.save(tag);
		}
	}
}
