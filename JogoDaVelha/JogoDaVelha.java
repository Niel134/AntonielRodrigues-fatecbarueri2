package jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {

    private static char[][] tabuleiro = new char[3][3];
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        char jogadorAtual = 'X';
        boolean terminou = false;

        inicializarTabuleiro();

        System.out.println("================================");
        System.out.println("         JOGO DA VELHA");
        System.out.println("================================");

        while (!terminou) {

            exibirTabuleiro();

            System.out.println("\nVez do jogador " + jogadorAtual);

            realizarJogada(jogadorAtual);

            if (verificarVitoria(jogadorAtual)) {

                exibirTabuleiro();
                System.out.println("\nO jogador " + jogadorAtual + " venceu!");
                terminou = true;

            } else if (tabuleiroCompleto()) {

                exibirTabuleiro();
                System.out.println("\nA partida terminou empatada!");
                terminou = true;

            } else {

                jogadorAtual = trocarJogador(jogadorAtual);
            }
        }

        System.out.println("\nFim de jogo!");
        entrada.close();
    }

    public static void inicializarTabuleiro() {

        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = ' ';
            }
        }
    }

    public static void exibirTabuleiro() {

        System.out.println("\n    1   2   3");
        System.out.println("  +---+---+---+");

        for (int linha = 0; linha < 3; linha++) {

            System.out.print((linha + 1) + " |");

            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(" " + tabuleiro[linha][coluna] + " |");
            }

            System.out.println();
            System.out.println("  +---+---+---+");
        }
    }

    public static void realizarJogada(char jogador) {

        int linha;
        int coluna;

        while (true) {

            linha = lerNumero("Jogador " + jogador + ", informe a linha (1 a 3): ");
            coluna = lerNumero("Jogador " + jogador + ", informe a coluna (1 a 3): ");

            if (!posicaoValida(linha, coluna)) {

                System.out.println("Posição inválida! Digite valores entre 1 e 3.\n");

            } else if (tabuleiro[linha - 1][coluna - 1] != ' ') {

                System.out.println("Essa posição já está ocupada. Escolha outra posição.\n");

            } else {

                tabuleiro[linha - 1][coluna - 1] = jogador;
                break;
            }
        }
    }

    public static int lerNumero(String mensagem) {

        while (true) {

            System.out.print(mensagem);
            String valor = entrada.nextLine();

            try {
                return Integer.parseInt(valor.trim());

            } catch (NumberFormatException erro) {

                System.out.println("Entrada inválida! Digite um número inteiro.\n");
            }
        }
    }

    public static boolean posicaoValida(int linha, int coluna) {

        return linha >= 1 && linha <= 3
                && coluna >= 1 && coluna <= 3;
    }

    public static boolean verificarVitoria(char jogador) {

        // Verifica as linhas.
        for (int linha = 0; linha < 3; linha++) {

            if (tabuleiro[linha][0] == jogador
                    && tabuleiro[linha][1] == jogador
                    && tabuleiro[linha][2] == jogador) {

                return true;
            }
        }

        // Verifica as colunas.
        for (int coluna = 0; coluna < 3; coluna++) {

            if (tabuleiro[0][coluna] == jogador
                    && tabuleiro[1][coluna] == jogador
                    && tabuleiro[2][coluna] == jogador) {

                return true;
            }
        }

        // Verifica a diagonal principal.
        if (tabuleiro[0][0] == jogador
                && tabuleiro[1][1] == jogador
                && tabuleiro[2][2] == jogador) {

            return true;
        }

        // Verifica a diagonal secundária.
        if (tabuleiro[0][2] == jogador
                && tabuleiro[1][1] == jogador
                && tabuleiro[2][0] == jogador) {

            return true;
        }

        return false;
    }

    public static boolean tabuleiroCompleto() {

        for (int linha = 0; linha < 3; linha++) {

            for (int coluna = 0; coluna < 3; coluna++) {

                if (tabuleiro[linha][coluna] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public static char trocarJogador(char jogadorAtual) {

        if (jogadorAtual == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }
}

