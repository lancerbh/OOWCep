package br.com.gol.utilityservice.cep;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("br.com.gol.utilityservice")
public class Application extends br.com.gol.utilityservice.commons.boot.Application {

	public Application() {
		super(Application.class);
	}

}