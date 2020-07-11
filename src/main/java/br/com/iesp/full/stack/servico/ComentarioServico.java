package br.com.iesp.full.stack.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.full.stack.dto.ComentarioDto;
import br.com.iesp.full.stack.entidades.Comentario;
import br.com.iesp.full.stack.especificacao.ComentarioEspecificacao;
import br.com.iesp.full.stack.repositorio.IComentrioRepositorio;
import br.com.iesp.full.stack.util.ConversorDtoModel;
import br.com.iesp.full.stack.util.ConversorModelDto;

@Service
public class ComentarioServico implements IGenericoCRUD<ComentarioDto, Long> {

	@Autowired
	private IComentrioRepositorio comentarioRepositorio;
	@Autowired
	private ConversorDtoModel conversorDtoModel;
	@Autowired
	private ConversorModelDto ConversorModelDto;

	@Override
	@Transactional
	public void salvar(ComentarioDto entidade) {
		Comentario comentario = conversorDtoModel.dtoParaComentario(entidade);
		this.comentarioRepositorio.save(comentario);
	}

	@Override
	@Transactional
	public void alterar(ComentarioDto entidade) {
		Comentario comentario = conversorDtoModel.dtoParaComentario(entidade);
		this.comentarioRepositorio.save(comentario);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.comentarioRepositorio.deleteById(id);
	}

	@Override
	public ComentarioDto buscar(Long id) {
		ComentarioDto comentarioDto = this.ConversorModelDto.comentarioParaDto(this.comentarioRepositorio.getOne(id));
		return comentarioDto;
	}

	@Override
	public List<ComentarioDto> listar() {
		List<ComentarioDto> listaDto = this.ConversorModelDto.listaComentarioParaDto(this.comentarioRepositorio.findAll());
		return listaDto;
	}
	@Override
	public List<ComentarioDto> listar(ComentarioDto filtro) {		
		ComentarioEspecificacao pageable = new ComentarioEspecificacao(filtro);
		List<ComentarioDto> listaDto = this.ConversorModelDto.listaComentarioParaDto(this.comentarioRepositorio.findAll(pageable));
		return listaDto;
	}

}
