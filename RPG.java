
import java.util.Scanner;

public class RPG {

    public static void menu() {
        //Menu principal do jogo
        Scanner scanner = new Scanner(System.in);
        int op;
        //Laço pra que a escolha esteja conforme as opções
        do {
            //menu
            System.out.println("");
            System.out.println("------------MENU ----------");
            System.out.println("-                         -");
            System.out.println("-      1 - Tutorial       -");
            System.out.println("-      2 -  Jogar         -");
            System.out.println("-      3 - Créditos       -");
            System.out.println("-      4 -  Sair          -");
            System.out.println("-                         -");
            System.out.println("---------------------------");

            System.out.println("Escolha uma opção:");
            op = scanner.nextInt();
            escolhaMenu(op);

        } while (op == 4);
    }

    public static void escolhaMenu(int op) {
        //Função que leva até as opções escolhidas
        switch (op) {
            case 1:
                System.out.println("Você escolheu Tutorial");
                tutorial();
                break;
            case 2:
                System.out.println("Você escolher Jogar");
                break;
            case 3:
                System.out.println("Você escolheu Créditos");
                break;
            case 4:
                System.out.println("Saindo");
                break;
        }
    }

    public static void tutorial() {
        //Tutorial do jogo
        int op;
        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("-        Tutorial          -");
        System.out.println("----------------------------");
        System.out.println("Olá, investigador, para que você não se sinta perdido nessa aventura" +
                " vou lhe passar algumas dicas e um breve contexto da história.");
        System.out.println("Você é um pesquisador a procura de um tesouro perdido. Seu destino são " +
                " os túneis subterrâneos da frança.");
        System.out.println("----------------------------");
        System.out.println("-          DICAS           -");
        System.out.println("----------------------------");
        do {
            //Laço para que o jogador entenda como funciona a seleção de opções
            Scanner scanner = new Scanner(System.in);
            System.out.println("Dica 1: Para fazer a seleção de suas ações digite sempre o valor mostrado" +
                    " em cada opção");
            System.out.println("1 - Próxima dica\n2 - explicar novamente");
            op = scanner.nextInt();
            if (op != 1 && op != 2){
                System.out.println("Digite um valor válido");
            }
        }while (op != 1);
        System.out.println("Dica 2: Sempre que as reticências (..) aparecerem você deve pressionar ENTER" +
                " para continuar...");
        //fazer com que o jogador utilize e entenda a função
        proximo();
        System.out.println("Boa, já está entendendo!");
        System.out.println("");
        System.out.println("Os desafios que você encontrará no caminho são sobre matematica, sendo " +
                " alguns deles questões de múltipla escolha e\noutros você deve selecionar valores " +
                " sorteados aleatoriamente, e escrever da melhor forma o total.");
        System.out.println("Para selecionar a opção serão dados alternativas de 1 a 4...");
        //fazer com que o jogador utilize e entenda a função
        proximo();
        System.out.println("Para cada teste você terá 2 tentativas para acertar.");
        System.out.println("Caso acerte, o jogo seguirá normalmente. Em caso de falha\n" +
                "será mostrado um aviso 'você falho' junto com a resposta do desafio...");
        //fazer com que o jogador utilize e entenda a função
        proximo();
        System.out.println("Caro investigador, venha conosco conhecer um novo ambiente!");
        System.out.println("--------APERTE ENTER--------");
        //última demonstração da função
        proximo();
        menu();
    }

    public static void proximo() {
        //Função que faz o skip com o ENTER
        Scanner scanner = new Scanner(System.in);
        String next;
        next = scanner.nextLine();
        if (next.isEmpty()) {
        }
    }

    public static void main(String[] args) {
        menu();
    }
}