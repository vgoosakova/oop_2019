public class Lab1 {
    public static void main(String[] args) {

        final long a = 4;
        final long b = 5;
        final int n = 8;
        final int m = 6;
        final int C = 2;
        float S = 0;


        if (a <= C && C <= n || b <= 0 && 0 <= m) {
            System.out.println("Ділення на нуль!!");
        }
        else {
            for (long i = a; i <= n; i++) {
                for (long j = b; j <= m; j++) {
                    S = S + (float) (i % j) / (i - C);
                }

            }
            System.out.println(S);
        }
    }
}
