package br.com.iesp.full.stack.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.iesp.full.stack.entidades.Prestador;

@Repository
public interface IPrestadorRepositorio extends JpaRepository<Prestador, Long>, JpaSpecificationExecutor<Prestador> {

}
