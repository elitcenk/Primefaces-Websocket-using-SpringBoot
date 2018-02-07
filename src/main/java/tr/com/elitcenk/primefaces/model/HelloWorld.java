package tr.com.elitcenk.primefaces.model;

import javax.faces.bean.ManagedBean;

/**
 * Created by calp on 7.02.2018.
 */
@ManagedBean
public class HelloWorld {
	private String firstName = "Elit Cenk";
	private String lastName = "Alp";

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String showGreeting() {
		return "Hello " + firstName + " " + lastName + "!";
	}
}
