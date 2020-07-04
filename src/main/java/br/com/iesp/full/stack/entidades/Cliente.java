package br.com.iesp.full.stack.entidades;

import java.util.ArrayList;
import java.util.List;

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
public class Cliente extends Pessoa {
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Servico> servicos = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Produto> produtos = new ArrayList<>();;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Comentario> comentarios = new ArrayList<>();;

}
