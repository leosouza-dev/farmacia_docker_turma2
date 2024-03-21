package br.com.alura.farmacia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosCadastroDTO(
        @NotBlank
        String nomeFabricante,
        @NotBlank
        String nomeProduto,
        @NotBlank
        String descricaoProduto,
        @Positive
        double precoProduto) {
}
