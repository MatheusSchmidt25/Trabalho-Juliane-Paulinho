package br.unipar.programacaoweb.trabalhojulianepaulinho.repository;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {
}
