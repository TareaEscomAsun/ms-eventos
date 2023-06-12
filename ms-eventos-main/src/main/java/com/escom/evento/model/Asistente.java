package com.escom.evento.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Asistente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asistente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idasistente")
	private Long idAsistente;
	
	@NotBlank(message="El nombre del asistente es obligatorio")
	@Size(min = 4, max = 50, message = "El tamaño tiene que estar entre 4 y 50")
	@Column(name = "nombreasistente", length = 50, nullable = false)
	private String nombreAsistente;
	
	@NotBlank(message="El apellido paterno del asistente es obligatorio")
	@Size(min = 4, max = 50, message = "El tamaño tiene que estar entre 4 y 50")
	@Column(name = "paternoAsistente", length = 50, nullable = false)
	private String paternoAsistente;
	
	@NotBlank(message="El apellido materno del asistente es obligatorio")
	@Size(min = 4, max = 50, message = "El tamaño tiene que estar entre 4 y 50")
	@Column(name = "maternoasistente", length = 50, nullable = false)
	private String maternoAsistente;
	
	@NotBlank(message="El correo electronico del asistente es obligatorio")
	@Size(min = 4, max = 150, message = "El tamaño tiene que estar entre 4 y 150")
	@Column(name = "emailasistente", length = 150, nullable = false)
	private String emailAsistente;
	
	@JsonIgnoreProperties(value = {"listaAsistentes", "hibernateLazyInitializer", "handler"},  allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idevento", referencedColumnName = "idevento")
	private Evento evento;
	
}
