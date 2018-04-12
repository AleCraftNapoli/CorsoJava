package tk.larobadiale.corsojava;

public class Parallelogramma extends Trapezio {

    public Parallelogramma(double base, double altezza, double angoloSx, int unit) {
        super(base, altezza, angoloSx, 180 - angoloSx, unit);

        if      (angoloSx > 90) latoSx = latoDx;
        else if (angoloSx < 90) latoDx = latoSx;
    }

    @Override
    public double calculateArea() {
        return base*altezza;
    }

    @Override
    public double calculatePerimeter() {
        return 2*(base + latoSx);
    }

    @Override
    public void printData() {
        System.out.println("[Parallelogramma]");
        System.out.println("-Base: "    + round(base));
        System.out.println("-Altezza: " + round(altezza));
        System.out.println("-Lato: "  + round(latoSx));
        System.out.println("-AngoloA: " + round(Math.toDegrees(angoloA)) + "°");
        System.out.println("-AngoloB: " + round(Math.toDegrees(angoloB)) + "°");
        System.out.println();
    }
}
