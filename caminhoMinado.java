import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class caminhoMinado {
    public static int[] caminho(int tamCaminho, int qntBombas) {
        //faz com que as bombas sejam colocadas em locasi aleatorios do caminho
        int[] caminho = new int[tamCaminho];
        Random random = new Random();

        for (int i = 0; i < qntBombas; i++) {
            int localBomba = random.nextInt(tamCaminho);
            while (caminho[localBomba] == -1) {
                localBomba = random.nextInt(tamCaminho);
            }
            caminho[localBomba] = -1;
        }
        return caminho;
    }

    public static void mostraCaminho(int[] caminho, int[] local) {
        //monta o caminho do jogo
        for (int i = 0; i < caminho.length; i++) {
            if (local[i] == 0) {
                System.out.print(" _ ");
            } else if (local[i] == -1) {
                System.out.print(" B ");
            } else if (local[i] == 1) {
                System.out.print(" x ");
            }
        }
    }

    public static void gabarito(int[] caminho) {
        //o gabarito mostra onde as bombas estavam localizadas
        System.out.println("Gabarito das bombas! \n");
        for (int i = 0; i < caminho.length; i++) {
            if (caminho[i] == -1) {
                System.out.print(" B ");
            }
            if (caminho[i] == 0) {
                System.out.print(" _ ");
            }
        }
    }


    public static boolean bombaProx(int[] caminho, int escolha) {
        //função para indentificar a proximidade da bomba
        return (escolha > 0 && caminho[escolha - 1] == -1 || escolha < caminho.length - 1 && caminho[escolha + 1] == -1);
    }

    public static void jogarNovamente() {
        //sistema que reinicia o jogo
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDeseja jogar novamente?\n 1 - Sim\n 2 - Não");
        int op = scanner.nextInt();
        if (op == 1) {
            jogo();
        }
    }

    private static void jogo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Caminho Minado!");
        //tamanho que o caminho vai ter
        System.out.println("Qual tamanho o caminho terá?");
        int tamCaminho = scanner.nextInt();
        //bombas que vai ter no caminho
        System.out.println("Quantas bombas?");
        int qntBombas = scanner.nextInt();

        //impede que o caminho seja igual a zero e a quantidade de bombas maior que o caminho
        while (qntBombas <= 0 || qntBombas >= tamCaminho) {
            System.out.println("Valor inválido! O tamanho do caminho deve ser maior que 1 e a " +
                    "quantidade de bombas é maior que 0 e menor que o tamanho do caminho.");
            System.out.println("Tamanho do caminho: ");
            tamCaminho = scanner.nextInt();

            System.out.println("Quantidade de bombas:");
            qntBombas = scanner.nextInt();
        }

        int[] caminho = caminho(tamCaminho, qntBombas);
        int[] local = new int[tamCaminho];
        //todas as posições que não foram escolhidas são -2
        Arrays.fill(local, 0);

        int pontos = 0;
        boolean fim = false;

        do {
            mostraCaminho(caminho, local);

            System.out.println("\nEscolha a posição!: ");
            int posicao = scanner.nextInt();

            if (posicao < 0 || posicao >= tamCaminho || local[posicao] != 0) {
                System.out.println("Posição invalida.");
                continue;
            }

            if (caminho[posicao] == 0) {
                local[posicao] = 1;
                pontos++;
                if (bombaProx(caminho, posicao)) {
                    System.out.println("BOMBA PRÓXIMA!");
                }
            } else if (caminho[posicao] == -1) {
                local[posicao] = -1;
                fim = true;
            }
            if (pontos == tamCaminho - qntBombas) {
                fim = true;
            }
        } while (!fim);

        mostraCaminho(caminho, local);
        if (pontos == tamCaminho - qntBombas) {
            System.out.println("Você Ganhou!\n");
        } else System.out.println("Fim de jogo!\n");

        System.out.println("Pontos final: " + pontos + " de " + (tamCaminho - qntBombas));

        gabarito(caminho);
        jogarNovamente();
    }

    public static void main(String[] args) {
        jogo();

    }
}