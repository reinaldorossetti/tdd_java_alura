package test.br.com.caelum.leilao.servico;

import main.br.com.caelum.leilao.servico.Avaliador;
import main.br.com.caelum.leilao.servico.Lance;
import main.br.com.caelum.leilao.servico.Usuario;
import org.junit.Test;

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
}