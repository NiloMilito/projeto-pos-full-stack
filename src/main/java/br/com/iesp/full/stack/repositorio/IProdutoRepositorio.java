package br.com.iesp.full.stack.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iesp.full.stack.entidades.Produto;

@Repository
public interface IProdutoRepositorio extends JpaRepository<Produto, Long> {

}
