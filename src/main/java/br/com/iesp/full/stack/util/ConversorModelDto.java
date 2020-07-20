package br.com.iesp.full.stack.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.iesp.full.stack.dto.ClienteDto;
import br.com.iesp.full.stack.dto.ComentarioDto;
import br.com.iesp.full.stack.dto.EnderecoDto;
import br.com.iesp.full.stack.dto.PrestadorDto;
import br.com.iesp.full.stack.dto.ServicoDto;
import br.com.iesp.full.stack.entidades.Cliente;
import br.com.iesp.full.stack.entidades.Comentario;
import br.com.iesp.full.stack.entidades.Endereco;
import br.com.iesp.full.stack.entidades.Prestador;
import br.com.iesp.full.stack.entidades.Servico;

@Component
public class ConversorModelDto {	

	public PrestadorDto prestadorParaDto(Prestador vendedor) {
		PrestadorDto vendedorDto = new PrestadorDto();
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
		enderecoDto.setRua(endereco.getRua());
		return enderecoDto;
	}

	public ServicoDto servicoParaDto(Servico servico) {
		//ServicoDto servicoDto = ServicoMapper.INSTANCE.servicoParaDto(servico);	
		ServicoDto servicoDto = new ServicoDto();
		return servicoDto;
	}

	public List<ServicoDto> listaServicoParaDto(List<Servico> lista) {
		List<ServicoDto> listaDto = new ArrayList<>();
		lista.forEach(l -> listaDto.add(servicoParaDto(l)));
		return listaDto;
	}

	public List<PrestadorDto> listaVendedorParaDto(List<Prestador> lista) {
		List<PrestadorDto> listaDto = new ArrayList<>();
		lista.forEach(l -> listaDto.add(prestadorParaDto(l)));
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
