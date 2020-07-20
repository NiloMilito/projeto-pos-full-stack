package br.com.iesp.full.stack.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Endereco {
	
	@Column(name="cep", length = 9)
	@NotEmpty(message="CEP é obrigatório")
	private String cep;
	
	@Column(name="rua", length = 200)
	@NotEmpty(message="Rua é obrigatório")
	private String rua;
	
	@Column(name="numero")
	@NotEmpty(message="Número é obrigatório")
	private int numero;
	
	@Column(name="bairro", length = 200)
	@NotEmpty(message="Bairro é obrigatório")
	private String bairro;
	
	@Column(name="cidade", length = 200)
	@NotEmpty(message="Cidade é obrigatório")
	private String cidade;
	
	@Column(name="uf", length = 3)
	@NotEmpty(message="UF é obrigatório")
	private String uf;		
	
}
