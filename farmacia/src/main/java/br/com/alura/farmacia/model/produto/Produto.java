package br.com.alura.farmacia.model.produto;

import br.com.alura.farmacia.dto.AtualizaProdutoDTO;
import br.com.alura.farmacia.dto.DadosCadastroDTO;
import br.com.alura.farmacia.model.fabricante.Fabricante;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    @ManyToOne
    private Fabricante fabricante;

    public Produto(DadosCadastroDTO dadosCadastro, Fabricante fabricante) {
        this.nome = dadosCadastro.nomeProduto();
        this.descricao = dadosCadastro.descricaoProduto();
        this.preco = dadosCadastro.precoProduto();
        this.fabricante = fabricante;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void atualizar(AtualizaProdutoDTO produtoDTO) {
        if(produtoDTO.descricaoProduto() != null){
            this.descricao = produtoDTO.descricaoProduto();
        }
        if(produtoDTO.precoProduto() > 0){
            this.preco = produtoDTO.precoProduto();
        }
    }
}
