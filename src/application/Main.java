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
        int qtdCadastros = Integer.parseInt(sc.nextLine());

        //Fazer Cadastro
        cadastrarPeca(estoque, sc, qtdCadastros);

        // Buscar Peça
        buscarPeca(estoque, sc);

        // Dar entrada na Peça
        registrarEntrada(estoque, sc);

        // Dar baixa na Peça
        registrarBaixa(estoque,sc);

        // Mostrar Estoque
        listarEstoque(estoque);
        }

    // Métodos
    public static void cadastrarPeca(List<Peca> estoque, Scanner sc, int qtdCadastros){
        for(int i = 0; i<qtdCadastros; i++){
            System.out.print("Nome: ");
            String pecaNome = sc.nextLine();
            System.out.print("Modelo: ");
            String pecaModelo = sc.nextLine();
            System.out.print("Marca: ");
            String pecaMarca = sc.nextLine();
            System.out.print("Quantidade: ");
            int pecaQuantidade = Integer.parseInt(sc.nextLine());
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
    }
    public static void listarEstoque(List<Peca> estoque){
        System.out.println("Estoque: ");
        for(int i = 0; i<estoque.size(); i++){
            System.out.println(estoque.get(i));
        }
    }

    public static void buscarPeca(List<Peca> estoque, Scanner sc){
        System.out.print("\nBuscar peça: ");
        String nomeBusca = sc.nextLine();
        boolean achouBusca = false;
        for(int i = 0; i < estoque.size(); i++){
            if(estoque.get(i).getNome().equals(nomeBusca)) {
                System.out.println("\n" + estoque.get(i));
                achouBusca = true;
            }
        }
        if(!achouBusca){
            System.out.println("\nNada foi encontrado na busca por essa peça.");
        }
    }
    public static Peca escolherPeca(List<Peca> estoque, Scanner sc){
        System.out.print("Digite o nome da peça que voce deseja escolher: ");
        String nomeBusca = sc.nextLine();
        for(int i = 0; i < estoque.size(); i++){
            if(estoque.get(i).getNome().equals(nomeBusca)){
                System.out.println(i + "-" + estoque.get(i));
            }
        }
        System.out.print("Digite o número da peça: ");
        int numeroEscolhido = Integer.parseInt(sc.nextLine());
        return estoque.get(numeroEscolhido);
    }
    public static void registrarEntrada(List<Peca> estoque, Scanner sc){
        Peca peca = escolherPeca(estoque, sc);
        System.out.print("Digite a quantidade a ser adicionada: ");
        int qtdAdicionada = Integer.parseInt(sc.nextLine());
        peca.darEntrada(qtdAdicionada);
        System.out.println("Peça adicionada ao estoque com sucesso.");

    }
    public static void registrarBaixa(List<Peca> estoque, Scanner sc){
        Peca peca = escolherPeca(estoque, sc);
        System.out.print("Digite a quantidade a ser removida: ");
        int qtdRemovida = Integer.parseInt(sc.nextLine());
        boolean baixaResultado = peca.darBaixa(qtdRemovida);
        if(!baixaResultado){
            System.out.println("Estoque insuficiente. Disponível: " + peca.getQuantidade());
        }else{
            System.out.println("Remoção realizada com sucesso.");
        }
    }

}


