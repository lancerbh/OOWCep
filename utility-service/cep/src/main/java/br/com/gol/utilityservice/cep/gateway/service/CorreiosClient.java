package br.com.gol.utilityservice.cep.gateway.service;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import br.com.gol.utilityservice.cep.exception.UtilityServiceCepException;
import br.com.gol.utilityservice.cep.gateway.model.ConsultaCEP;
import br.com.gol.utilityservice.cep.gateway.model.ConsultaCEPResponse;
import br.com.gol.utilityservice.cep.gateway.model.ObjectFactory;

public class CorreiosClient extends WebServiceGatewaySupport {

   @SuppressWarnings("unchecked")
   public ConsultaCEPResponse consultaCEP(String cep) throws UtilityServiceCepException {
      try {
         ObjectFactory factory = new ObjectFactory();

         ConsultaCEP consultaCEP = factory.createConsultaCEP();
         consultaCEP.setCep(cep);
         JAXBElement<ConsultaCEP> request = factory.createConsultaCEP(consultaCEP);

         return ((JAXBElement<ConsultaCEPResponse>) getWebServiceTemplate().marshalSendAndReceive(request)).getValue();

      } catch (Exception ex) {
         throw new UtilityServiceCepException(String.format("Erro ao consultar CEP: %s", ex.getMessage()), ex);
      }
   }

}