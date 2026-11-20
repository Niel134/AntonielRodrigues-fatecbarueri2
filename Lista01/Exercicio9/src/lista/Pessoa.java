package lista;


public class Pessoa {

    private String nome;
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa(String nome, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.pai = pai;
        this.mae = mae;
    }

    public Pessoa(String nome) {
        this(nome, null, null);
    }

    public String getNome() {
        return nome;
    }

    public Pessoa getPai() {
        return pai;
    }

    public Pessoa getMae() {
        return mae;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }

    public boolean equals(Pessoa outra) {

        if (outra == null) return false;

        boolean mesmaMae;

        if (mae == null || outra.mae == null) {
            mesmaMae = mae == outra.mae;
        } else {
            mesmaMae = mae.nome.equalsIgnoreCase(outra.mae.nome);
        }

        return nome.equalsIgnoreCase(outra.nome)
                && mesmaMae;
    }

    public boolean ehIrma(Pessoa outra) {

        if (outra == null || this == outra) {
            return false;
        }

        boolean mesmoPai = pai != null
                && outra.pai != null
                && pai.nome.equalsIgnoreCase(outra.pai.nome);

        boolean mesmaMae = mae != null
                && outra.mae != null
                && mae.nome.equalsIgnoreCase(outra.mae.nome);

        return mesmoPai || mesmaMae;
    }

    public boolean ehAntecessoraDe(Pessoa pessoa) {

        if (pessoa == null) return false;

        return procurarAntecessor(pessoa.pai, this)
            || procurarAntecessor(pessoa.mae, this);
    }

    private boolean procurarAntecessor(
            Pessoa atual, Pessoa procurada) {

        if (atual == null) return false;

        if (atual == procurada) return true;

        return procurarAntecessor(atual.pai, procurada)
            || procurarAntecessor(atual.mae, procurada);
    }

    @Override
    public String toString() {
        return nome;
    }
}

