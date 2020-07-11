package br.com.iesp.full.stack.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.full.stack.dto.ClienteDto;
import br.com.iesp.full.stack.entidades.Cliente;
import br.com.iesp.full.stack.especificacao.ClienteEspecificacao;
import br.com.iesp.full.stack.repositorio.IClienteRepositorio;
import br.com.iesp.full.stack.util.ConversorDtoModel;
import br.com.iesp.full.stack.util.ConversorModelDto;

@Service
public class ClienteServico implements IGenericoCRUD<ClienteDto, Long> {
	
	@Autowired
	private IClienteRepositorio clienteRepositorio;
	@Autowired
	private ConversorDtoModel conversorDtoModel;
	@Autowired
	private ConversorModelDto ConversorModelDto;

	@Override
	@Transactional
	public void salvar(ClienteDto entidade) {
		Cliente cliente = this.conversorDtoModel.dtoParaCliente(entidade);
		this.clienteRepositorio.save(cliente);
	}

	@Override
	@Transactional
	public void alterar(ClienteDto entidade) {
		Cliente cliente = this.conversorDtoModel.dtoParaCliente(entidade);
		this.clienteRepositorio.save(cliente);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.clienteRepositorio.deleteById(id);
	}

	@Override
	public ClienteDto buscar(Long id) {		
		ClienteDto clienteDto = this.ConversorModelDto.clienteParaDto(this.clienteRepositorio.getOne(id));
		return clienteDto;
	}

	@Override
	public List<ClienteDto> listar() {
		List<ClienteDto> listaDto = this.ConversorModelDto.listaClienteParaDto(this.clienteRepositorio.findAll());
		return listaDto;
	}

	@Override
	public List<ClienteDto> listar(ClienteDto filtro) {
		ClienteEspecificacao pageable = new ClienteEspecificacao(filtro);
		List<ClienteDto> listaDto = this.ConversorModelDto.listaClienteParaDto(this.clienteRepositorio.findAll(pageable));
		return listaDto;
	}

}
