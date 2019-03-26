import java.util.Scanner;
public class Lab3 {
    public static void main(String[] args) {
        System.out.println("Input numbers divided by space");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] SS = str.split("\\s+");
        // \\s+ - many whitespaces
        // \\s - only one
        check(SS);

    }

    private static void check(String[] SS) {
        int longestOne = 0;
        String palindrome="";
        for(String s: SS){

            if(isPal(s)&&s.length()>longestOne){
                longestOne=s.length();
                palindrome = s;
            }

        }
        if(palindrome.equals("")){
            System.out.println("No palindrome in input numbers");
        } else
            System.out.println("Longest palindrome is: "+palindrome);
    }
    static boolean isPal(String s){
        return (s.equals(new StringBuilder(s).reverse().toString()));
    }
}