package es.boart;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import es.boart.model.Usuario;

@Component
@SessionScope
public class UserComponent {

	private Usuario user;

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
