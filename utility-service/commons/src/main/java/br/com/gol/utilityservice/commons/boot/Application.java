package br.com.gol.utilityservice.commons.boot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

public abstract class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

	private final Class<?> clazz;

	protected Application(final Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(clazz).properties("spring.config.name=application,application-base");
	}

}