package br.com.iesp.full.stack.dto;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class VendedorDto extends PessoaDto {

	private String situacao;
	private Integer indice;
	private List<ServicoDto> servicosDto;
	private List<ProdutoDto> produtosDto;
}
