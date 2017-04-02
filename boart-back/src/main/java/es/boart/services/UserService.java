package es.boart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.boart.UserComponent;
import es.boart.model.Comment;
import es.boart.model.Publication;
import es.boart.model.User;
import es.boart.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserComponent userSession;
	
	public User findOne(long id){
		return userRepository.findOne(id);
	}
	
	public User findByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public void save(User u){
		userRepository.save(u);
	}
	
	public void followUser(User myUser, User follow){

		myUser.addFollowing(follow);
		
		userRepository.save(myUser);
	}

	public void unfollowUser(User myUser, User unfollow){
		
		myUser.removeFollowing(unfollow);
		userRepository.save(myUser);
		
	}
	
	public User registerUser(String username, String name, String surname, String password){
		User newUser = new User(username, name, surname, password);
		userRepository.save(newUser);
		
		return newUser;
	}
	
	public void addComment(String text, long idLocation){		
		if (!text.equals("")){
			Comment newComment = new Comment(userSession.getUser(), text);
			User user = findOne(idLocation);
			user.getComments().add(newComment);			
			save(user);
		}
	}
}
