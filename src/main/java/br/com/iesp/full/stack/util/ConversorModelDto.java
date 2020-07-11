package br.com.iesp.full.stack.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.iesp.full.stack.dto.ClienteDto;
import br.com.iesp.full.stack.dto.ComentarioDto;
import br.com.iesp.full.stack.dto.EnderecoDto;
import br.com.iesp.full.stack.dto.ProdutoDto;
import br.com.iesp.full.stack.dto.ServicoDto;
import br.com.iesp.full.stack.dto.VendedorDto;
import br.com.iesp.full.stack.entidades.Cliente;
import br.com.iesp.full.stack.entidades.Comentario;
import br.com.iesp.full.stack.entidades.Endereco;
import br.com.iesp.full.stack.entidades.Produto;
import br.com.iesp.full.stack.entidades.Servico;
import br.com.iesp.full.stack.entidades.Vendedor;

@Component
public class ConversorModelDto {
	
	public ProdutoDto produtoParaDto(Produto produto) {
		ProdutoDto produtoDto = new ProdutoDto();
		produtoDto.setDescricao(produto.getDescricao());
		produtoDto.setValor(produto.getValor());
		produtoDto.setTipo(produto.getTipo());
		produtoDto.setData(produto.getData());
		produtoDto.setVendedorDto(vendedorParaDto(produto.getVendedor()));
		produtoDto.setQuantidade(produtoDto.getQuantidade());
		return produtoDto;
	}

	public VendedorDto vendedorParaDto(Vendedor vendedor) {
		VendedorDto vendedorDto = new VendedorDto();
		vendedorDto.setId(vendedor.getId());
		vendedorDto.setCpf(vendedor.getCpf());
		vendedorDto.setNome(vendedor.getNome());
		vendedorDto.setEmail(vendedor.getEmail());
		vendedorDto.setSobreNome(vendedor.getSobreNome());
		vendedorDto.setSituacao(vendedor.getSituacao());
		vendedorDto.setIndice(vendedor.getIndice());
		vendedorDto.setEnderecoDto(enderecoParaDto(vendedor.getEndereco()));
		return vendedorDto;
	}
	
	public EnderecoDto enderecoParaDto(Endereco endereco) {
		EnderecoDto enderecoDto = new EnderecoDto();
		enderecoDto.setCep(endereco.getCep());
		enderecoDto.setUf(endereco.getUf());
		enderecoDto.setCidade(endereco.getCidade());
		enderecoDto.setBairro(endereco.getBairro());
		enderecoDto.setLogradouro(endereco.getLogradouro());
		return enderecoDto;
	}

	public List<ProdutoDto> listaProdutoParalistaDto(List<Produto> lista) {
		List<ProdutoDto> listaDto = new ArrayList<>();
		lista.forEach(p -> listaDto.add(produtoParaDto(p)));
		return listaDto;
	}

	public ServicoDto ServicoParaDto(Servico one) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ServicoDto> listaServicoParaDto(List<Servico> findAll) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<VendedorDto> listaVendedorParaDto(List<Vendedor> findAll) {
		// TODO Auto-generated method stub
		return null;
	}

	public ComentarioDto comentarioParaDto(Comentario one) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ComentarioDto> listaComentarioParaDto(List<Comentario> findAll) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteDto clienteParaDto(Cliente one) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ClienteDto> listaClienteParaDto(List<Cliente> findAll) {
		// TODO Auto-generated method stub
		return null;
	}

}
