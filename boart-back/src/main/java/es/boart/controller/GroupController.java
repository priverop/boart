package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.UserComponent;
import es.boart.model.Grupo;
import es.boart.repository.GroupRepository;
import es.boart.repository.UserRepository;

@Controller
public class GroupController {
	
	@Autowired
	private GroupRepository groupRepo;
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/group/{idGroup}")
	public String group(Model modelo,@PathVariable long idGroup, HttpServletRequest request) {
				
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		
		modelo.addAttribute("idGroup", idGroup);
		modelo.addAttribute("group", groupRepo.findOne(idGroup));
		
		if(userSession.getUser() != null){
			modelo.addAttribute("userBelongs", groupRepo.findOne(idGroup).hasUser(userRepo.findOne(userSession.getUser().getId())));
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
		
		Grupo group = groupRepo.findOne(idGroup);
		
		group.addMember(userRepo.findOne(idUser));
		
		groupRepo.save(group);

		return "redirect:/group/"+idGroup;
	}
	
	@RequestMapping("/group/{idGroup}/leave/{idUser}")
	public String leaveGroup(Model modelo, @PathVariable long idGroup, @PathVariable long idUser) {
		
		Grupo group = groupRepo.findOne(idGroup);
		
		group.removeMember(userRepo.findOne(idUser));
		
		groupRepo.save(group);

		return "redirect:/group/"+idGroup;
	}
}