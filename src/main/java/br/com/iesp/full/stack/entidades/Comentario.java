package br.com.iesp.full.stack.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_comentario")
public class Comentario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3328880862485144742L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="descricao", length = 200)
	@NotEmpty(message="Descrição é obrigatório")
	private String descricao;
	
	@Column(name="data")
	private LocalDateTime data;
	
	@ManyToOne
	private Cliente cliente;
}
