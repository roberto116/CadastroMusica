package br.senac.tads.dsw.exercicio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.senac.tads.dsw.exercicio.dto.RequisicaoNovaMusica;
import br.senac.tads.dsw.exercicio.model.Musica;
import br.senac.tads.dsw.exercicio.repository.MusicaRepository;

@org.springframework.stereotype.Controller


public class MusicaController {
	
	@Autowired
	private MusicaRepository musicaRepository;
	

	@GetMapping("musicas")
	public ModelAndView	index() {
		List<Musica> musica = this.musicaRepository.findAll();
		ModelAndView mv = new ModelAndView("musicas/musicas");
		mv.addObject("musicas", musica);
		
		return mv;
	}
	
	@GetMapping("musicas/new")
	public ModelAndView novo(RequisicaoNovaMusica requisicao) {
		ModelAndView mv = new ModelAndView("musicas/new");
		
		return mv;
	}
	
	@PostMapping("/musicas")
	public ModelAndView create(@Valid RequisicaoNovaMusica requisicao, BindingResult bindingResult) {
		System.out.println(requisicao);
		if(bindingResult.hasErrors()) {
			System.out.println("POSSUI ERROS NA REQUISIÇÃO");
			
			ModelAndView mv = new ModelAndView("musicas/new");
			return mv; 
					
		}else {
		Musica musica = requisicao.toMusica();
		this.musicaRepository.save(musica);
		
		return new ModelAndView("redirect:/musicas");
	}
	
	
	}
}
