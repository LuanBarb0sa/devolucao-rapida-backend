package br.com.devolucao.backend.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.devolucao.backend.domain.Chamado;
import br.com.devolucao.backend.enumerated.SituacaoChamado;
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
	
	private Long id;
	
	private String imageBase64;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private LocalDateTime dataAgendamento;
	
	private EstabelecimentoDTO estabelecimentoDTO;
	
	private int situacaoCodigo;
	
    public ChamadoDTOView(Chamado chamado) {
//        this.imageBase64 = chamado.getImageBase64();
        this.dataAgendamento = chamado.getDataAgendamento();
        this.id = chamado.getId();
        this.estabelecimentoDTO = new EstabelecimentoDTO(chamado.getEstabelecimento());
        this.situacaoCodigo = SituacaoChamado.porCodigo(chamado.getSituacaoCodigo()).getCodigo();
    }

}
