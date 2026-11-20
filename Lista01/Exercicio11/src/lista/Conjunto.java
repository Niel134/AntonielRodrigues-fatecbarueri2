package lista;


import java.util.Arrays;

public class Conjunto {

    private String[] elementos;
    private int tamanho;

    public Conjunto() {
        elementos = new String[4];
        tamanho = 0;
    }

    public boolean adicionar(String elemento) {

        if (elemento == null || pertence(elemento)) {
            return false;
        }

        if (tamanho == elementos.length) {

            elementos = Arrays.copyOf(
                elementos, elementos.length * 2
            );
        }

        elementos[tamanho++] = elemento;

        return true;
    }

    public boolean pertence(String elemento) {

        for (int i = 0; i < tamanho; i++) {

            if (elementos[i].equals(elemento)) {
                return true;
            }
        }

        return false;
    }

    public Conjunto uniao(Conjunto outro) {

        Conjunto resultado = new Conjunto();

        for (int i = 0; i < tamanho; i++) {
            resultado.adicionar(elementos[i]);
        }

        if (outro != null) {

            for (int i = 0; i < outro.tamanho; i++) {
                resultado.adicionar(outro.elementos[i]);
            }
        }

        return resultado;
    }

    public Conjunto inter(Conjunto outro) {

        Conjunto resultado = new Conjunto();

        if (outro == null) return resultado;

        for (int i = 0; i < tamanho; i++) {

            if (outro.pertence(elementos[i])) {
                resultado.adicionar(elementos[i]);
            }
        }

        return resultado;
    }

    public Conjunto menos(Conjunto outro) {

        Conjunto resultado = new Conjunto();

        for (int i = 0; i < tamanho; i++) {

            if (outro == null || !outro.pertence(elementos[i])) {
                resultado.adicionar(elementos[i]);
            }
        }

        return resultado;
    }

    @Override
    public String toString() {
        return Arrays.toString(
            Arrays.copyOf(elementos, tamanho)
        );
    }
}

