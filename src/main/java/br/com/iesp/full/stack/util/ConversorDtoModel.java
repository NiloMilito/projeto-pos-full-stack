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

	public Servico dtoParaServico(ServicoDto servicoDto) {
		Servico servico = new Servico();
		servico.setDescricao(servicoDto.getDescricao());
		servico.setValor(servicoDto.getValor());
		servico.setTipo(servicoDto.getTipo());
		servico.setData(servicoDto.getData());
		servico.setVendedor(dtoParaVendedor(servicoDto.getVendedorDto()));
		servico.setMaoDeObra(servicoDto.getMaoDeObra());
		servico.setMaterial(servicoDto.getMaterial());
		return servico;
	}

	public Comentario dtoParaComentario(ComentarioDto comentarioDto) {
		Comentario comentario = new Comentario();
		comentario.setId(comentarioDto.getId());
		comentario.setDescricao(comentarioDto.getDescricao());
		comentario.setData(comentario.getData());
		comentario.setCliente(dtoParaCliente(comentarioDto.getClienteDto()));
		return comentario;
	}

	public Cliente dtoParaCliente(ClienteDto clienteDto) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteDto.getId());
		cliente.setCpf(clienteDto.getCpf());
		cliente.setNome(clienteDto.getNome());
		cliente.setSobreNome(clienteDto.getSobreNome());
		cliente.setEmail(clienteDto.getEmail());
		cliente.setEndereco(dtoParaEndereco(clienteDto.getEnderecoDto()));
		return cliente;
	}
}
