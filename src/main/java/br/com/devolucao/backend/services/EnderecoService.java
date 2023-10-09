package br.com.devolucao.backend.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.devolucao.backend.dto.MunicipioDTO;
import br.com.devolucao.backend.dto.UfDTO;
import br.com.devolucao.backend.repositories.EnderecoRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;

@Service
public class EnderecoService {
	
	private static final Logger LOGGER = Logger.getLogger(EnderecoService.class.getName());
	
	private EnderecoRepository  enderecoRepository;
	
	private final WebClient webClient;
	
	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository, WebClient.Builder webClientBuilder) {
		this.enderecoRepository = enderecoRepository;
		this.webClient = webClientBuilder
	            .baseUrl("https://servicodados.ibge.gov.br/api/v1/localidades")
	            .build();
	}
	
    public List<String> getAllUFs() {
    	LOGGER.info("Obter UFs");
    	return enderecoRepository.findAllDistinctUfs();
    }

    public List<String> getMunicipiosByUf(String uf) {
	LOGGER.info("Obter municipios no uf:" + uf);
		
		if(StringUtils.isEmpty(uf)) {
			throw new IllegalArgumentException("uf deve ser fornecido.");
		}
		
		return enderecoRepository.findMunicipioByUf(uf);
    }


	@Transactional
    public List<String> obterBairros(String uf, String cidade) {
		
		LOGGER.info("Obter bairros, params: uf" + uf +  cidade);
		
        if (StringUtils.isEmpty(uf) || StringUtils.isEmpty(cidade)) {
            throw new IllegalArgumentException("UF e cidade devem ser fornecidos.");
        }
        // Chame o método personalizado do repository para obter os bairros
        return enderecoRepository.findBairrosByUfAndMunicipio(uf, cidade);
    }

	@Transactional
	public List<String> obterLojas(String municipio,String bairro) {
		
		LOGGER.info("Obter lojas no bairro:" + bairro);
		
		if(StringUtils.isEmpty(bairro)) {
			throw new IllegalArgumentException("Bairro deve ser fornecido.");
		}
		
		return enderecoRepository.findLojasByBairro(municipio, bairro);
	}

}
