package tk.larobadiale.corsojava;

public class Main {

    public static void main(String[] args) {
        Trapezio t = new Trapezio(6, 2, 45, 63.4349488229, Confrontabile.DEGREES);
        t.printData();

        t = new Parallelogramma(6, 4, 90, Confrontabile.DEGREES);
        t.printData();

        t = new Rettangolo(6, 4);
        t.printData();
    }
}
