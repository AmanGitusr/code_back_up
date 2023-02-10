package oopsProgram;

public class ComplexNumbers {
    private int real;
    private int img;

    public ComplexNumbers(int real, int img) {
        this.real = real;
        this.img = img;
    }

    public void add(ComplexNumbers c) {
        int newReal = this.real + c.real;
        int newImg = this.img + c.img;
        this.real = newReal;
        this.img = newImg;
    }

    public void multiply(ComplexNumbers c) {
        int newReal = this.real * c.real;
        int newImg = this.img * c.img;
        this.real = newReal;
        this.img = newImg;
    }

    public void print() {
        System.out.println(this.real + " + i" + this.img);
    }
}
