package br.senac.tads.dsw.exercicio.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class MusicaServiceMock implements MusicaService {
	
	private Map<String, Musica> mapMusica;
	
	public MusicaServiceMock() {
		mapMusica = new ConcurrentHashMap<>();
	}
	
	@Override
	public List<Musica> findAll(){
		return new ArrayList<>(mapMusica.values());
	}
	
	public Musica findByMusica(String musica) {
		return mapMusica.get(musica);
	}
}
