import java.util.Random;
import java.util.Scanner;

public class jogo {

    public static int valor() {
        Random random = new Random();

        return random.nextInt(100) + 1;
    }

    public static void jogoCompleto() {
        Scanner scanner = new Scanner(System.in);
        int tentativa = 0, aleatorio = valor(), palpite;

        System.out.println("\nUm valor aleatorio entre 1 e 100 foi sorteado. Você tem 5 tentativas de acertar!");

        do {
            tentativa++;

            System.out.println("\nTentativa " + tentativa + " Digite seu palpite:");
            palpite = scanner.nextInt();

            if (palpite + 1 == aleatorio || palpite - 1 == aleatorio) {
                System.out.println("TÁ QUENTE!");
            } else if (palpite > aleatorio) {
                System.out.println("\nO valor sorteado é menor que " + palpite);
            } else if (palpite < aleatorio) {
                System.out.println("\nO valor sorteado é maior que " + palpite);
            }

        } while (tentativa < 5 && palpite != aleatorio);

        if (palpite == aleatorio) {
            System.out.println("\nParabéns você ganhou!");
        } else System.out.println("\nGame Over!\nO valor correto era " + aleatorio);
        jogarNovamente();
    }

    public static void jogarNovamente() {

        Scanner scanner = new Scanner(System.in);
        int escolha;
        System.out.println("\nDeseja jogar novamente?\n" +
                "----------------------------------------" +
                "\n             1 - Sim " +
                "\n             2 - Não\n" +
                "----------------------------------------");
        escolha = scanner.nextInt();
        if (escolha == 1) {
            jogoCompleto();
        } else System.out.println("Obrigado, até a próxima");
    }

    public static void main(String[] args) {
        jogoCompleto();
        jogarNovamente();
    }
}