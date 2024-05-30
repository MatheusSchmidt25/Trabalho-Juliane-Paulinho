package br.unipar.programacaoweb.trabalhojulianepaulinho.repository;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
