package br.senac.tads.dsw.exercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.tads.dsw.exercicio.model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, String> {

	
}
