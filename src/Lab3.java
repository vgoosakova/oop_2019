import java.util.Scanner;

public class Lab3 {

    private static boolean isPallindrom(String[] a) {
        int q = a.length;
        for (int i = 0; i < q / 2; i++) {
            if (!a[i].equals(a[q - i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строчку в которой есть палиндромы: ");

        String[] x = scanner.nextLine().split("");

        int len = x.length;

        String a;

        exitlabel:
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i + 1; j++) {
                a = "";
                for (int k = j; k < len - i + j; k++) {
                    a+=(x[k]);
                }
                if (isPallindrom(a.split(""))) {
                    System.out.print(a + " первый самый длинный палиндром!");
                    break exitlabel;
                }
            }
        }
    }
}
//око за око лазер резал