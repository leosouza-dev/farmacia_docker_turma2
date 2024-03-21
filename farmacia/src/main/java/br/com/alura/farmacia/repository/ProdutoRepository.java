package br.com.alura.farmacia.repository;

import br.com.alura.farmacia.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
