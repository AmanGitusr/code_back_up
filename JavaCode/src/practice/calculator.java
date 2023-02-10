package practice;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int first = in.nextInt();
        System.out.print("Enter the second number: ");
        int second = in.nextInt();
        System.out.println("Which operation do you want perform?");
        System.out.println("1. Addtion");
        System.out.println("2. Substraction");
        System.out.println("3. Multiple");
        System.out.println("4. Division");
        int input = in.nextInt();
        double result;
        switch (input) {
            case 1:
                result = first + second;
                System.out.println("Result: " + result);
                break;
            case 2:
                result = first - second;
                System.out.println("Result: " + result);
                break;
            case 3:
                result = first * second;
                System.out.println("Result: " + result);
                break;
            case 4:
                try {
                    result = first / second;
                    System.out.println("Result: " + result);
                    break;
                } catch (ArithmeticException ex) {
                    System.out.println("Can't divided by the zero!");
                }
                break;
            default:
                System.out.println("Your enter something wrong!");
                break;
        }
    }
}
