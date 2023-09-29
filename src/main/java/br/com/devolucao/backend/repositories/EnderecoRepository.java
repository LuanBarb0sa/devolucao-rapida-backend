package br.com.devolucao.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.devolucao.backend.domain.Estabelecimento;

public interface EnderecoRepository extends JpaRepository<Estabelecimento, Long> {
	
    @Query("SELECT DISTINCT e.bairro FROM estabelecimento e WHERE e.uf = :uf AND e.municipio = :municipio")
    List<String> findBairrosByUfAndMunicipio(@Param("uf") String uf, @Param("municipio") String municipio);

}
