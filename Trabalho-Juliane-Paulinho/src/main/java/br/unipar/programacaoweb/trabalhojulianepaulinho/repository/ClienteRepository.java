package br.unipar.programacaoweb.trabalhojulianepaulinho.repository;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
