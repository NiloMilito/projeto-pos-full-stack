package br.com.iesp.full.stack.entidades;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servico extends Anuncio {
	
	@Column(name="mao_de_obra")
	private double maoDeObra;
	
	@Column(name="material")
	private double material; 
	
	@ManyToOne
	private Vendedor vendedor;
	
	@ManyToOne
	private Cliente cliente;

}
