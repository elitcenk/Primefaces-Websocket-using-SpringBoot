package tr.com.elitcenk.primefaces;

import org.primefaces.push.PushServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * Created by calp on 8.02.2018.
 */
@Configuration
public class JsfConfig {


	@Bean
	ServletRegistrationBean pushServletRegistration() {
		ServletRegistrationBean pushServlet = new ServletRegistrationBean(new PushServlet(), "/primepush/*");
		pushServlet.addInitParameter("org.atmosphere.annotation.packages", "org.primefaces.push");
		pushServlet.addInitParameter("org.atmosphere.cpr.packages", "tr.com.elitcenk.primefaces.service");
		pushServlet.setAsyncSupported(true);
		pushServlet.setLoadOnStartup(0);
		pushServlet.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return pushServlet;
	}

}
