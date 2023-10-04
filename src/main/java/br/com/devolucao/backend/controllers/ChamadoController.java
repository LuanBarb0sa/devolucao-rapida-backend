package br.com.devolucao.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.devolucao.backend.dto.ChamadoDTO;
import br.com.devolucao.backend.services.ChamadoService;

@Controller
@RequestMapping("/chamado")
public class ChamadoController {
	
	private ChamadoService chamadoService;

	@Autowired
	public ChamadoController(ChamadoService chamadoService) {
		this.chamadoService = chamadoService;
	}
	
	@PostMapping("/incluir")
	public ResponseEntity<?> incluir(@RequestBody ChamadoDTO chamadoDTO) {
	    try {
	        chamadoService.incluir(chamadoDTO);
	        return ResponseEntity.ok().build();
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao incluir o chamado: " + e.getMessage());
	    }
	}
	
	
	
}
