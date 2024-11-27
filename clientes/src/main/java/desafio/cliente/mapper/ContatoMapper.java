package desafio.cliente.mapper;

import desafio.cliente.dto.ContatoDTO;
import desafio.cliente.entity.Contato;

public class ContatoMapper {
    public static ContatoDTO toDTO(Contato contato){
        ContatoDTO dto = new ContatoDTO(contato.getId(), 
                                        contato.getTipo(),
                                        contato.getTexto());

        return dto;
    }

    public static Contato toEntity(ContatoDTO dto){
        Contato contato = new Contato();

        contato.setId(dto.id());
        contato.setTexto(dto.texto());
        contato.setTipo(dto.tipo());

        return contato;
    }
}
