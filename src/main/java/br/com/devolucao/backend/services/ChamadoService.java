package br.com.devolucao.backend.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devolucao.backend.domain.Chamado;
import br.com.devolucao.backend.domain.ChamadoImagem;
import br.com.devolucao.backend.domain.Estabelecimento;
import br.com.devolucao.backend.domain.User;
import br.com.devolucao.backend.dto.ChamadoDTO;
import br.com.devolucao.backend.dto.ChamadoDTOView;
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
	public void incluir(ChamadoDTO chamadoDTO, User usuarioLogado) {
	    Chamado objeto = new Chamado();
	    Estabelecimento estabObjeto = estabelecimentoService.obterEstabelecimento(chamadoDTO);

	    objeto.setEstabelecimento(estabObjeto);
	    objeto.setDataAgendamento(LocalDateTime.now());
	    objeto.setUser(usuarioLogado);

	    
	    List<ChamadoImagem> imagens = chamadoDTO.getImagens().stream()
	        .map(imagemBase64 -> {
	            ChamadoImagem imagem = new ChamadoImagem();
	            imagem.setImageBase64(imagemBase64);
	            imagem.setChamado(objeto);
	            return imagem;
	        })
	        .collect(Collectors.toList());

	    objeto.setImagens(imagens);

	    chamadoRepository.save(objeto);
	}


	public List<ChamadoDTOView> obterChamados() {
	    List<ChamadoDTOView> listDto = new ArrayList<>();
	    List<Chamado> listChamados = chamadoRepository.findAll();
	    
	    listChamados.stream().forEach(chamado -> {
	        ChamadoDTOView dto = new ChamadoDTOView(chamado);
	        listDto.add(dto);
	    });

	    return listDto;
	}
	
}
