package desafio.cliente.dto;

import java.util.List;

public record ClienteDTO(
    Integer id,
    String nome,
    String dataCadastro,
    List<ContatoDTO> contatos
){}
