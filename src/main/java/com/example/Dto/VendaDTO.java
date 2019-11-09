package com.example.Dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendaDTO {
    private int id;
    private List<ProdutoDTO> produtos;
    private double precoTotal;
    
    private void CalculaPrecoTotal(){
        precoTotal = 0;
        produtos.stream().forEach((produto) -> {
            precoTotal += produto.getPreco() * produto.getQtd();
        });
    }
}
