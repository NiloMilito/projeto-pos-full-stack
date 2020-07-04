package br.com.iesp.full.stack.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor extends Pessoa {
	
	@Column(name="situacao", length = 30)
	private String situacao;
	
	@Column(name="indice", length = 10)
	private Integer indice;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendedor")
	private List<Servico> servicos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendedor")
	private List<Produto> produtos;

}
