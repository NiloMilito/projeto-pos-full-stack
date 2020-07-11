package br.com.iesp.full.stack.util;

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
public class ConversorDtoModel {
	
	public Produto dtoToProduto(ProdutoDto produtoDto) {
		Produto produto = new Produto();
		produto.setDescricao(produtoDto.getDescricao());
		produto.setValor(produtoDto.getValor());
		produto.setTipo(produtoDto.getTipo());
		produto.setData(produtoDto.getData());
		produto.setVendedor(dtoParaVendedor(produtoDto.getVendedorDto()));
		produto.setQuantidade(produtoDto.getQuantidade());
		return produto;
	}

	public Vendedor dtoParaVendedor(VendedorDto vendedorDto) {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(vendedorDto.getId());
		vendedor.setCpf(vendedorDto.getCpf());
		vendedor.setNome(vendedorDto.getNome());
		vendedor.setEmail(vendedorDto.getEmail());
		vendedor.setSobreNome(vendedorDto.getSobreNome());
		vendedor.setSituacao(vendedorDto.getSituacao());
		vendedor.setIndice(vendedorDto.getIndice());
		vendedor.setEndereco(dtoParaEndereco(vendedorDto.getEnderecoDto()));
		return vendedor;
	}
	
	public Endereco dtoParaEndereco(EnderecoDto enderecoDto) {
		Endereco endereco = new Endereco();
		endereco.setCep(enderecoDto.getCep());
		endereco.setUf(enderecoDto.getUf());
		endereco.setCidade(enderecoDto.getCidade());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		return endereco;
	}

	public Servico dtoParaServico(ServicoDto objectDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comentario dtoParaComentario(ComentarioDto entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente dtoParaCliente(ClienteDto entidade) {
		// TODO Auto-generated method stub
		return null;
	}
}
