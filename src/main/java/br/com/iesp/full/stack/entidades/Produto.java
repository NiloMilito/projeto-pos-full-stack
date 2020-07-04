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
public class Produto extends Anuncio {
	
	@Column(name="quantidade")
	private Integer quantidade;
	
	@ManyToOne
	private Vendedor vendedor;
	
	@ManyToOne
	private Cliente cliente;

}
