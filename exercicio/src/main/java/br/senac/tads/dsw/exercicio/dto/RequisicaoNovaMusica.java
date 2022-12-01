package br.senac.tads.dsw.exercicio.dto;

import java.io.Serializable;
import java.time.LocalDate;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.senac.tads.dsw.exercicio.model.Musica;


public class RequisicaoNovaMusica implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@NotBlank(message = "Por favor insira seu titulo")
    @Size(min = 1, max = 100)
	private String titulo;
    
    
    @NotBlank(message = "Por favor insira seu artista")
    @Size(min = 6, max = 100)
   
	private String artista;
    
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    @Past
	private LocalDate lanc;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public LocalDate getLanc() {
		return lanc;
	}
	public void setLanc(LocalDate lanc) {
		this.lanc = lanc;
	}
	
	public Musica toMusica() {
		Musica musica = new Musica();
		musica.setTitulo(this.titulo);
		musica.setArtista(this.artista);
		musica.setLanc(this.lanc);
		
		return musica;
	}
	
	@Override
	public String toString() {
		return "Musica{" +
				"titulo=" + titulo +
				", artista=" + artista +
				", lanc=" + lanc + 
				'}';
	}
}
