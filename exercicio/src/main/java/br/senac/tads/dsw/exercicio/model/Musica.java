package br.senac.tads.dsw.exercicio.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Musica {
	

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	@NotBlank(message = "Por favor insira seu titulo")
    @Size(max = 100)
	private String titulo;
    
    
    @NotBlank
    @Size(max = 100)
   
	private String artista;
    
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    @Past
	private LocalDate lanc;
	
	public Musica() {
		
	}
	
	public Musica(String titulo, String artista, LocalDate lanc) {
		this.titulo = titulo;
		this.artista = artista;
		this.lanc = lanc;
	}

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
	
	@Override
	public String toString() {
		return "Musica{" +
				"titulo=" + titulo +
				", artista=" + artista +
				", lanc=" + lanc + '}';
	}
	
	
}
