package main.br.com.caelum.leilao.servico;

import main.br.com.caelum.leilao.servico.Lance;

public class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;

    public void avalia(Lance.Leilao leilao) {

        for(Lance lance : leilao.getLances()) {
            if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
            if(lance.getValor() < menorDeTodos) menorDeTodos = lance.getValor();
        }
    }

    public double getValorMedioLance(Lance.Leilao leilao){
        double valorMedio = 0;
        for(Lance lance : leilao.getLances()) {
            valorMedio += lance.getValor();
        }
        if (leilao.getLances().size() > 0 || valorMedio > 0) {
            return valorMedio / leilao.getLances().size();
        }
        return valorMedio;
    }

    public double getMaiorLance() { return maiorDeTodos; }
    public double getMenorLance() { return menorDeTodos; }

}