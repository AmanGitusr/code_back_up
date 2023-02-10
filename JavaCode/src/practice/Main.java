package practice;

import java.util.Arrays;


class Polynomial1 {
    public static void main(String[] args) {
        Polynomial1 p = new Polynomial1();
        p.setCoefficient(2, 4);
        p.setCoefficient(1,9);
        p.setCoefficient(3, 8);
        p.setCoefficient(0, 7);
        //p.print();

        Polynomial1 k = new Polynomial1();
        k.setCoefficient(2, 2);
        k.setCoefficient(1,1);
        k.setCoefficient(3, 3);
        k.setCoefficient(0, 9);
        //k.print();

        Polynomial1 c = p.add(k);
        System.out.println("ADD: ");
        c.print();
        System.out.println("Subtract");
        Polynomial1 f = p.subtract(k);
        f.print();

        System.out.println("Mulitply :");
        Polynomial1 d = p.multiply(k);
        d.print();
//        c.print();
//        p.print();
//        k.print();
    }

    /* This function sets coefficient for a particular degree value, if degree is not there in the Polynomial1
     *  then corresponding term with specified degree and value is added int the Polynomial1. If the degree
     *  is already present in the Polynomial1 then previous coefficient is replaced by
     *  new coefficient value passed as function argument
     */
    public int [] arr;
    public Polynomial1(){
        arr = new int [5];
    }
    public void setCoefficient(int degree, int coeff){

        if(degree >= arr.length){
            int len =(int) Math.ceil(degree / arr.length ) + 1 ;
            int [] temp = new int [(arr.length * len )];
            for(int i = 0 ; i<arr.length ; i++){
                temp[i] = arr[i];
            }
            arr = temp ;
        }
        arr[degree] = coeff;

    }

    // Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
    public  void print(){
        for(int i = 0 ; i< this.arr.length ; i++){
            if (arr[i] == 0) continue;
            System.out.print(this.arr[i]+"x"+i+" ");
        }
        System.out.println();

    }


    // Adds two Polynomial1s and returns a new Polynomial1 which has result
    public Polynomial1 add(Polynomial1 p){
        Polynomial1 temp = new Polynomial1();
        int min = Math.min(this.arr.length , p.arr.length );
        int max = Math.max(this.arr.length , p.arr.length );
        int count = 1 ;
        for(int i = 0 ; i < min ; i++){
            temp.setCoefficient(i, this.arr[i] + p.arr[i]);
            count++;
        }
        if(this.arr.length > count){
            for(int i = count - 1 ; i< max ; i++){
                temp.setCoefficient(i, this.arr[i]);
            }
        }
        if(p.arr.length > count){
            for(int i = count - 1 ; i< max ; i++){
                temp.setCoefficient(i, p.arr[i]);
            }
        }
        return temp;

    }

    // Subtracts two Polynomial1s and returns a new Polynomial1 which has result
    public Polynomial1 subtract(Polynomial1 p){
        Polynomial1 temp = new Polynomial1();
        int min = Math.min(this.arr.length , p.arr.length );
        int max = Math.max(this.arr.length , p.arr.length );
        int count = 1 ;
        for(int i = 0 ; i < min ; i++){
            temp.setCoefficient(i, this.arr[i] - p.arr[i]);
            count++;
        }
        if(this.arr.length > count){
            for(int i = count - 1 ; i< max ; i++){
                temp.setCoefficient(i, this.arr[i]);
            }
        }
        if(p.arr.length > count){
            for(int i = count - 1 ; i< max ; i++){
                temp.setCoefficient(i, -p.arr[i]);
            }
        }
        return temp;


    }
    public int getCoeff(int degree){
        if(degree < this.arr.length){
            return arr[degree];
        }
        else{
            return 0;
        }
    }

    // Multiply two Polynomial1s and returns a new Polynomial1 which has result

    public Polynomial1 multiply(Polynomial1 p){
            Polynomial1 temp = new Polynomial1();
           // int curr = 0;
            for(int i = 0 ; i < this.arr.length ; i++){
                if (this.arr[i] == 0) continue;
                for(int j = 0 ; j < p.arr.length ; j++){
                    int curr = 0 ;
                   if(p.arr[j] == 0) continue;
                   if((temp.arr.length > i+j) && temp.arr[i+j] != 0){
                       curr = temp.arr[i+j];
                   }

                    curr += this.arr[i] * p.arr[j];


                    temp.setCoefficient(i+j, curr);

                }
            }
            return temp;
    }

}
/*public class Main {
    public static void main(String[] args) {
        String str = "222.111..111.111";
        String[] s = str.split("\\.");
        System.out.println(Arrays.toString(s));


    }


        public static boolean isAnagram(String s, String t) {
            int[] f = new int[26];
            for (char ch : s.toCharArray()) {
                f[ch - 'a']++;
            }
            for (char ch : t.toCharArray()) {
                f[ch - 'a']--;
            }
            int count = 0;
            for (int a : f) {
                count += a;
            }
            return count == 0;
        }

    public static int findPivot(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;

        while(s < e) {
            if (arr[mid] >= arr[0]) {
                s = mid + 1;
            }else {
                e = mid;
            }

            mid = s + (e - s) / 2;
        }
        int target = arr[s];
        return target;
    }
}

 */
