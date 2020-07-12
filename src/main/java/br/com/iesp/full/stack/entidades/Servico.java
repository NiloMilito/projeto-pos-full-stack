package br.com.iesp.full.stack.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Servico extends Anuncio {
	
	@Column(name="mao_de_obra")
	private BigDecimal maoDeObra;
	
	@Column(name="material")
	private BigDecimal material; 
	
}
