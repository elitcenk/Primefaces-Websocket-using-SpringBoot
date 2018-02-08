package tr.com.elitcenk.primefaces.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by calp on 6.02.2018.
 */

@Component
@Scope ("application")
public class ChatUsers implements Serializable {

	private List<String> users;

	@PostConstruct
	public void init() {
		users = new ArrayList<>();
	}

	public List<String> getUsers() {
		return users;
	}

	public void remove(String user) {
		this.users.remove(user);
	}

	public void add(String user) {
		this.users.add(user);
	}

	public boolean contains(String user) {
		return this.users.contains(user);
	}
}
