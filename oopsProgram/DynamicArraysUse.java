package oopsProgram;

public class DynamicArraysUse {
    public static void main(String[] args) {
        DynamicArrays str = new DynamicArrays();
        for (int i = 20; i >= 1; i--)
            str.add(i);

        str.print();
        //str.set(15, 66);
        str.sorted();
        str.print();
        System.out.println(str.get(4));

//        while (!str.isEmpty()) {
//            System.out.println(str.removeLast());
//            System.out.println("Size : " + str.size());
//        }
    }
}
