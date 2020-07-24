package br.com.iesp.full.stack.mapper;

import br.com.iesp.full.stack.dto.ClienteDto;
import br.com.iesp.full.stack.dto.PrestadorDto;
import br.com.iesp.full.stack.entidades.Cliente;
import br.com.iesp.full.stack.entidades.Prestador;

//@Mapper(componentModel="spring")
public interface IGenericoMapper {

	//@Mapping(source = "type", target = "dataType") 
    Cliente dtoParaCliente(ClienteDto dto);  
    
    //@Mapping(target = "anoutherField", ignore = true)  
    ClienteDto clienteParaDto(Cliente model);  
    
    //@Mapping(source = "type", target = "dataType") 
    Prestador dtoParaPrestador(PrestadorDto dto);
    
    //@InheritInverseConfiguration
    PrestadorDto prestadorParaDto(Prestador model);
    
}
