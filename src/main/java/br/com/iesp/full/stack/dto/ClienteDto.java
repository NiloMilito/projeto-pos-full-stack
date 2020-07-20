package br.com.iesp.full.stack.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDto extends PessoaDto {
	
	private List<ServicoDto> servicos = new ArrayList<>();	
	private List<ComentarioDto> comentarios = new ArrayList<>();

}
