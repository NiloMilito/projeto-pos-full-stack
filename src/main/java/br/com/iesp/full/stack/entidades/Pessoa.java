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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@MappedSuperclass
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
	
	@Column(name="telefone", unique=true, length = 13)
	@NotEmpty(message="Telefone é obrigatório")
	private String telefone;
	
	@Column(name="email", length = 200)
	@Email(message="Endereço de e-mail em um formato inválido.")
	private String email;
		
	@Embedded
	private Endereco endereco;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
