package Lab5;

public class Main {
    public static void main(String[] args) {
        String plot = "The Original Series began in 1864 and continues to the present." +
                "In 1867 an Extra Series was started, of texts already printed " +
                "but not in satisfactory or readily obtainable editions." +
                "In 1921 the Extra Series was discontinued and all publications were subsequently " +
                "listed and numbered as part of the Original Series. Was it a car or a cat I saw?";

        Text text = new Text(plot);
        System.out.println(text.largestPalindrome());
    }
}