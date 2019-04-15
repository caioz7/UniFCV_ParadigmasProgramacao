package br.edu.unifcv.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifcv.model.Aluno;
import br.edu.unifcv.service.map.AlunoMapService;

@RestController
@RequestMapping(path = "/aluno")
public class AlunoController {
	@Autowired
	AlunoMapService alunoMapService;

	@RequestMapping
	public Set<Aluno> getAll() {
		return alunoMapService.findAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> getAluno(@PathVariable Long id) {
		return ResponseEntity.ok(alunoMapService.findById(id)); 
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno aluno) {
		return ResponseEntity.ok(alunoMapService.saveOrUpdate(aluno));
	}


	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public Aluno updateAluno(@RequestBody Aluno aluno) {
		return alunoMapService.saveOrUpdate(aluno);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteAluno(@PathVariable Long id) {
		alunoMapService.deleteById(id);

	}

	@RequestMapping(path = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> getByName(@PathVariable String nome) {
		try {
			Aluno p = alunoMapService.findByNome(nome);
			return ResponseEntity.ok(p);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(path = "/sobrenome/{sobrenome}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> getBySobrenome(@PathVariable String sobrenome) {
		try {
			Aluno p = alunoMapService.findBySobreNome(sobrenome);
			return ResponseEntity.ok(p);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(path = "/registros")
	public Long count() {
		return alunoMapService.count();
	}

}
