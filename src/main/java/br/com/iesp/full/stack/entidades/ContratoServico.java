package br.com.iesp.full.stack.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="contrato_servico")
public class ContratoServico implements Serializable {
	
	private static final long serialVersionUID = -7198551237592959734L;
	@OneToOne
	private Cliente cliente;
	@OneToOne
	private Prestador prestador;
	@Column(name="valor")
	private BigDecimal valor;
	
}
