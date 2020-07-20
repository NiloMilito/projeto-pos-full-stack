package br.com.iesp.full.stack.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="prestador")
public class Prestador extends Pessoa {	

	private static final long serialVersionUID = 1545455920456712964L;

	@Column(name="situacao", length = 30)
	private String situacao;
	
	@Column(name="indice", length = 10)
	private Integer indice;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prestador")
	private List<Servico> servicos;

}
