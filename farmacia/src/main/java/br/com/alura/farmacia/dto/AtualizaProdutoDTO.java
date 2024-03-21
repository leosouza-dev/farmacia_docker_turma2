package br.com.alura.farmacia.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizaProdutoDTO(
        @NotNull
        int id,
        String descricaoProduto,
        double precoProduto) {
}
