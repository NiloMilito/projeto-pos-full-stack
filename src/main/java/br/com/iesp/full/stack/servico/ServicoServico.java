package br.com.iesp.full.stack.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.full.stack.dto.ServicoDto;
import br.com.iesp.full.stack.entidades.Servico;
import br.com.iesp.full.stack.especificacao.ServicoEspecificacao;
import br.com.iesp.full.stack.repositorio.IServicoRepositorio;
import br.com.iesp.full.stack.util.ConversorDtoModel;
import br.com.iesp.full.stack.util.ConversorModelDto;

@Service
public class ServicoServico implements IGenericoCRUD<ServicoDto, Long> {

	@Autowired
	private ConversorDtoModel conversorDtoModel;
	@Autowired
	private ConversorModelDto ConversorModelDto;
	@Autowired
	private IServicoRepositorio servicoRepositorio;

	@Override
	@Transactional
	public void salvar(ServicoDto objectDto) {
		Servico servico = this.conversorDtoModel.dtoParaServico(objectDto);
		this.servicoRepositorio.save(servico);
	}

	@Override
	@Transactional
	public void alterar(ServicoDto objectDto) {
		Servico servico = this.conversorDtoModel.dtoParaServico(objectDto);
		this.servicoRepositorio.save(servico);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.servicoRepositorio.deleteById(id);
	}

	@Override
	public ServicoDto buscar(Long id) {
		ServicoDto servicoDto = this.ConversorModelDto.ServicoParaDto(this.servicoRepositorio.getOne(id));
		return servicoDto;
	}

	@Override
	public List<ServicoDto> listar(ServicoDto filtro) {
		ServicoEspecificacao pageable = new ServicoEspecificacao(this.conversorDtoModel.dtoParaServico(filtro));
		List<ServicoDto> listaDto = this.ConversorModelDto.listaServicoParaDto(this.servicoRepositorio.findAll(pageable));
		return listaDto;
	}

	@Override
	public List<ServicoDto> listar() {
		List<ServicoDto> listaDto = this.ConversorModelDto.listaServicoParaDto(this.servicoRepositorio.findAll());
		return listaDto;
	}

}
