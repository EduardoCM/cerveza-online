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
		
		Cerveza corona2 = new Cerveza();
		corona2.setNombre("Corona2");
		corona2.setNacionalidad("Mexicana");
		
		Cerveza corona3 = new Cerveza();
		corona3.setNombre("Corona3");
		corona3.setNacionalidad("Brazil");
		
		Cerveza corona4 = new Cerveza();
		corona4.setNombre("Corona4");
		corona4.setNacionalidad("Brazil");
		
		cervezas.add(corona);
		cervezas.add(corona2);
		cervezas.add(corona3);
		cervezas.add(corona4);
	}
	
	@GetMapping
	public List<Cerveza> getAll(){
		return cervezas;
	}
}