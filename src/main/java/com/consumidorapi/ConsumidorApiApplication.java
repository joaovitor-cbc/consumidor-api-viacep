package com.consumidorapi;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import com.consumidorapi.model.Endereco;
import com.consumidorapi.service.ViaCepService;

@SpringBootApplication
public class ConsumidorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumidorApiApplication.class, args);
		Endereco endereco = new Endereco();
		ViaCepService service = new ViaCepService();
		ResponseEntity<Endereco> response  = service.httpGetBuscar("/01528070");
		System.out.println(response);
		endereco = service.httpGetPesquisa("/01528070");
		System.out.println(endereco);
		System.out.println(endereco.getCep());
		List<Endereco> lista = service.httpGetLista("/RS", "/Porto Alegre", "/Domingos");
		for(Endereco e : lista) {
			System.out.println(e);
		}
		System.out.println(lista.isEmpty());
	}
}
