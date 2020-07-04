package br.com.iesp.full.stack.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import br.com.iesp.full.stack.enumeration.TipoEnum;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class Anuncio {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="descricao", length = 200)
	@NotEmpty(message="Descrição é obrigatório")
	private String descricao;
	
	@Column(name="valor")
	private Double valor;
	
	@Column(name="tipo", length = 30)
	@Enumerated(EnumType.ORDINAL)
	private TipoEnum tipo;
	
	@Column(name="data")
	@Temporal(TemporalType.DATE)
	private Date data;

}
