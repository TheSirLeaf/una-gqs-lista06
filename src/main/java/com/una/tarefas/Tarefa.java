package com.una.tarefas;

import java.time.LocalDateTime;

public class Tarefa {

    private String descricao;
    private boolean concluida;
    private LocalDateTime criadaEm;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
        this.criadaEm = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        this.concluida = true;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    @Override
    public String toString() {
        String status = concluida ? "[x]" : "[ ]";
        return status + " " + descricao + " (criada em " + criadaEm.toLocalDate() + ")";
    }
}