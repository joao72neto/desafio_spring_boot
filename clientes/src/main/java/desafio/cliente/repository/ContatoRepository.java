package desafio.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio.cliente.entity.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {}
