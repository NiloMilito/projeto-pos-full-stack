package br.com.iesp.full.stack.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.full.stack.dto.VendedorDto;
import br.com.iesp.full.stack.entidades.Vendedor;
import br.com.iesp.full.stack.especificacao.VendedorEspecificacao;
import br.com.iesp.full.stack.repositorio.IVendedorRepositorio;

@Service
public class VendedorServico implements IGenericoCRUD<Vendedor, Long>{
	
	@Autowired
	private IVendedorRepositorio vendedorRepository;

	@Override
	@Transactional
	public void salvar(Vendedor entidade) {
		this.vendedorRepository.save(entidade);
	}

	@Override
	@Transactional
	public void alterar(Vendedor entidade) {
		this.vendedorRepository.save(entidade);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.vendedorRepository.deleteById(id);
	}

	@Override
	public Vendedor buscar(Long id) {		
		return this.vendedorRepository.getOne(id);
	}

	public List<Vendedor> listar(VendedorDto filtro) {
		VendedorEspecificacao pageable = new VendedorEspecificacao(filtro);
		return this.vendedorRepository.findAll(pageable);
	}

	@Override
	public List<Vendedor> listar() {		
		return this.vendedorRepository.findAll();
	}

}
