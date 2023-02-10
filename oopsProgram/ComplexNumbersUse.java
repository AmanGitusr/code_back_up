package oopsProgram;

public class ComplexNumbersUse {
    public static void main(String[] args) {
        ComplexNumbers fcn = new ComplexNumbers(23, 56);
        ComplexNumbers scn = new ComplexNumbers(45, 34);
        fcn.add(scn);
        fcn.print();
        scn.add(fcn);
        scn.print();
    }
}
