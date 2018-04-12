package tk.larobadiale.corsojava;

public class Rettangolo extends Parallelogramma {
    public Rettangolo(double base, double altezza) {
        super(base, altezza, 90, DEGREES);
    }

    @Override
    public double calculatePerimeter() {
        return 2*(base + altezza);
    }

    @Override
    public void printData() {
        System.out.println("[Rettangolo]");
        System.out.println("-Base: "    + round(base));
        System.out.println("-Altezza: " + round(altezza));
        System.out.println();
    }
}
