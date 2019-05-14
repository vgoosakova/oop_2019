package Lab5;

public class Letter {
    private char aChar;

        Letter(char aChar) {
            this.aChar = aChar;
        }

        public static void output(int palindromeStart, int i) {
            System.out.println("output");


        }

        @Override
        public String toString() {
            return aChar + "";
        }

        char getaChar() {
            return aChar;
        }
}
