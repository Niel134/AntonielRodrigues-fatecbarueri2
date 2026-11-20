package lista;


public class Reta {

    private double a;
    private double b;

    public Reta(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Reta(Ponto2D p1, Ponto2D p2) {

        if (Double.compare(p1.getX(), p2.getX()) == 0) {
            throw new IllegalArgumentException(
                "A reta vertical não pode ser representada por y = ax + b."
            );
        }

        this.a = (p2.getY() - p1.getY())
                / (p2.getX() - p1.getX());

        this.b = p1.getY() - this.a * p1.getX();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public boolean contem(Ponto2D ponto) {

        double esperado = a * ponto.getX() + b;

        return Math.abs(esperado - ponto.getY()) < 1e-9;
    }

    public Ponto2D intersecao(Reta outra) {

        if (Math.abs(this.a - outra.a) < 1e-12) {
            return null;
        }

        double x = (outra.b - this.b)
                / (this.a - outra.a);

        double y = this.a * x + this.b;

        return new Ponto2D(x, y);
    }

    @Override
    public String toString() {

        String sinal = b < 0 ? " - " : " + ";

        return "y = " + a + "x" + sinal + Math.abs(b);
    }
}

}
