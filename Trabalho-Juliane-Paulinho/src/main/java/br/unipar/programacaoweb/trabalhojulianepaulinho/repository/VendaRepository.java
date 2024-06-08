package br.unipar.programacaoweb.trabalhojulianepaulinho.repository;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {


}
