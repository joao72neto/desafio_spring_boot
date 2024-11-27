package desafio.cliente.mapper;

import java.time.LocalDate;
import java.util.stream.Collectors;

import desafio.cliente.dto.ClienteDTO;
import desafio.cliente.entity.Cliente;

public class ClienteMapper {
    public static ClienteDTO toDTO(Cliente cliente){
        ClienteDTO dto = new ClienteDTO(cliente.getId(), 
                                        cliente.getNome(), 
                                        cliente.getDataCadastro().toString(), 
                                        cliente.getContatos()
                                        .stream()
                                        .map(ContatoMapper::toDTO)
                                        .collect(Collectors.toList()));

        return dto;
    }

    public static Cliente toEntity(ClienteDTO dto){
        Cliente cliente = new Cliente();

        cliente.setId(dto.id());
        cliente.setNome(dto.nome());
        cliente.setDataCadastro(dto.dataCadastro() != null ? LocalDate.parse(dto.dataCadastro()) : LocalDate.now());

        cliente.setContatos(dto.contatos()
                            .stream()
                            .map(ContatoMapper::toEntity)
                            .collect(Collectors.toList()));

        return cliente;
    }
}
