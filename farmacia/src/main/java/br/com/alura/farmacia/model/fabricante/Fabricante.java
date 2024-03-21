package br.com.alura.farmacia.model.fabricante;

import br.com.alura.farmacia.dto.DadosCadastroDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "fabricantes")
@Entity(name = "Fabricante")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String nome;

    public Fabricante(DadosCadastroDTO dadosCadastro) {
        this.nome = dadosCadastro.nomeFabricante();
    }

    public String getNome() {
        return nome;
    }
}
