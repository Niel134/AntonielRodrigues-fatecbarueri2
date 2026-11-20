package lista;


public class Pais {

    private String codigoISO;
    private String nome;
    private long populacao;
    private double dimensao;

    private Pais[] fronteiras = new Pais[40];
    private int quantidadeFronteiras = 0;

    public Pais(String codigoISO, String nome, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        setDimensao(dimensao);
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        if (populacao < 0) {
            throw new IllegalArgumentException();
        }

        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        if (dimensao < 0) {
            throw new IllegalArgumentException();
        }

        this.dimensao = dimensao;
    }

    public boolean equals(Pais outro) {
        return outro != null
                && codigoISO.equalsIgnoreCase(outro.codigoISO);
    }

    public boolean adicionarFronteira(Pais outro) {

        if (outro == null || equals(outro)
                || fazFronteiraCom(outro)
                || quantidadeFronteiras == fronteiras.length) {
            return false;
        }

        fronteiras[quantidadeFronteiras++] = outro;

        return true;
    }

    public boolean fazFronteiraCom(Pais outro) {

        if (outro == null) return false;

        for (int i = 0; i < quantidadeFronteiras; i++) {

            if (fronteiras[i].equals(outro)) {
                return true;
            }
        }

        return false;
    }

    public double densidadePopulacional() {

        if (dimensao == 0) return 0;

        return populacao / dimensao;
    }

    public Pais[] vizinhosComuns(Pais outro) {

        Pais[] temporario = new Pais[40];
        int total = 0;

        if (outro == null) return new Pais[0];

        for (int i = 0; i < quantidadeFronteiras; i++) {

            Pais candidato = fronteiras[i];

            if (outro.fazFronteiraCom(candidato)) {
                temporario[total++] = candidato;
            }
        }

        Pais[] resultado = new Pais[total];

        System.arraycopy(
            temporario, 0, resultado, 0, total
        );

        return resultado;
    }

    @Override
    public String toString() {
        return nome + " (" + codigoISO + ")";
    }
}

