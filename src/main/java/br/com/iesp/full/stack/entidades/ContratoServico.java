package br.com.iesp.full.stack.entidades;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratoServico {
	
	private Cliente cliente;
	
	private Prestador prestador;
	
	private BigDecimal valor;
	
}
