package br.com.gol.utilityservice.cep.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gol.utilityservice.cep.exception.UtilityServiceCepException;
import br.com.gol.utilityservice.cep.gateway.model.ConsultaCEPResponse;
import br.com.gol.utilityservice.cep.gateway.model.EnderecoERP;
import br.com.gol.utilityservice.cep.gateway.service.CorreiosClient;
import br.com.gol.utilityservice.cep.model.CepResponseBody;
import br.com.gol.utilityservice.commons.model.ApiError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Lancer
 */
@RestController
@RequestMapping("/")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Api(tags = { CepRestController.TAG })
public final class CepRestController {

   public static final String TAG = "CEP";

   private static final Log LOG = LogFactory.getLog(CepRestController.class);

   @Autowired
   private CorreiosClient correiosClient;

   // @formatter:off
	@ApiOperation(value = "${api.cep.do}", response = CepResponseBody.class, tags = CepRestController.TAG)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Sucesso", response = CepResponseBody.class),
			@ApiResponse(code = 500, message = "Erro", response = ApiError.class)
	})
	@GetMapping(value = "/cep/{cep:.+}",
         produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	// @formatter:on
   public ResponseEntity<CepResponseBody> queryByCep(
         @ApiParam(value = "${api.zip.request.param.cep}", required = true, example = "30575080") @PathVariable("cep") String cep)
         throws UtilityServiceCepException {

      try {

         cep = cep == null ? "" : cep.replaceAll("[^0-9]", "");
         if (cep.isEmpty()) {
            throw new UtilityServiceCepException(String.format("CEP invalido: %s", cep), null);
         }

         LOG.info(String.format("Consultando CEP: %s", cep));

         ConsultaCEPResponse resWS = correiosClient.consultaCEP(String.valueOf(cep));
         if (resWS == null || resWS.getReturn() == null) {
            throw new UtilityServiceCepException(String.format("Nao houve retorno para o CEP: %s", cep), null);
         }

         EnderecoERP end = resWS.getReturn();

         CepResponseBody res = new CepResponseBody();
         res.setBairro(end.getBairro());
         res.setCep(end.getCep());
         res.setCidade(end.getCidade());
         res.setComplemento(end.getComplemento());
         res.setComplemento2(end.getComplemento2());
         res.setEnd(end.getEnd());
         res.setId(end.getId());
         res.setUf(end.getUf());

         return new ResponseEntity<CepResponseBody>(res, HttpStatus.OK);

      } catch (UtilityServiceCepException ex) {
         throw ex;
      } catch (Exception ex) {
         throw new UtilityServiceCepException(ex.getMessage(), ex);
      }
   }

}
