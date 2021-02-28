package com.consumidorapi.service;


import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.consumidorapi.model.Endereco;

public class ViaCepService {
	
	private RestTemplate restTemplate = new RestTemplate();
	private String urlBase = "http://viacep.com.br/ws";
	private String formResp = "/json/";
	private ResponseEntity<Endereco> response;
	
	public ResponseEntity<Endereco> httpGetBuscar(String path){
		response = restTemplate.getForEntity(urlBase +path+formResp, Endereco.class);
		return response;
	}
	public Endereco httpGetPesquisa(String path) {
		Endereco endereco = new Endereco();
		endereco = restTemplate.getForObject(urlBase +path+formResp, Endereco.class);
		return endereco;
	}
	public List<Endereco> httpGetLista(String uf,String cidade, String logradouro){
		Endereco endereco[] = restTemplate.getForObject(urlBase+uf+cidade+logradouro+formResp, Endereco[].class);
		return Arrays.asList(endereco);
	}

}
