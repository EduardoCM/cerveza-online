package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("catalogo-cerveza-online-service")
public interface CatalogoClient {
	
	@GetMapping("")
	Resources<Cerveza> buscarCervezas();

}
