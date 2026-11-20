package lista;


public class NumeroComplexo {

    private double real;
    private double imaginaria;

    public NumeroComplexo(double real, double imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }

    public double getReal() {
        return real;
    }

    public double getImaginaria() {
        return imaginaria;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginaria(double imaginaria) {
        this.imaginaria = imaginaria;
    }

    public void somar(NumeroComplexo outro) {
        real += outro.real;
        imaginaria += outro.imaginaria;
    }

    public void subtrair(NumeroComplexo outro) {
        real -= outro.real;
        imaginaria -= outro.imaginaria;
    }

    public void multiplicar(NumeroComplexo outro) {
        double novaReal = real * outro.real
                - imaginaria * outro.imaginaria;

        double novaImaginaria = real * outro.imaginaria
                + imaginaria * outro.real;

        real = novaReal;
        imaginaria = novaImaginaria;
    }

    public void dividir(NumeroComplexo outro) {

        double denominador = outro.real * outro.real
                + outro.imaginaria * outro.imaginaria;

        if (denominador == 0) {
            throw new ArithmeticException(
                "Não é possível dividir por zero."
            );
        }

        double novaReal = (real * outro.real
                + imaginaria * outro.imaginaria) / denominador;

        double novaImaginaria = (imaginaria * outro.real
                - real * outro.imaginaria) / denominador;

        real = novaReal;
        imaginaria = novaImaginaria;
    }

    public double modulo() {
        return Math.sqrt(real * real
                + imaginaria * imaginaria);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof NumeroComplexo)) return false;

        NumeroComplexo outro = (NumeroComplexo) obj;

        return Double.compare(real, outro.real) == 0
            && Double.compare(imaginaria, outro.imaginaria) == 0;
    }

    @Override
    public String toString() {
        if (imaginaria < 0) {
            return real + " - " + Math.abs(imaginaria) + "i";
        }

        return real + " + " + imaginaria + "i";
    }
}

