package br.com.devolucao.backend.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devolucao.backend.domain.Chamado;
import br.com.devolucao.backend.domain.Estabelecimento;
import br.com.devolucao.backend.dto.ChamadoDTO;
import br.com.devolucao.backend.repositories.ChamadoRepository;
import jakarta.transaction.Transactional;

@Service
public class ChamadoService {
	
	private ChamadoRepository chamadoRepository;
	
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	public ChamadoService(ChamadoRepository chamadoRepository, EstabelecimentoService estabelecimentoService) {
		this.chamadoRepository = chamadoRepository;
		this.estabelecimentoService = estabelecimentoService;
	}


	@Transactional
	public void incluir(ChamadoDTO chamadoDTO) {
	    Chamado objeto = new Chamado();
	    Estabelecimento estabObjeto = estabelecimentoService.obterEstabelecimento(chamadoDTO);

	    objeto.setEstabelecimento(estabObjeto);
	    objeto.setDataAgendamento(LocalDateTime.now());
	    objeto.setImageBase64(chamadoDTO.getImagem());
	    
	    chamadoRepository.save(objeto);
	}
	
}
