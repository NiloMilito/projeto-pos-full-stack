package br.com.iesp.full.stack.especificacao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.iesp.full.stack.entidades.Prestador;

public class VendedorEspecificacao implements Specification<Prestador> {

	private static final long serialVersionUID = 2328432794915497781L;
	private Prestador filtro;		

	public VendedorEspecificacao(Prestador filtro) {
		super();
		this.filtro = filtro;
	}

	@Override
	public Predicate toPredicate(Root<Prestador> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
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
		
		if (filtro.getEndereco().getCep() != null) {
			predicate.getExpressions().add(criteriaBuilder.and(criteriaBuilder.equal(root.get("cep"), filtro.getEndereco().getCep())));
		}
		
		if (filtro.getEndereco().getUf() != null) {
			predicate.getExpressions().add(criteriaBuilder.and(criteriaBuilder.equal(root.get("uf"), filtro.getEndereco().getUf())));
		}		
		
		if (filtro.getEndereco().getCidade() != null) {
			predicate.getExpressions().add(criteriaBuilder.like(criteriaBuilder.upper(root.get("cidade")), "%"+ filtro.getEndereco().getCidade().toUpperCase() +"%"));
		}	
		

		if (filtro.getEndereco().getNumero() != 0) {
			predicate.getExpressions().add(criteriaBuilder.and(criteriaBuilder.equal(root.get("numero"), filtro.getEndereco().getNumero())));
		}
		
		if (filtro.getEndereco().getRua() != null) {
			predicate.getExpressions().add(criteriaBuilder.like(criteriaBuilder.upper(root.get("rua")), "%"+ filtro.getEndereco().getRua().toUpperCase() +"%"));
		}
		
		return predicate;
	}

}
