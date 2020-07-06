package br.com.iesp.full.stack.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.iesp.full.stack.entidades.Servico;

@Repository
public interface IServicoRepositorio extends JpaRepository<Servico, Long>, JpaSpecificationExecutor<Servico> {

}
