package desafio.cliente.mapper;

import org.mapstruct.Mapper;
import desafio.cliente.dto.ClienteDTO;
import desafio.cliente.entity.Cliente;

@Mapper
public interface ClienteMapper {

    ClienteDTO toDTO(Cliente cliente);

    Cliente toEntity(ClienteDTO clienteDTO);
} 
    

