package br.edu.unifcv.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.unifcv.model.Aluno;
import br.edu.unifcv.model.Endereco;
import br.edu.unifcv.model.Professor;
import br.edu.unifcv.model.Telefone;
import br.edu.unifcv.service.map.AlunoMapService;
import br.edu.unifcv.service.map.ProfessorMapService;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private ProfessorMapService professorMapService;
	
	@Autowired
	private AlunoMapService alunoMapService;

	@Override
	public void run(String... args) throws Exception {
		saveData();
	}

	private void saveData() {
		
		Professor p1 = new Professor();
		
		Aluno a1 = new Aluno();
		
		Endereco e1 = new Endereco();
		e1.setLogradouro("Rua xpto");
		e1.setBairro("Centro");
		e1.setCidade("Maringa");
		e1.setEstado("PR");
		e1.setNumero("123");
		
		
		
	    List<Endereco> lista = new ArrayList<>();
	    lista.add(e1);
	    
	    Telefone t1 = new Telefone();
	    t1.setContato("Contato XXXX");
	    t1.setTelefone("44999995555");
	    
	    Telefone t2 = new Telefone();
	    t2.setContato("Urbano Ddsdasdxc");
	    t2.setTelefone("+551133334444");

		p1.setNome("André");
		p1.setSobreNome("Oliveira");
		p1.setIdade(34);
		p1.setPeriodo("Noturno");
		p1.setFaculdade("UniFCV");
		p1.setTurma("5° Semestre");
		p1.setAno("2019");
		p1.setEndereco(lista);
		p1.setTelefone(t1);
		
		a1.setNome("Caio Cesar");
		a1.setSobreNome("Adsacsdcvs");
		a1.setIdade(21);
		a1.setPeriodo("Matutino");
		a1.setFaculdade("UniFCV");
		a1.setTurma("12º semestre");
		a1.setAno("2019");
		a1.setEndereco(lista);
		a1.setTelefone(t2);

		this.professorMapService.saveOrUpdate(p1);
		
		this.alunoMapService.saveOrUpdate(a1);

	}

}
