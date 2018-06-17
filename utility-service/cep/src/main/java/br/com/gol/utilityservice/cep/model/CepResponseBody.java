package br.com.gol.utilityservice.cep.model;

import br.com.gol.utilityservice.commons.model.JsonObject;
import io.swagger.annotations.ApiModelProperty;

public class CepResponseBody extends JsonObject {

   @ApiModelProperty(value = "${api.zip.response.body.id}", required = true, position = 1, example = "0")
	private long id;
	@ApiModelProperty(value = "${api.zip.response.body.bairro}", required = true, position = 1, example = "Palmeiras")
	private String bairro;
	@ApiModelProperty(value = "${api.zip.response.body.cep}", required = true, position = 1, example = "30575600")
	private String cep;
	@ApiModelProperty(value = "${api.zip.response.body.cidade}", required = true, position = 1, example = "Belo Horizonte")
	private String cidade;
	@ApiModelProperty(value = "${api.zip.response.body.complemento}", required = true, position = 1, example = "")
	private String complemento;
	@ApiModelProperty(value = "${api.zip.response.body.complemento2}", required = true, position = 1, example = "")
	private String complemento2;
	@ApiModelProperty(value = "${api.zip.response.body.end}", required = true, position = 1, example = "Rua Venero Caetano da Fonseca")
	private String end;
	@ApiModelProperty(value = "${api.zip.response.body.uf}", required = true, position = 1, example = "MG")
	private String uf;

	public CepResponseBody() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getComplemento2() {
		return complemento2;
	}

	public void setComplemento2(String complemento2) {
		this.complemento2 = complemento2;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}