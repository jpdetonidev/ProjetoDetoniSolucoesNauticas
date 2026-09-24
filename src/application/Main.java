package application;

import entities.Peca;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Peca> estoque = new ArrayList<>();

        System.out.print("Escreva a quantidade de peças a serem inseridas no estoque: ");
        int qtdCadastros = sc.nextInt();

        //Fazer Cadastro
        for(int i = 0; i<qtdCadastros; i++){
            sc.nextLine();
            System.out.print("Nome: ");
            String pecaNome = sc.nextLine();
            System.out.print("Modelo: ");
            String pecaModelo = sc.nextLine();
            System.out.print("Marca: ");
            String pecaMarca = sc.nextLine();
            System.out.print("Quantidade: ");
            int pecaQuantidade = sc.nextInt();
            Peca pecaExistente = null;
            for (int j = 0; j < estoque.size(); j++) {
                if (estoque.get(j).mesmaPeca(pecaNome, pecaModelo, pecaMarca)) {
                    pecaExistente = estoque.get(j);
                }
            }
            if (pecaExistente != null) {
                pecaExistente.darEntrada(pecaQuantidade);

            } else {
                estoque.add(new Peca(pecaNome, pecaModelo, pecaMarca, pecaQuantidade));

            }
        }
        // Buscar Peça
        System.out.print("\nBuscar peça: ");
        sc.nextLine();
        String nomeBusca = sc.nextLine();
        boolean achouBusca = false;
        for(int i = 0; i < estoque.size(); i++){
            if(estoque.get(i).getNome().equals(nomeBusca)){
                System.out.println("\n" + estoque.get(i));
                achouBusca = true;
            }
        }
        if(!achouBusca){
            System.out.println("\nNada foi encontrado na busca por essa peça.");
        }

        // Dar entrada na Peça
        System.out.print("Digite o nome da peça que voce deseja adicionar: ");
        String addPecaNome = sc.nextLine();
        for(int i = 0; i < estoque.size(); i++){
            if(estoque.get(i).getNome().equals(addPecaNome)){
                System.out.println(i + "-" + estoque.get(i));
            }
        }
        System.out.print("Digite o número da peça: ");
        int numeroEntrada = sc.nextInt();
        Peca pecaEntrada = estoque.get(numeroEntrada);
        System.out.print("Digite a quantidade para ser adicionada: ");
        int qtdAdicionada = sc.nextInt();
        pecaEntrada.darEntrada(qtdAdicionada);
        System.out.println("Peça adicionada com sucesso ao estoque.");


        // Dar baixa na Peça
        System.out.print("\nDigite o nome da peça que você deseja remover: ");
        sc.nextLine();
        String remPecaNome = sc.nextLine();
        for(int i = 0; i < estoque.size(); i++){
            if(estoque.get(i).getNome().equals(remPecaNome)){
                System.out.println(i + "-" + estoque.get(i));
            }
        }
        System.out.print("Digite o número da peça: ");
        int numeroBaixa = sc.nextInt();
        Peca pecaBaixa = estoque.get(numeroBaixa);
        System.out.print("Digite a quantidade para ser removida: ");
        int qtdRemovida = sc.nextInt();
        boolean rresultado = pecaBaixa.darBaixa(qtdRemovida);
        if(!rresultado){
            System.out.println("Estoque insuficiente. Disponível: " + pecaBaixa.getQuantidade());
        }else{
            System.out.println("Remoção realizada com sucesso.");
        }

        // Mostrar Estoque
        System.out.println("\n\nEstoque: ");
        for(int i = 0; i<estoque.size(); i++){
            System.out.println(estoque.get(i));
        }

    }
}
