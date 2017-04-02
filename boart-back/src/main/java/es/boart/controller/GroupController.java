package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import es.boart.UserComponent;
import es.boart.model.Grupo;
import es.boart.model.User;
import es.boart.repository.UserRepository;
import es.boart.services.GroupService;
import es.boart.services.UploadService;

@Controller
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UploadService uploadService;
	@Autowired
	private UserRepository userRepo;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/group/{idGroup}")
	public String group(Model modelo,@PathVariable long idGroup, HttpServletRequest request) {
				
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		
		modelo.addAttribute("idGroup", idGroup);
		modelo.addAttribute("group", groupService.findOne(idGroup));
		
		if(userSession.getUser() != null){
			modelo.addAttribute("userBelongs", groupService.findOne(idGroup).hasUser(userRepo.findOne(userSession.getUser().getId())));
		}
		else{
			modelo.addAttribute("guest", true);
		}
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "group_template";
	}
	
	@RequestMapping("/group/{idGroup}/join/{idUser}")
	public String joinGroup(Model modelo, @PathVariable long idGroup, @PathVariable long idUser) {
		
		Grupo group = groupService.findOne(idGroup);
		User myUser = userRepo.findOne(idUser);
		
		groupService.joinGroup(myUser, group);
		
		return "redirect:/group/"+idGroup;
	}
	
	@RequestMapping("/group/{idGroup}/leave/{idUser}")
	public String leaveGroup(Model modelo, @PathVariable long idGroup, @PathVariable long idUser) {
		
		Grupo group = groupService.findOne(idGroup);
		User myUser = userRepo.findOne(idUser);
		
		groupService.leaveGroup(myUser, group);

		return "redirect:/group/"+idGroup;
	}
	
	@RequestMapping("/group/create")
	public String createGroup(Model modelo, HttpServletRequest request){
		
		modelo.addAttribute("sesion_usuario", userSession.getUser());

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "create_group";
	}
	
	@PostMapping("/group/create")
	public String createGroupForm(Model modelo, Grupo group, @RequestParam(value="inputImage") MultipartFile file){
		System.out.println("Llega");
		
		if(group.getTitle() != null && group.getDescription() != null && !file.getOriginalFilename().equals("")){
			String media = uploadService.prepareImage(file);
			if (!media.equals(""))
			group.setImg("/files/" + media);
		}
		else{
			return "redirect:/group/create";
		}
		
		groupService.save(group);
		
		return "redirect:/group/"+group.getId();
	}
}