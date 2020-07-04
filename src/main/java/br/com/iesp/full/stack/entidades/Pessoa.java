package br.com.iesp.full.stack.entidades;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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
public abstract class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", length = 200)
	@NotEmpty(message="Nome é obrigatório")
	private String nome;
	
	@Column(name="sobre_nome", length = 200)
	@NotEmpty(message="Sobre nome é obrigatório")
	private String sobreNome;
	
	@Column(name="cpf", unique=true, length = 14)
	@NotEmpty(message="CPF é obrigatório")
	private String cpf;
	
	@Column(name="email", length = 200)
	@Email(message="Endereço de e-mail em um formato inválido.")
	private String email;
		
	@Embedded
	private Endereco endereco;
	
}
