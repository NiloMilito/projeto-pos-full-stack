package br.com.iesp.full.stack.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.full.stack.dto.PrestadorDto;
import br.com.iesp.full.stack.entidades.Prestador;
import br.com.iesp.full.stack.especificacao.VendedorEspecificacao;
import br.com.iesp.full.stack.repositorio.IPrestadorRepositorio;
import br.com.iesp.full.stack.util.ConversorDtoModel;
import br.com.iesp.full.stack.util.ConversorModelDto;

@Service
public class PrestadorServico implements IGenericoCRUD<PrestadorDto, Long>{
	
	@Autowired
	private IPrestadorRepositorio vendedorRepository;
	@Autowired
	private ConversorDtoModel conversorDtoModel;
	@Autowired
	private ConversorModelDto ConversorModelDto;

	@Override
	@Transactional
	public void salvar(PrestadorDto objectDto) {
		Prestador vendedor = this.conversorDtoModel.dtoParaVendedor(objectDto);
		this.vendedorRepository.save(vendedor);
	}

	@Override
	@Transactional
	public void alterar(PrestadorDto objectDto) {
		Prestador vendedor = this.conversorDtoModel.dtoParaVendedor(objectDto);
		this.vendedorRepository.save(vendedor);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.vendedorRepository.deleteById(id);
	}

	@Override
	public PrestadorDto buscar(Long id) {
		PrestadorDto vendedorDto = this.ConversorModelDto.prestadorParaDto(this.vendedorRepository.getOne(id));
		return vendedorDto;
	}
	@Override
	public List<PrestadorDto> listar(PrestadorDto filtro) {
		VendedorEspecificacao pageable = new VendedorEspecificacao(this.conversorDtoModel.dtoParaVendedor(filtro));
		List<PrestadorDto> listaDto = this.ConversorModelDto.listaVendedorParaDto(this.vendedorRepository.findAll(pageable));
		return listaDto;
	}

	@Override
	public List<PrestadorDto> listar() {		
		List<PrestadorDto> listaDto = this.ConversorModelDto.listaVendedorParaDto(this.vendedorRepository.findAll());
		return listaDto;
	}

}
