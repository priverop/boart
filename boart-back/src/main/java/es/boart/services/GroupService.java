package es.boart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.boart.model.Grupo;
import es.boart.model.User;
import es.boart.repository.GroupRepository;

@Service
public class GroupService {
	
	@Autowired
	private GroupRepository groupRepository;
	
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

}
