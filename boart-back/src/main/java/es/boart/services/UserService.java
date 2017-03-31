package es.boart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.boart.model.User;
import es.boart.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
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
}
