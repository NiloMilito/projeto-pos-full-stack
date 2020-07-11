package br.com.iesp.full.stack.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ServicoDto extends AnuncioDto {

	private double maoDeObra;	
	private double material; 
}