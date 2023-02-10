package practice;

import java.util.Scanner;

public class PolynomialUse {
    public static void main(String[] args) {
        Polynomial p = new Polynomial();
        p.setCoefficient(2, 4);
        p.setCoefficient(1, 9);
        p.setCoefficient(3, 8);
        p.setCoefficient(0, 7);
        //p.print();

        Polynomial k = new Polynomial();
        k.setCoefficient(2, 2);
        k.setCoefficient(1, 1);
        k.setCoefficient(3, 3);
        k.setCoefficient(0, 9);
        //k.print();

        Polynomial c = p.add(k);
        System.out.println("ADD: ");
        c.print();
        System.out.println("Subtract");
        Polynomial f = p.subtract(k);
        f.print();

        System.out.println("Mulitply :");
        Polynomial d = p.multiply(k);
        d.print();
//        c.print();
//        p.print();
//        k.print();
    }
}
