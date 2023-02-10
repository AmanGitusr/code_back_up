package oopsProgram;

public class Fraction {
    private int numerator;
    private int denomirator;

    public Fraction(int numerator, int denomirator) {
        this.numerator = numerator;
        if (denomirator == 0)
            return;
        this.denomirator = denomirator;
        simplify();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public int getDenomirator() {
        return denomirator;
    }

    public void setDenomirator(int denomirator) {
        if (denomirator == 0)
            return;
        this.denomirator = denomirator;
        simplify();
    }

    private void simplify() {
        int gcd = 1;
        int min = Math.min(numerator, denomirator);
        for (int i = 1; i < min; i++)
            if (numerator % i == 0 && denomirator % i == 0)
                gcd = i;

        numerator = numerator / gcd;
        denomirator = denomirator / gcd;
    }

    public void print() {
        System.out.println(numerator + "/" + denomirator);
    }

    public static Fraction add(Fraction f, Fraction s) {
        int newNum = f.numerator * s.denomirator + s.numerator * f.denomirator;
        int newDen = f.denomirator * s.denomirator;
        Fraction ref = new Fraction(newNum, newDen);
        return ref;
    }

    public void add(Fraction ref) {
        this.numerator = this.numerator * ref.denomirator + this.denomirator * ref.numerator;
        denomirator = this.denomirator * ref.denomirator;
        simplify();
    }

    public void multiply(Fraction ref) {
        this.numerator = this.numerator * ref.numerator;
        this.denomirator = this.denomirator * ref.denomirator;
        simplify();
    }




}
