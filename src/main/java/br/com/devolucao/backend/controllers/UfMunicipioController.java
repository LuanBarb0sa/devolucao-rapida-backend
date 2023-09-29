package br.com.devolucao.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.devolucao.backend.dto.MunicipioDTO;
import br.com.devolucao.backend.dto.UfDTO;
import br.com.devolucao.backend.services.EnderecoService;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/uf")
public class UfMunicipioController {
	
	private final EnderecoService enderecoService;

    @Autowired
    public UfMunicipioController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public @ResponseBody Mono<ResponseEntity<List<UfDTO>>> getAllUFs() {
        List<UfDTO> ufsList = enderecoService.getAllUFs();

        if (!ufsList.isEmpty()) {
            return Mono.just(ResponseEntity.ok(ufsList));
        } else {
            return Mono.just(ResponseEntity.notFound().build());
        }
    }

    @GetMapping("/{uf}/municipios")
    public ResponseEntity<?> getMunicipiosByUf(@PathVariable String uf) {
        List<MunicipioDTO> municipios = enderecoService.getMunicipiosByUf(uf);

        if (!municipios.isEmpty()) {
            return ResponseEntity.ok(municipios);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/bairros/{uf}/{cidade}")
    public ResponseEntity<List<String>> obterBairros(@PathVariable String uf, @PathVariable String cidade) {
        List<String> bairros = enderecoService.obterBairros(uf, cidade);

        if (bairros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bairros);
    }
}
