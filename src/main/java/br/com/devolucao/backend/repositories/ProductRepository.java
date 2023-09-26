package br.com.devolucao.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devolucao.backend.domain.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
