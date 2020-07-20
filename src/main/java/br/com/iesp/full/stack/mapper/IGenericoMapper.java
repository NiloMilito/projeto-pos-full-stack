package br.com.iesp.full.stack.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;

import br.com.iesp.full.stack.dto.ClienteDto;
import br.com.iesp.full.stack.dto.PrestadorDto;
import br.com.iesp.full.stack.entidades.Cliente;
import br.com.iesp.full.stack.entidades.Prestador;

@org.mapstruct.Mapper(componentModel="spring")
public interface IGenericoMapper {

	@Mapping(source = "type", target = "dataType") 
    Cliente dtoParaCliente(ClienteDto dto);  
    
    @Mapping(target = "anoutherField", ignore = true)  
    ClienteDto clienteParaDto(Cliente model);  
    
    @Mapping(source = "type", target = "dataType") 
    Prestador dtoParaPrestador(PrestadorDto dto);
    
    @InheritInverseConfiguration
    PrestadorDto prestadorParaDto(Prestador model);
    
}
