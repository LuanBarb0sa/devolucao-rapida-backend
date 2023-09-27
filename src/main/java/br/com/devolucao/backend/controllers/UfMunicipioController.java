package br.com.devolucao.backend.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.devolucao.backend.dto.MunicipioDTO;
import br.com.devolucao.backend.dto.UfDTO;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/uf")
public class UfMunicipioController {
	 private final WebClient webClient;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping
    public @ResponseBody Mono<ResponseEntity<List<UfDTO>>> getAllUFs() {
        // Defina a URL do endpoint do IBGE que retorna as UFs
        String ibgeApiUrl = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";

        // Use o WebClient para fazer uma chamada GET para o endpoint do IBGE
        WebClient webClient = webClientBuilder.baseUrl(ibgeApiUrl).build();
        return webClient
                .get()
                .retrieve()
                .bodyToMono(UfDTO[].class)
                .map((ufsArray) -> {
                    List<UfDTO> ufsList = Arrays.asList(ufsArray);
                    return ResponseEntity.ok().body(ufsList);
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    @Autowired
    public UfMunicipioController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://servicodados.ibge.gov.br/api/v1/localidades/estados").build();
    }

    @GetMapping("/{uf}/municipios")
    public ResponseEntity<?> getMunicipiosByUf(@PathVariable String uf) {
        String ibgeApiUrl = "/{uf}/municipios";

        Mono<MunicipioDTO[]> responseMono = webClient
            .get()
            .uri(uriBuilder -> uriBuilder.path(ibgeApiUrl).build(uf))
            .retrieve()
            .bodyToMono(MunicipioDTO[].class);

        MunicipioDTO[] municipios = responseMono.block();

        if (municipios != null) {
            return ResponseEntity.ok(municipios);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
