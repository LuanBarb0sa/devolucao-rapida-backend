package br.com.devolucao.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.devolucao.backend.domain.User;
import br.com.devolucao.backend.dto.ChamadoDTO;
import br.com.devolucao.backend.dto.ChamadoDTOView;
import br.com.devolucao.backend.repositories.UserRepository;
import br.com.devolucao.backend.services.ChamadoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@RequestMapping("/chamado")
@Tag(name = "Chamados", description = "Operações referentes à inclusão de chamados.")
public class ChamadoController {
	
	private ChamadoService chamadoService;

	@Autowired
	public ChamadoController(ChamadoService chamadoService) {
		this.chamadoService = chamadoService;
	}
	  @Autowired
	    private UserRepository repository;
	
	@PostMapping("/incluir")
	public ResponseEntity<?> incluir(@RequestBody ChamadoDTO chamadoDTO) {
	    try {
	        // Obter o usuário logado
	        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        String username = userDetails.getUsername();
	        User usuarioLogado = this.repository.findByLogin(username);

	        chamadoService.incluir(chamadoDTO, usuarioLogado);
	        return ResponseEntity.ok().build();
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao incluir o chamado: " + e.getMessage());
	    }
	}

	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	    try {
	        List<ChamadoDTOView> lista = chamadoService.obterChamados();
	        return ResponseEntity.ok(lista);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Erro ao listar os chamados: " + e.getMessage());
	    }
	}

}
