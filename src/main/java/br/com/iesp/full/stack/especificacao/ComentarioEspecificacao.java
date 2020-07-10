package br.com.iesp.full.stack.especificacao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.iesp.full.stack.dto.ComentarioDto;
import br.com.iesp.full.stack.entidades.Comentario;

public class ComentarioEspecificacao implements Specification<Comentario> {

	private static final long serialVersionUID = 1L;
	private ComentarioDto filtro;
		
	public ComentarioEspecificacao(ComentarioDto filtro) {
		super();
		this.filtro = filtro;
	}

	@Override
	public Predicate toPredicate(Root<Comentario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate predicate = criteriaBuilder.disjunction();

		if (filtro.getDescricao() != null) {
			predicate.getExpressions().add(criteriaBuilder.like(criteriaBuilder.upper(root.get("descricao")), "%"+ filtro.getDescricao().toUpperCase() +"%"));
		}

		if (filtro.getData() != null) {
			predicate.getExpressions().add(criteriaBuilder.and(criteriaBuilder.equal(root.get("data"), filtro.getData())));
		}
		
		return predicate;
	}

}
