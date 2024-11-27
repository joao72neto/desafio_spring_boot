package desafio.cliente.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.cliente.entity.Cliente;
import desafio.cliente.entity.Contato;
import desafio.cliente.repository.ClienteRepository;
//import desafio.cliente.repository.ContatoRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    //private ContatoRepository contatoRepository;

    //Listando todos os dados do banco de dados
    public List<Cliente> listarTodosService(){
        return clienteRepository.findAll();
    }

    //Buscando cliente por id
    public Optional<Cliente> buscaPorIdService(Integer id){
        return clienteRepository.findById(id);
    }

    //Cadastrando clientes    
    public Cliente cadastrarService(Cliente cliente){
       
        cliente.setDataCadastro(LocalDate.now());

        for (Contato contato : cliente.getContatos()) {
            contato.setCliente(cliente);
        }

        return clienteRepository.save(cliente);
    }

    //Deletando clientes
    public void deletarService(Integer id){
        clienteRepository.deleteById(id);
    }

    //Atualizando os dados do cliente
    public Cliente atualizarService(Cliente cliente){
        Cliente cliente2 = clienteRepository.findById(cliente.getId()).get();
        cliente2 = cliente;

        for (Contato contato : cliente2.getContatos()) {
            contato.setCliente(cliente2);
        }

        return clienteRepository.save(cliente2);  
    }
}
