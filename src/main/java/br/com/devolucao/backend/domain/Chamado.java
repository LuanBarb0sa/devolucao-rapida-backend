package br.com.devolucao.backend.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import br.com.devolucao.backend.enumerated.SituacaoChamado;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_chamado")
@Entity(name = "chamado")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chamado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "chamado", cascade = CascadeType.ALL)
	private List<ChamadoImagem> imagens;
	
	
	@Column(name = "dataAgendamento")
	private LocalDateTime dataAgendamento;
	
	@ManyToOne
	@JoinColumn(name = "estabelecimento_id")
	private Estabelecimento estabelecimento;
	
	@Column(name = "situacao")
	private Integer situacaoCodigo;
	
	@ManyToOne 
    @JoinColumn(name = "user_id") 
    private User user;
	
    
	public SituacaoChamado getSituacao() {
	    if (situacaoCodigo == null) {
	        return null;
	    }
	    return SituacaoChamado.porCodigo(situacaoCodigo);
	}

    public void setSituacao(SituacaoChamado situacao) {
        this.situacaoCodigo = situacao.getCodigo();
    }
    
    @PrePersist
    public void prePersist() {
    	situacaoCodigo = SituacaoChamado.PENDENTE.getCodigo();
    }

}
