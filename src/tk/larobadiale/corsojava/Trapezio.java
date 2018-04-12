package tk.larobadiale.corsojava;

public class Trapezio extends Quadrilatero {
    protected double base;
    private double base2;
    protected double altezza;
    protected double angoloA;
    protected double angoloB;
    private double angoloC;
    private double angoloD;
    protected double latoSx;
    protected double latoDx;

    public Trapezio(double base, double altezza, double angoloSx, double angoloDx, int unit) {
        super();
        this.base = base;
        this.altezza = altezza;

        if (unit == RADIANT) {
            this.angoloA = angoloSx;
            this.angoloB = angoloDx;
        }
        else if (unit == DEGREES) {
            this.angoloA = Math.toRadians(angoloSx);
            this.angoloB = Math.toRadians(angoloDx);
        }

        this.angoloC = Math.PI - this.angoloB;
        this.angoloD = Math.PI - this.angoloA;
        this.latoSx = this.altezza / Math.sin(this.angoloA);
        this.latoDx = this.altezza / Math.sin(this.angoloB);
        this.base2 = this.base - (latoSx*Math.cos(angoloA) + latoDx*Math.cos(angoloB));
    }

    @Override
    public double calculateArea() {
        return ((base + base2) * altezza) / 2;
    }

    @Override
    public double calculatePerimeter() {
        return base + base2 + latoSx + latoDx;
    }

    @Override
    public void printData() {
        System.out.println("[Trapezio]");
        System.out.println("-Base: "    + round(base));
        System.out.println("-Base2: "   + round(base2));
        System.out.println("-Altezza: " + round(altezza));
        System.out.println("-LatoSx: "  + round(latoSx));
        System.out.println("-LatoDx: "  + round(latoDx));
        System.out.println("-AngoloA: " + round(Math.toDegrees(angoloA)) + "°");
        System.out.println("-AngoloB: " + round(Math.toDegrees(angoloB)) + "°");
        System.out.println("-AngoloC: " + round(Math.toDegrees(angoloC)) + "°");
        System.out.println("-AngoloD: " + round(Math.toDegrees(angoloD)) + "°");
        System.out.println();
    }
}
