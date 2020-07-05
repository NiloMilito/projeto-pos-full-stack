package br.com.iesp.full.stack.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iesp.full.stack.entidades.Comentario;

@Repository
public interface IComentrioRepositorio extends JpaRepository<Comentario, Long>{

}
