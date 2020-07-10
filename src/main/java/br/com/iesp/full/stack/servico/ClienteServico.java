package br.com.iesp.full.stack.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.full.stack.dto.ClienteDto;
import br.com.iesp.full.stack.entidades.Cliente;
import br.com.iesp.full.stack.especificacao.ClienteEspecificacao;
import br.com.iesp.full.stack.repositorio.IClienteRepositorio;

@Service
public class ClienteServico implements IGenericoCRUD<Cliente, Long> {
	
	@Autowired
	private IClienteRepositorio clienteRepositorio;

	@Override
	@Transactional
	public void salvar(Cliente entidade) {
		this.clienteRepositorio.save(entidade);
	}

	@Override
	@Transactional
	public void alterar(Cliente entidade) {
		this.clienteRepositorio.save(entidade);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.clienteRepositorio.deleteById(id);
	}

	@Override
	public Cliente buscar(Long id) {		
		return this.clienteRepositorio.getOne(id);
	}

	@Override
	public List<Cliente> listar() {
		return this.clienteRepositorio.findAll();
	}

	public List<Cliente> listar(ClienteDto filtro) {
		ClienteEspecificacao pageable = new ClienteEspecificacao(filtro);
		return this.clienteRepositorio.findAll(pageable);
	}

}
