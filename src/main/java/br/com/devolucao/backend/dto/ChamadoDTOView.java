package br.com.devolucao.backend.dto;

import java.time.LocalDateTime;

import br.com.devolucao.backend.domain.Chamado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Jacksonized @Builder
public class ChamadoDTOView {
	
	private String imageBase64;
	
	private LocalDateTime dataAgendamento;
	
	private EstabelecimentoDTO estabelecimentoDTO;
	
    public ChamadoDTOView(Chamado chamado) {
//        this.imageBase64 = chamado.getImageBase64();
        this.dataAgendamento = chamado.getDataAgendamento();
        this.estabelecimentoDTO = new EstabelecimentoDTO(chamado.getEstabelecimento());
    }

}
