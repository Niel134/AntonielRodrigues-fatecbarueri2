package lista;


public class Ponto2D {

    private double x;
    private double y;

    public Ponto2D() {
        this(0, 0);
    }

    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Ponto2D(Ponto2D outro) {
        this(outro.x, outro.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void mover() {
        mover(0, 0);
    }

    public void mover(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void mover(Ponto2D outro) {
        mover(outro.x, outro.y);
    }

    public double distancia(Ponto2D outro) {
        double dx = outro.x - this.x;
        double dy = outro.y - this.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public Ponto2D clone() {
        return new Ponto2D(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Ponto2D)) return false;

        Ponto2D outro = (Ponto2D) obj;

        return Double.compare(x, outro.x) == 0
            && Double.compare(y, outro.y) == 0;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

