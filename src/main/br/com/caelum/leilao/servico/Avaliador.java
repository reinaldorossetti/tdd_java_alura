package main.br.com.caelum.leilao.servico;

import main.br.com.caelum.leilao.servico.Lance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private List<Lance> maiores;

    public void avalia(Lance.Leilao leilao) {

        for(Lance lance : leilao.getLances()) {
            if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
            if(lance.getValor() < menorDeTodos) menorDeTodos = lance.getValor();
        }
        maiores = new ArrayList<Lance>(leilao.getLances());
        Collections.sort(maiores, new Comparator<Lance>() {
            @Override
            public int compare(Lance o1, Lance o2) {
                    if(o1.getValor() < o2.getValor()) return 1;
                    if(o1.getValor() > o2.getValor()) return -1;
                    return 0;
                }
            });
        maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
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

    public List<Lance> getTresMaiores() {
        return this.maiores;
    }

}