package br.com.devolucao.backend.dto;

import br.com.devolucao.backend.domain.Product;

public record ProductResponseDTO(String id, String name, Integer price) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice());
    }
}
