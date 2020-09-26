package main.br.com.caelum.leilao.servico;

public class CriadorDeLeilao {

    private Lance.Leilao leilao;

    public CriadorDeLeilao() { }

    public CriadorDeLeilao para(String descricao) {
        this.leilao = new Lance.Leilao(descricao);
        return this;
    }

    public CriadorDeLeilao lance(Usuario usuario, double valor) {
        leilao.propoe(new Lance(usuario, valor));
        return this;
    }

    public Lance.Leilao constroi() {
        return leilao;
    }
}