package desafio.cliente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import desafio.cliente.dto.ContatoDTO;
import desafio.cliente.entity.Contato;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContatoMapper {
 
    ContatoDTO toDTO(Contato contato);

    Contato toEntity(ContatoDTO contatoDTO);
}
