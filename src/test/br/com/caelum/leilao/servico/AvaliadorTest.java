package test.br.com.caelum.leilao.servico;

import main.br.com.caelum.leilao.servico.Avaliador;
import main.br.com.caelum.leilao.servico.Lance;
import main.br.com.caelum.leilao.servico.Usuario;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AvaliadorTest {

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Lance.Leilao leilao = new Lance.Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria, 250.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // comparando a saida com o esperado
        double maiorEsperado = 400;
        double menorEsperado = 250;
        double valorMedio = 316.66;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(),0.001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
        assertEquals(valorMedio, leiloeiro.getValorMedioLance(leilao), 0.01);
    }

    @Test
    public void testaMediaDeZeroLance(){

        // cenario
        Usuario ewertom = new Usuario("Ewertom");

        // acao
        Lance.Leilao leilao = new Lance.Leilao("Iphone 7");

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        //validacao
        assertEquals(0, avaliador.getValorMedioLance(leilao), 0.0001);

    }
    @Test

    public void somenteUmLance() {
        // cenario: 1 lance em ordem crescente e descrescentee
        Usuario maria = new Usuario("Vanessa");

        Lance.Leilao leilao = new Lance.Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria, 555.55));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // comparando a saida com o esperado
        double maiorEsperado = 555.55;
        double menorEsperado = 555.55;
        double valorMedio = 555.55;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(),0.001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
        assertEquals(valorMedio, leiloeiro.getValorMedioLance(leilao), 0.01);
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Lance.Leilao leilao = new Lance.Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao,200.0));
        leilao.propoe(new Lance(maria,450.0));
        leilao.propoe(new Lance(joao,120.0));
        leilao.propoe(new Lance(maria,700.0));
        leilao.propoe(new Lance(joao,630.0));
        leilao.propoe(new Lance(maria,230.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());

        assertEquals(700.0, maiores.get(0).getValor(), 0.00001);
        assertEquals(630.0, maiores.get(1).getValor(), 0.00001);
        assertEquals(450.0, maiores.get(2).getValor(), 0.00001);

        assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(120.0, leiloeiro.getMenorLance(), 0.0001);
    }
}