public class RecursionExample {
    public static void main(String[] args) {
        // printingNumber(10);
        System.out.println(recursionFactorial(4));

    }

    public static void printingNumber(int num) {
        if (num > 0) {
            System.out.println("The number before calling  : " + num);
            printingNumber(num - 1);
            System.out.println("The number after calling  : " + num);
        }
    }

    public static int factorial(int n) {
        var factorial = 1;
        for (int i = n; i > 1; i--) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static int recursionFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * recursionFactorial(n - 1);
    }
}
