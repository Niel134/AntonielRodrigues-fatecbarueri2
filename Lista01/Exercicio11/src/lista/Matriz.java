package lista;


public class Matriz {

    private double[][] dados;
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {

        if (linhas <= 0 || colunas <= 0) {
            throw new IllegalArgumentException(
                "As dimensões devem ser positivas."
            );
        }

        this.linhas = linhas;
        this.colunas = colunas;

        dados = new double[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public double getElemento(int linha, int coluna) {
        return dados[linha][coluna];
    }

    public void setElemento(int linha, int coluna, double valor) {
        dados[linha][coluna] = valor;
    }

    public boolean equals(Matriz outra) {

        if (outra == null
                || linhas != outra.linhas
                || colunas != outra.colunas) {
            return false;
        }

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                if (Double.compare(
                        dados[i][j], outra.dados[i][j]) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public Matriz transposta() {

        Matriz resultado = new Matriz(colunas, linhas);

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                resultado.dados[j][i] = dados[i][j];
            }
        }

        return resultado;
    }

    public Matriz oposta() {

        Matriz resultado = new Matriz(linhas, colunas);

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                resultado.dados[i][j] = -dados[i][j];
            }
        }

        return resultado;
    }

    public Matriz nula() {
        return new Matriz(linhas, colunas);
    }

    public boolean ehIdentidade() {

        if (linhas != colunas) return false;

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                double esperado = i == j ? 1 : 0;

                if (Double.compare(
                        dados[i][j], esperado) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean ehDiagonal() {

        if (linhas != colunas) return false;

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                if (i != j && dados[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean ehSingular() {

        if (!ehDiagonal()) return false;

        double valor = dados[0][0];

        for (int i = 1; i < linhas; i++) {

            if (Double.compare(
                    dados[i][i], valor) != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean ehSimetrica() {

        return linhas == colunas
                && equals(transposta());
    }

    public boolean ehAntissimetrica() {

        if (linhas != colunas) return false;

        return oposta().equals(transposta());
    }

    public void somar(Matriz outra) {

        validarMesmasDimensoes(outra);

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                dados[i][j] += outra.dados[i][j];
            }
        }
    }

    public void subtrair(Matriz outra) {

        validarMesmasDimensoes(outra);

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                dados[i][j] -= outra.dados[i][j];
            }
        }
    }

    public void multiplicar(Matriz outra) {

        if (outra == null || colunas != outra.linhas) {

            throw new IllegalArgumentException(
                "Dimensões incompatíveis para multiplicação."
            );
        }

        Matriz resultado = new Matriz(
            linhas, outra.colunas
        );

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < outra.colunas; j++) {

                for (int k = 0; k < colunas; k++) {

                    resultado.dados[i][j] +=
                        dados[i][k] * outra.dados[k][j];
                }
            }
        }

        this.dados = resultado.dados;
        this.colunas = resultado.colunas;
    }

    private void validarMesmasDimensoes(Matriz outra) {

        if (outra == null
                || linhas != outra.linhas
                || colunas != outra.colunas) {

            throw new IllegalArgumentException(
                "As matrizes devem ter as mesmas dimensões."
            );
        }
    }

    public Matriz clone() {

        Matriz copia = new Matriz(linhas, colunas);

        for (int i = 0; i < linhas; i++) {

            System.arraycopy(
                dados[i], 0, copia.dados[i], 0, colunas
            );
        }

        return copia;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < linhas; i++) {

            sb.append("[");

            for (int j = 0; j < colunas; j++) {

                sb.append(dados[i][j]);

                if (j < colunas - 1) {
                    sb.append(", ");
                }
            }

            sb.append("]");

            if (i < linhas - 1) {
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
