package br.com.iesp.full.stack.dto;

import java.util.Date;

import br.com.iesp.full.stack.enumeration.TipoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class AnuncioDto {
	
	private Long id;
	private String descricao;
	private Double valor;
	private TipoEnum tipo;
	private Date data;
	private ClienteDto clienteDto;
	private VendedorDto vendedorDto;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnuncioDto other = (AnuncioDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
