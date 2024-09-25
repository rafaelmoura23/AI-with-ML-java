package com.example;

public class DecisaoPlanetaID3 {
    public static No construirArvore() {
        // Criação da árvore de decisão com base no tipo de planeta

        // Gasoso e Rochoso
        No raiz = new No("");

        // Nó com valor "Sim" para Gasoso
        No gasosoSim = new No("Gasoso");
        gasosoSim.adicionarFilho("Sim", new No("Gasoso", "Planeta Gasoso"));
        gasosoSim.adicionarFilho("Não", new No("Rochoso", "Planeta Rochoso"));

        // Nó com valor "Sim" para Rochoso
        No rochosoSim = new No("Rochoso");
        rochosoSim.adicionarFilho("Sim", new No("Rochoso", "Planeta Rochoso"));
        rochosoSim.adicionarFilho("Não", new No("Gasoso", "Planeta Gasoso"));

        // Nó com valor "Sim" para mais próximo do Sol
        

        // Adiciona os nós filhos à raiz
        raiz.adicionarFilho("Sim", gasosoSim);

        return raiz;
    }
}
