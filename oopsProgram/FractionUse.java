package oopsProgram;

public class FractionUse {
    public static void main(String[] args) {
        Fraction fs = new Fraction(30, 20);
//        fs.print();
        Fraction ss = new Fraction(30, 20);
//        Fraction.add(fs, ss).print();
         fs.multiply(ss);
         fs.print();
    }
}
