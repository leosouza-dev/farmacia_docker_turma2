package br.com.alura.farmacia.repository;

import br.com.alura.farmacia.model.fabricante.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
    Fabricante findByNome(String s);
}
