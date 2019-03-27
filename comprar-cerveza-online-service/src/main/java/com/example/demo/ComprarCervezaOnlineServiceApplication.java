package com.example.demo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ComprarCervezaOnlineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComprarCervezaOnlineServiceApplication.class, args);
	}

}

class Cerveza {

	private String nombre;
	private String nacionalidad;

	public Cerveza() {

	}

	public Cerveza(String nombre, String nacionalidad) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
}


@FeignClient("CATALOGO-CERVEZA-ONLINE-SERVICE")
interface CatalogoClient {
	
	@GetMapping("/api/v1/cerveza/catalogo")
	List<Cerveza> buscarCervezas();

}


@RestController
class ComprarCervezasAPI {
	
	
	
	private final CatalogoClient catalogoClient;
	
	public ComprarCervezasAPI(CatalogoClient catalogoClient) {
		this.catalogoClient = catalogoClient;
	}
	
	@GetMapping("/comprar")
	public List<Cerveza> comprarCerveza(){
	     return catalogoClient.buscarCervezas()
	    		 .stream()
	    		 .filter(this::isMexicana)
	    		 .collect(Collectors.toList());
	}
	
	public boolean isMexicana(Cerveza cerveza) {
		return cerveza.getNacionalidad().equals("Mexicana");
	}
	

}
