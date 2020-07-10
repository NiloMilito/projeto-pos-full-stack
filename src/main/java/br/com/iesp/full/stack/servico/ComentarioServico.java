package br.com.iesp.full.stack.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.full.stack.dto.ComentarioDto;
import br.com.iesp.full.stack.entidades.Comentario;
import br.com.iesp.full.stack.especificacao.ComentarioEspecificacao;
import br.com.iesp.full.stack.repositorio.IComentrioRepositorio;

@Service
public class ComentarioServico implements IGenericoCRUD<Comentario, Long> {

	@Autowired
	private IComentrioRepositorio comentarioRepositorio;

	@Override
	@Transactional
	public void salvar(Comentario entidade) {
		this.comentarioRepositorio.save(entidade);
	}

	@Override
	@Transactional
	public void alterar(Comentario entidade) {
		this.comentarioRepositorio.save(entidade);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.comentarioRepositorio.deleteById(id);
	}

	@Override
	public Comentario buscar(Long id) {
		return this.comentarioRepositorio.getOne(id);
	}

	@Override
	public List<Comentario> listar() {
		return this.comentarioRepositorio.findAll();
	}

	public List<Comentario> listar(ComentarioDto filtro) {		
		ComentarioEspecificacao pageable = new ComentarioEspecificacao(filtro);
		return this.comentarioRepositorio.findAll(pageable);
	}

}
