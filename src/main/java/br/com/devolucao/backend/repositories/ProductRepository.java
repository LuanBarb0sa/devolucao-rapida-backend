package br.com.devolucao.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devolucao.backend.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
