package br.com.devolucao.backend.dto;

public class UfDTO {

	private int id;
	private String nome;
	private String sigla;
	private RegiaoDTO regiao;



	public static class RegiaoDTO {

		private int id;
		private String nome;
		private String sigla;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSigla() {
			return sigla;
		}

		public void setSigla(String sigla) {
			this.sigla = sigla;
		}

	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	public RegiaoDTO getRegiao() {
		return regiao;
	}

}