package br.com.iesp.full.stack.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.full.stack.dto.ProdutoDto;
import br.com.iesp.full.stack.entidades.Produto;
import br.com.iesp.full.stack.especificacao.ProdutoEspecificacao;
import br.com.iesp.full.stack.repositorio.IProdutoRepositorio;
import br.com.iesp.full.stack.util.ConversorDtoModel;
import br.com.iesp.full.stack.util.ConversorModelDto;

@Service
public class ProdutoServico implements IGenericoCRUD<ProdutoDto, Long> {
	
	@Autowired
	private IProdutoRepositorio produtoRepositorio;	
	@Autowired
	private ConversorDtoModel conversorDtoModel;
	@Autowired
	private ConversorModelDto ConversorModelDto;

	@Override
	@Transactional
	public void salvar(ProdutoDto objectDto) {
		Produto produto = this.conversorDtoModel.dtoToProduto(objectDto);
		this.produtoRepositorio.save(produto);
	}

	@Override
	@Transactional
	public void alterar(ProdutoDto objectDto) {
		Produto produto = this.conversorDtoModel.dtoToProduto(objectDto);
		this.produtoRepositorio.save(produto);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.produtoRepositorio.deleteById(id);
	}

	@Override
	public ProdutoDto buscar(Long id) {
		ProdutoDto produtoDto = ConversorModelDto.produtoParaDto(this.produtoRepositorio.getOne(id));
		return produtoDto;
	}

	@Override
	public List<ProdutoDto> listar() {	
		List<ProdutoDto> listaDto = ConversorModelDto.listaProdutoParalistaDto(this.produtoRepositorio.findAll());
		return listaDto;
	}
	
	@Override
	public List<ProdutoDto> listar(ProdutoDto filtro) {	
		ProdutoEspecificacao pageable = new ProdutoEspecificacao(conversorDtoModel.dtoToProduto(filtro));
		List<ProdutoDto> listaDto = ConversorModelDto.listaProdutoParalistaDto(this.produtoRepositorio.findAll(pageable));
		return listaDto;
	}

}
