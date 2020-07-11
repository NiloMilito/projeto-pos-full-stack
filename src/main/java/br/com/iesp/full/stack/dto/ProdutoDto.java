package br.com.iesp.full.stack.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ProdutoDto extends AnuncioDto {
	
	private Integer quantidade;	

}
