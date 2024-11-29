package desafio.cliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.cliente.dto.ClienteDTO;
import desafio.cliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listall")
    public ResponseEntity<List<ClienteDTO>> listarTodosController(){
        return ResponseEntity.ok(clienteService.listarTodosService());
    }

    //Buscando o cliente por id
    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<ClienteDTO>> buscarPorIdControlller(@PathVariable Integer id){

        if (clienteService.buscaPorIdService(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clienteService.buscaPorIdService(id));
    }

    //Cadastrando clientes
    @PostMapping("/add")
    public ResponseEntity<ClienteDTO> cadastrarController(@RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<>(clienteService.cadastrarService(clienteDTO), HttpStatus.CREATED);
    }

    //Deletar clientes
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarController(@PathVariable Integer id){
        clienteService.deletarService(id);
        return ResponseEntity.noContent().build();
    }

    //Atualizando o clientes
    @PutMapping("/update")
    public ResponseEntity<ClienteDTO> atualizarController(@RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteService.atualizarService(clienteDTO));
    }

}
