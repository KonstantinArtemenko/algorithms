package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(countFibonacci(3));
    }

    private static int countFibonacci(int n) {
        if (n==1) {
            return 1;
        } else if (n==0) {
            return 1;
        } else if (n>1) {
            return countFibonacci(n-1)+countFibonacci(n-2);
        }
        return -1;
    }
}
