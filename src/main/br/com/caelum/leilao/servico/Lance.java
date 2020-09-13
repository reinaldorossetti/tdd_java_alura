package main.br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lance {

	private Usuario usuario;
	private double valor;
	
	public Lance(Usuario usuario, double valor) {
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getValor() {
		return valor;
	}

	public static class Leilao {

		private String descricao;
		private List<Lance> lances;

		public Leilao(String descricao) {
			this.descricao = descricao;
			this.lances = new ArrayList<Lance>();
		}

		public void propoe(Lance lance) {
			lances.add(lance);
		}

		public String getDescricao() {
			return descricao;
		}

		public List<Lance> getLances() {
			return Collections.unmodifiableList(lances);
		}

	}
}
