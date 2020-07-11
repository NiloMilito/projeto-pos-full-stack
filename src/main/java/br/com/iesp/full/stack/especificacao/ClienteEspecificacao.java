package br.com.iesp.full.stack.especificacao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.iesp.full.stack.dto.ClienteDto;
import br.com.iesp.full.stack.entidades.Cliente;

public class ClienteEspecificacao implements Specification<Cliente> {

	private static final long serialVersionUID = 198073256922776203L;
	private ClienteDto filtro;
		
	public ClienteEspecificacao(ClienteDto filtro) {
		super();
		this.filtro = filtro;
	}

	@Override
	public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate predicate = criteriaBuilder.disjunction();

		if (filtro.getNome() != null) {
			predicate.getExpressions().add(criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")), "%"+ filtro.getNome().toUpperCase() +"%"));
		}

		if (filtro.getEmail() != null) {
			predicate.getExpressions().add(criteriaBuilder.and(criteriaBuilder.equal(root.get("email"), filtro.getEmail())));
		}
		
		if (filtro.getCpf() != null) {
			predicate.getExpressions().add(criteriaBuilder.and(criteriaBuilder.equal(root.get("cpf"), filtro.getCpf())));
		}
		
		if (filtro.getSobreNome() != null) {
			predicate.getExpressions().add(criteriaBuilder.like(criteriaBuilder.upper(root.get("sobreNome")), "%"+ filtro.getSobreNome().toUpperCase() +"%"));
		}
		
		if (filtro.getEnderecoDto().getCep() != null) {
			predicate.getExpressions().add(criteriaBuilder.and(criteriaBuilder.equal(root.get("cep"), filtro.getEnderecoDto().getCep())));
		}
		
		if (filtro.getEnderecoDto().getUf() != null) {
			predicate.getExpressions().add(criteriaBuilder.and(criteriaBuilder.equal(root.get("uf"), filtro.getEnderecoDto().getUf())));
		}		
		
		if (filtro.getEnderecoDto().getCidade() != null) {
			predicate.getExpressions().add(criteriaBuilder.like(criteriaBuilder.upper(root.get("cidade")), "%"+ filtro.getEnderecoDto().getCidade().toUpperCase() +"%"));
		}	
		
		if (filtro.getEnderecoDto().getLogradouro() != null) {
			predicate.getExpressions().add(criteriaBuilder.like(criteriaBuilder.upper(root.get("logradouro")), "%"+ filtro.getEnderecoDto().getLogradouro().toUpperCase() +"%"));
		}
		
		if (filtro.getEnderecoDto().getBairro() != null) {
			predicate.getExpressions().add(criteriaBuilder.like(criteriaBuilder.upper(root.get("bairro")), "%"+ filtro.getEnderecoDto().getBairro().toUpperCase() +"%"));
		}
				
		return predicate;
	}

}
