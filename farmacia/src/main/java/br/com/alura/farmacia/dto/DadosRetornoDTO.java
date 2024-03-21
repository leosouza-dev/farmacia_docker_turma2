package br.com.alura.farmacia.dto;

import br.com.alura.farmacia.model.produto.Produto;

public record DadosRetornoDTO(String nomeFabricante,
                              String nomeProduto,
                              String descricaoProduto,
                              double precoProduto) {

    public DadosRetornoDTO(Produto produto) {
        this(produto.getFabricante().getNome(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco());
    }
}
