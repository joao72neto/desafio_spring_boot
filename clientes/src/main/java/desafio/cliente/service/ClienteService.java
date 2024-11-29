package desafio.cliente.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.cliente.dto.ClienteDTO;
import desafio.cliente.entity.Cliente;
import desafio.cliente.entity.Contato;
import desafio.cliente.mapper.ClienteMapper;
import desafio.cliente.repository.ClienteRepository;
//import desafio.cliente.repository.ContatoRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ClienteMapper clienteMapper;

    //Listando todos os dados do banco de dados
    public List<ClienteDTO> listarTodosService(){
        return clienteRepository.findAll().stream()
                            .map(clienteMapper::toDTO)
                            .toList();
    }

    //Buscando cliente por id
    public Optional<ClienteDTO> buscaPorIdService(Integer id){
        return clienteRepository.findById(id).map(clienteMapper::toDTO);
    }

    //Cadastrando clientes    
    public ClienteDTO cadastrarService(ClienteDTO clienteDTO){
       
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente.setDataCadastro(LocalDate.now());

        for (Contato contato : cliente.getContatos()) {
            contato.setCliente(cliente);
        }

        return clienteMapper.toDTO(clienteRepository.save(cliente));
    }

    //Deletando clientes
    public void deletarService(Integer id){
        clienteRepository.deleteById(id);
    }

    //Atualizando os dados do cliente
    public ClienteDTO atualizarService(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        Cliente cliente_atualizado = clienteRepository.findById(cliente.getId()).get();
        cliente_atualizado = cliente;


        for (Contato contato : cliente_atualizado.getContatos()) {
            contato.setCliente(cliente_atualizado);
        }

        return clienteMapper.toDTO(clienteRepository.save(cliente_atualizado));  
    }
}
