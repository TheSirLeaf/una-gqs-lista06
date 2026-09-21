package com.una.tarefas;

import java.util.Scanner;

public class Main {

    private static final GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== GERENCIADOR DE TAREFAS ===");
            System.out.println("1. Listar tarefas");
            System.out.println("2. Adicionar tarefa");
            System.out.println("3. Concluir tarefa");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> listarTarefas();
                case 2 -> adicionarTarefa();
                case 3 -> concluirTarefa();
                case 4 -> removerTarefa();
                case 5 -> System.out.println("Até logo!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    private static void listarTarefas() {
        if (gerenciador.total() == 0) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        for (int i = 0; i < gerenciador.total(); i++) {
            System.out.println((i + 1) + ". " + gerenciador.buscar(i));
        }
        System.out.println("Total: " + gerenciador.total()
                + " | Concluídas: " + gerenciador.totalConcluidas());
    }

    private static void adicionarTarefa() {
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine().trim();
        gerenciador.adicionar(descricao);
        System.out.println("Tarefa adicionada.");
    }

    private static void concluirTarefa() {
        System.out.print("Número da tarefa: ");
        int numero = lerInteiro();
        gerenciador.concluir(numero - 1);
        System.out.println("Tarefa concluída.");
    }

    private static void removerTarefa() {
        System.out.print("Número da tarefa: ");
        int numero = lerInteiro();
        gerenciador.remover(numero - 1);
        System.out.println("Tarefa removida.");
    }

    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.print("Informe um número: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
}