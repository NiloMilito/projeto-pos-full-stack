package br.com.iesp.full.stack.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.full.stack.dto.VendedorDto;
import br.com.iesp.full.stack.entidades.Vendedor;
import br.com.iesp.full.stack.especificacao.VendedorEspecificacao;
import br.com.iesp.full.stack.repositorio.IVendedorRepositorio;
import br.com.iesp.full.stack.util.ConversorDtoModel;
import br.com.iesp.full.stack.util.ConversorModelDto;

@Service
public class VendedorServico implements IGenericoCRUD<VendedorDto, Long>{
	
	@Autowired
	private IVendedorRepositorio vendedorRepository;
	@Autowired
	private ConversorDtoModel conversorDtoModel;
	@Autowired
	private ConversorModelDto ConversorModelDto;

	@Override
	@Transactional
	public void salvar(VendedorDto objectDto) {
		Vendedor vendedor = this.conversorDtoModel.dtoParaVendedor(objectDto);
		this.vendedorRepository.save(vendedor);
	}

	@Override
	@Transactional
	public void alterar(VendedorDto objectDto) {
		Vendedor vendedor = this.conversorDtoModel.dtoParaVendedor(objectDto);
		this.vendedorRepository.save(vendedor);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.vendedorRepository.deleteById(id);
	}

	@Override
	public VendedorDto buscar(Long id) {
		VendedorDto vendedorDto = this.ConversorModelDto.vendedorParaDto(this.vendedorRepository.getOne(id));
		return vendedorDto;
	}
	@Override
	public List<VendedorDto> listar(VendedorDto filtro) {
		VendedorEspecificacao pageable = new VendedorEspecificacao(this.conversorDtoModel.dtoParaVendedor(filtro));
		List<VendedorDto> listaDto = this.ConversorModelDto.listaVendedorParaDto(this.vendedorRepository.findAll(pageable));
		return listaDto;
	}

	@Override
	public List<VendedorDto> listar() {		
		List<VendedorDto> listaDto = this.ConversorModelDto.listaVendedorParaDto(this.vendedorRepository.findAll());
		return listaDto;
	}

}
