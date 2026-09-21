package com.una.tarefas;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {

    private final List<Tarefa> tarefas = new ArrayList<>();

    public void adicionar(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
        tarefas.add(new Tarefa(descricao));
    }

    public void concluir(int indice) {
        Tarefa tarefa = buscar(indice);
        tarefa.concluir();
    }

    public void remover(int indice) {
        tarefas.remove(indice);
    }

    public Tarefa buscar(int indice) {
        if (indice < 0 || indice >= tarefas.size()) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        return tarefas.get(indice);
    }

    public List<Tarefa> listarTodas() {
        return new ArrayList<>(tarefas);
    }

    public int total() {
        return tarefas.size();
    }

    public long totalConcluidas() {
        return tarefas.stream().filter(Tarefa::isConcluida).count();
    }
}