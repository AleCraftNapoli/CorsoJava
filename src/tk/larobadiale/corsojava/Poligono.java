package tk.larobadiale.corsojava;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Poligono implements Confrontabile {
    protected DecimalFormat df;
    private int sideNum;

    protected Poligono(int sideNumber) {
        this.sideNum = sideNumber;
        df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.HALF_UP);
    }

    public int getSideNum() {
        return sideNum;
    }

    public String round(double num) {
        return df.format(num);
    }

    public void printData() {
        System.out.println("[Poligono]");
        System.out.println("-Numero Lati: " + sideNum);
        System.out.println();
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

}
