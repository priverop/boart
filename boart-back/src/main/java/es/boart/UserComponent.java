package es.boart;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import es.boart.model.User;

@Component
@SessionScope
public class UserComponent {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
