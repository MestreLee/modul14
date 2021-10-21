package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BotiguesDAO;
import com.example.demo.dao.QuadresDAO;
import com.example.demo.models.Botiga;
import com.example.demo.models.Quadre;


@RestController
@RequestMapping("")
public class ControladorRest {
	
	@Autowired
	BotiguesDAO botiguesDAO;
	
	@Autowired
	QuadresDAO quadresDAO;

	//veure totes les botigues
	@GetMapping("/botigues")
	public ResponseEntity<List<Botiga>> getBotigues(){
		List<Botiga> botigues = botiguesDAO.findAll();
		return ResponseEntity.ok(botigues);
		
	}
	
	//veure tots els quadres
	@GetMapping("/quadres")
	public ResponseEntity<List<Quadre>> getAllQuadres(){
		List<Quadre> quadres = quadresDAO.findAll();
		return ResponseEntity.ok(quadres);
		
	}
	
	//veure els quadres que pertanyen a una botiga en concret
	@GetMapping("/botigues/{botigaID}/quadres")
	public ResponseEntity<List<Quadre>> getQuadres(@PathVariable("botigaID") int botigaID){
		List<Quadre> quadres = quadresDAO.findBybotigaid(botigaID);
		return ResponseEntity.ok(quadres);
	}
	
	//afegir una botiga nova
	@PostMapping("/botigues")
	public ResponseEntity<Botiga> crearBotiga(@RequestBody Botiga botiga){
		Botiga newBotiga = botiguesDAO.save(botiga);
		return ResponseEntity.ok(newBotiga);
	}
	
	//afegir una quadre nou a una botiga
	@PostMapping("/botigues/{botigaID}/quadres")
	public ResponseEntity<Quadre> crearQuadre(@PathVariable("botigaID") int botigaID, @RequestBody Quadre quadre){
		Optional<Botiga> optionalBotiga = botiguesDAO.findById(botigaID);
		if(optionalBotiga.isPresent()) {
			Quadre newQuadre = new Quadre();
			newQuadre.setBotigaid(botigaID);
			newQuadre.setNomautor(quadre.getNomautor());
			newQuadre.setNomquadre(quadre.getNomquadre());
			newQuadre.setPreu(quadre.getPreu());
			quadresDAO.save(newQuadre);
			return ResponseEntity.ok(newQuadre);
		}else {
			return ResponseEntity.noContent().build();
		}

	}	
	
	//modificar una botiga en concret segons la seva id
	@PutMapping(value="/botigues/{botigaID}")
	public ResponseEntity<Botiga> updateBotiga(@PathVariable("botigaID") int botigaID, @RequestBody Botiga botiga){
		Optional<Botiga> optionalBotiga = botiguesDAO.findById(botigaID);
		if(optionalBotiga.isPresent()) {
			Botiga updateBotiga = optionalBotiga.get();
			updateBotiga.setNom(botiga.getNom());
			updateBotiga.setMaxquadres(botiga.getMaxquadres());
			botiguesDAO.save(updateBotiga);
			return ResponseEntity.ok(updateBotiga);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//modifica un quadre en concret segons la seva id
	@PutMapping(value="/botigues/{botigaID}/quadres/{quadreID}")
	public ResponseEntity<Quadre> updateQuadre(@PathVariable("quadreID") int quadreID, @RequestBody Quadre quadre){
		Optional<Quadre> optionalQuadre = quadresDAO.findById(quadreID);
		if(optionalQuadre.isPresent()) {
			Quadre updateQuadre = optionalQuadre.get();
			updateQuadre.setNomautor(quadre.getNomautor());
			updateQuadre.setNomquadre(quadre.getNomquadre());
			updateQuadre.setPreu(quadre.getPreu());
			quadresDAO.save(updateQuadre);
			return ResponseEntity.ok(updateQuadre);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//veure una botiga en concret segons la seva id
	@RequestMapping(value="/botigues/{botigaID}")
	public ResponseEntity<Botiga> getBotigaById(@PathVariable("botigaID") int botigaID){
		Optional<Botiga> optionalBotiga = botiguesDAO.findById(botigaID);
		if(optionalBotiga.isPresent()) {
			return ResponseEntity.ok(optionalBotiga.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//veure un quadre en concret segons la seva id
	@RequestMapping(value="/botigues/{botigaID}/quadres/{quadreID}")
	public ResponseEntity<Quadre> getQuadreById(@PathVariable("quadreID") int quadreID){
		Optional<Quadre> optionalQuadre = quadresDAO.findById(quadreID);
		if(optionalQuadre.isPresent()) {
			return ResponseEntity.ok(optionalQuadre.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	
	//eliminar una botiga en concret segons la seva id
	@DeleteMapping(value="/botigues/{botigaID}")
	public ResponseEntity<Void> deleteBotiga(@PathVariable("botigaID") int botigaID){
		botiguesDAO.deleteById(botigaID);
		return ResponseEntity.ok(null);
	}
	
	//eliminar un quadre en concret segons la seva id
	@DeleteMapping(value="/botigues/{botigaID}/quadres/{quadreID}")
	public ResponseEntity<Void> deleteQuadre(@PathVariable("quadreID") int quadreID){
		quadresDAO.deleteById(quadreID);
		return ResponseEntity.ok(null);
	}
	
	//eliminar tots els quadres d'una botiga
	@DeleteMapping(value="/botigues/{botigaID}/quadres")
	public ResponseEntity<Void> deleteAllQuadresBybotigaid(@PathVariable("botigaID") int botigaID){
		quadresDAO.deleteAllBybotigaid(botigaID);
		return ResponseEntity.ok(null);
	}

}
