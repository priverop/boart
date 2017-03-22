package es.boart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.boart.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);

}
