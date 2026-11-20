package lista;


public class Continente {

    private String nome;

    private Pais[] paises = new Pais[48];

    private int quantidade = 0;

    public Continente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean adicionarPais(Pais pais) {

        if (pais == null || quantidade == paises.length) {
            return false;
        }

        for (int i = 0; i < quantidade; i++) {

            if (paises[i].equals(pais)) {
                return false;
            }
        }

        paises[quantidade++] = pais;

        return true;
    }

    public double dimensaoTotal() {

        double total = 0;

        for (int i = 0; i < quantidade; i++) {
            total += paises[i].getDimensao();
        }

        return total;
    }

    public long populacaoTotal() {

        long total = 0;

        for (int i = 0; i < quantidade; i++) {
            total += paises[i].getPopulacao();
        }

        return total;
    }

    public double densidadePopulacional() {

        double area = dimensaoTotal();

        if (area == 0) return 0;

        return populacaoTotal() / area;
    }

    public Pais maiorPopulacao() {
        return extremo(true, true);
    }

    public Pais menorPopulacao() {
        return extremo(true, false);
    }

    public Pais maiorDimensao() {
        return extremo(false, true);
    }

    public Pais menorDimensao() {
        return extremo(false, false);
    }

    private Pais extremo(boolean porPopulacao, boolean maior) {

        if (quantidade == 0) return null;

        Pais escolhido = paises[0];

        for (int i = 1; i < quantidade; i++) {

            double atual = porPopulacao
                    ? paises[i].getPopulacao()
                    : paises[i].getDimensao();

            double valor = porPopulacao
                    ? escolhido.getPopulacao()
                    : escolhido.getDimensao();

            if ((maior && atual > valor)
                    || (!maior && atual < valor)) {

                escolhido = paises[i];
            }
        }

        return escolhido;
    }

    public double razaoTerritorialMaiorMenor() {

        Pais maior = maiorDimensao();
        Pais menor = menorDimensao();

        if (maior == null || menor == null
                || menor.getDimensao() == 0) {
            return 0;
        }

        return maior.getDimensao() / menor.getDimensao();
    }
}

