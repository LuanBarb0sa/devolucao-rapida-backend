package br.com.devolucao.backend.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.devolucao.backend.domain.Product;
import br.com.devolucao.backend.dto.ProductRequestDTO;
import br.com.devolucao.backend.dto.ProductResponseDTO;
import br.com.devolucao.backend.repositories.ProductRepository;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController()
@RequestMapping("product")
@Tag(name = "Product", description = "Operações referentes à busca de endereços.")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @PostMapping
    public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDTO body){
        Product newProduct = new Product(body);

        this.repository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<ProductResponseDTO> productList = this.repository.findAll().stream().map(ProductResponseDTO::new).toList();

        return ResponseEntity.ok(productList);
    }
}
