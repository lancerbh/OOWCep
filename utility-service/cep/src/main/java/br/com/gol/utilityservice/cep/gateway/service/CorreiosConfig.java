package br.com.gol.utilityservice.cep.gateway.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Configuration
public class CorreiosConfig extends WebServiceGatewaySupport {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("br.com.gol.utilityservice.cep.gateway.model");
		return marshaller;
	}

	@Bean
	public CorreiosClient correiosClient(Jaxb2Marshaller marshaller) {
	   CorreiosClient client = new CorreiosClient();
		client.setDefaultUri("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}