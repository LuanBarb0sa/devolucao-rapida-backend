package br.com.devolucao.backend.dto;

public class MunicipioDTO {

	private Long id;
	private String nome;
	private MicrorregiaoDTO microrregiao;

	public static class MicrorregiaoDTO {
		private Long id;
		private String nome;
		private MesorregiaoDTO mesorregiao;
		private RegiaoImediataDTO regiaoImediata;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public MesorregiaoDTO getMesorregiao() {
			return mesorregiao;
		}

		public void setMesorregiao(MesorregiaoDTO mesorregiao) {
			this.mesorregiao = mesorregiao;
		}

		public RegiaoImediataDTO getRegiaoImediata() {
			return regiaoImediata;
		}

		public void setRegiaoImediata(RegiaoImediataDTO regiaoImediata) {
			this.regiaoImediata = regiaoImediata;
		}

	}

	public static class MesorregiaoDTO {
		private Long id;
		private String nome;
		private RegiaoIntermediariaDTO regiaoIntermediaria;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public RegiaoIntermediariaDTO getRegiaoIntermediaria() {
			return regiaoIntermediaria;
		}

		public void setRegiaoIntermediaria(RegiaoIntermediariaDTO regiaoIntermediaria) {
			this.regiaoIntermediaria = regiaoIntermediaria;
		}

	}

	public static class RegiaoImediataDTO {
		private Long id;
		private String nome;
		private RegiaoIntermediariaDTO regiaoIntermediaria;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public RegiaoIntermediariaDTO getRegiaoIntermediaria() {
			return regiaoIntermediaria;
		}

		public void setRegiaoIntermediaria(RegiaoIntermediariaDTO regiaoIntermediaria) {
			this.regiaoIntermediaria = regiaoIntermediaria;
		}

		// Getters e setters para RegiaoImediataDTO
	}

	public static class RegiaoIntermediariaDTO {
		private Long id;
		private String nome;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public MicrorregiaoDTO getMicrorregiao() {
		return microrregiao;
	}

	public void setMicrorregiao(MicrorregiaoDTO microrregiao) {
		this.microrregiao = microrregiao;
	}

}
