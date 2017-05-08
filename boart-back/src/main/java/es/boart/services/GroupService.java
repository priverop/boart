package es.boart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import es.boart.model.Grupo;
import es.boart.model.User;
import es.boart.repository.GroupRepository;

@Service
public class GroupService {
	
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private UploadService uploadService;
	
	public Grupo findOne(long id){
		return groupRepository.findOne(id);
	}
	
	public List<Grupo> findAll(){
		return groupRepository.findAll();
	}
	
	public void save(Grupo g){
		groupRepository.save(g);
	}
	
	public void joinGroup(User u, Grupo g){
		g.addMember(u);
		groupRepository.save(g);
	}
	
	public void leaveGroup(User u, Grupo g){
		g.removeMember(u);
		groupRepository.save(g);
	}
	
	@PostMapping("/create")
	public Grupo createGroup(Grupo group, MultipartFile file){		
		if(group.getTitle() != null && group.getDescription() != null && !file.getOriginalFilename().equals("")){
			String media = uploadService.prepareImage(file);
			if (!media.equals(null))
			group.setImg("img/" + media);
		}
		else{
			return null;
		}		
		save(group);		
		return group;
	}

}
