package br.com.iesp.full.stack.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.full.stack.entidades.Produto;
import br.com.iesp.full.stack.repositorio.IProdutoRepositorio;

@Service
public class ProdutoServico implements IGenericoCRUD<Produto, Long> {
	
	@Autowired
	private IProdutoRepositorio produtoRepositorio;

	@Override
	@Transactional
	public void salvar(Produto entidade) {
		this.produtoRepositorio.save(entidade);
	}

	@Override
	@Transactional
	public void alterar(Produto entidade) {
		this.produtoRepositorio.save(entidade);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.produtoRepositorio.deleteById(id);
	}

	@Override
	public Produto buscar(Long id) {
		return this.produtoRepositorio.getOne(id);
	}

	@Override
	public List<Produto> listar(Produto filtro) {		
		return null;
	}

	@Override
	public List<Produto> listar() {		
		return this.produtoRepositorio.findAll();
	}

}
