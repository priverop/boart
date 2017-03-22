package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import es.boart.UserComponent;
import es.boart.model.User;
import es.boart.repository.UserRepository;

@Controller
public class PrivateProfileController {
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/private_profile")
	public String perfil(Model modelo, HttpSession session, HttpServletRequest request) {

		modelo.addAttribute("sesion_usuario", userSession.getUser());
		
		if(userSession.getUser() != null){
			User myUser = userRepo.findOne(userSession.getUser().getId());
		
			modelo.addAttribute("usuario", myUser);
			modelo.addAttribute("followings", myUser.getFollowing());
			modelo.addAttribute("followers", myUser.getFollowers());
			modelo.addAttribute("groups", myUser.getGroups());
		}
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());

		return "private_profile_template";
	}
	
	@PostMapping("/edit_profile")
	public String register(User usuario, @RequestParam(value="inputFile", required=false) MultipartFile file){

		if(usuario.getId() == userSession.getUser().getId()){
			
			User user = userRepo.findOne(usuario.getId());
			
			if(usuario.getName() != null){
				user.setName(usuario.getName());
			}
			
			if(usuario.getSurname() != null){
				user.setSurname(usuario.getSurname());
			}
			
			if(usuario.getUsername() != null){
				user.setUsername(usuario.getUsername());
			}
			
			if(usuario.getPassword() != null){
				user.setPassword(usuario.getPassword());
			}
			
			if(usuario.getDescription() != null){
				user.setDescription(usuario.getDescription());
			}		
			
			if(!file.getOriginalFilename().equals("")){
				String media = es.boart.controller.UploadController.prepareImage(file, "");
				if (!media.equals(""))
				user.setImg("/files/" + media);			
			}
					
			userRepo.save(user);
			userSession.setUser(user);
		}

		return "redirect:/private_profile";
	}
}
