//Write the program to print n prime number.

package practice;

public class PrimeNumber {
    public static void main(String[] args) {
        int range=50,i=2;
        while(i<=range){
            int k=i/2;
            int count=0;
            for(int j=2;j<=k;j++){
                if(i%j==0)
                    count++;
            }
            if(count==0){
                System.out.print(i+" , ");
            }
            i++;
        }

//        int  result, count = 0;
//        int n = 2, i = 20;
//        while (i>n) {
//            for (int j=2; j<=n; j++) {
//                result = n % j;
//                if (result==0)
//                    count++;
//            }
//            if (count==1)
//                System.out.print(n + " , ");
//            n++;
//        }

    }
}
