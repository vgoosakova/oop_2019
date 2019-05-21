package Lab6;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======ALBUM=======");
        Album album = new Album(3);
        album.addAllofme("Allofme", "jazz", 2);
        album.addFly("Fly", "pop", 4);
        album.addFurElise("FurElise", "lyrics",  3);
        System.out.print(album);
        System.out.println("Total Album Duration: " + album.albumDuration() + "\n");

        System.out.println("=========SORT=========");
        album.sortStyle();
        System.out.println(album);

        System.out.println("=========givenDuration=========");
        double from = 1;
        double to = 5;
        System.out.println("from: " + from + " === to: " + to);
        album.findCompositionsWithDuration(from, to);

    }

}