package DFS;

public class CalculateFactorialofn {
    public long factorial(int n) {
        // Write your solution here

        if(n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    public static void main(String[] args) {
        CalculateFactorialofn factorialofn = new CalculateFactorialofn();
        System.out.println(factorialofn.factorial(5));
    }

}
