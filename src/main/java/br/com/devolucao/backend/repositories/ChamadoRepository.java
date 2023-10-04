package br.com.devolucao.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devolucao.backend.domain.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
