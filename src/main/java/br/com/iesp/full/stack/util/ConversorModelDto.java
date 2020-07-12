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
		vendedorDto.setTelefone(vendedor.getTelefone());
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

	public ServicoDto servicoParaDto(Servico servico) {
		ServicoDto servicoDto = new ServicoDto();
		servicoDto.setId(servico.getId());
		servicoDto.setDescricao(servico.getDescricao());
		servicoDto.setValor(servico.getValor());
		servicoDto.setTipo(servico.getTipo());
		servicoDto.setData(servico.getData());
		servicoDto.setVendedorDto(vendedorParaDto(servico.getVendedor()));
		servicoDto.setMaoDeObra(servico.getMaoDeObra());
		servicoDto.setMaterial(servico.getMaterial());		
		return servicoDto;
	}

	public List<ServicoDto> listaServicoParaDto(List<Servico> lista) {
		List<ServicoDto> listaDto = new ArrayList<>();
		lista.forEach(l -> listaDto.add(servicoParaDto(l)));
		return listaDto;
	}

	public List<VendedorDto> listaVendedorParaDto(List<Vendedor> lista) {
		List<VendedorDto> listaDto = new ArrayList<>();
		lista.forEach(l -> listaDto.add(vendedorParaDto(l)));
		return listaDto;
	}

	public ComentarioDto comentarioParaDto(Comentario comentario) {
		ComentarioDto comentarioDto = new ComentarioDto();
		comentarioDto.setId(comentario.getId());
		comentarioDto.setDescricao(comentario.getDescricao());
		comentarioDto.setData(comentario.getData());
		comentarioDto.setClienteDto(clienteParaDto(comentario.getCliente()));
		return comentarioDto;
	}

	public List<ComentarioDto> listaComentarioParaDto(List<Comentario> lista) {
		List<ComentarioDto> listaDto = new ArrayList<>();
		lista.forEach(l -> listaDto.add(comentarioParaDto(l)));
		return listaDto;
	}

	public ClienteDto clienteParaDto(Cliente cliente) {
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setId(cliente.getId());
		clienteDto.setCpf(cliente.getCpf());
		clienteDto.setNome(cliente.getNome());
		clienteDto.setEmail(cliente.getEmail());
		clienteDto.setSobreNome(cliente.getSobreNome());
		clienteDto.setTelefone(cliente.getTelefone());
		clienteDto.setEnderecoDto(enderecoParaDto(cliente.getEndereco()));		
		return clienteDto;
	}

	public List<ClienteDto> listaClienteParaDto(List<Cliente> lista) {
		List<ClienteDto> listaDto = new ArrayList<>();
		lista.forEach(l -> listaDto.add(clienteParaDto(l)));
		return listaDto;
	}

}
