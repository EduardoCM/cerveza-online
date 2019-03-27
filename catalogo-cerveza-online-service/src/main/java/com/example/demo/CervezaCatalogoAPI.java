package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cerveza/catalogo")
public class CervezaCatalogoAPI {

	static List<Cerveza> cervezas = new ArrayList<>();
	
	static {
		Cerveza corona = new Cerveza();
		corona.setNombre("Corona");
		corona.setNacionalidad("Mexicana");
		
		cervezas.add(corona);
	}
	
	@GetMapping
	public List<Cerveza> getAll(){
		return cervezas;
	}
}