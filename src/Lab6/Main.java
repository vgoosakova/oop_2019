package Lab6;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======ALBUM=======");
        Album album = new Album(3);

        album.addRock("Highway to hell", "AC/DC", 1.5);
        album.addPop("Angel", "The Alice Band", 3.7);
        album.addJazz("Bye-Bye", "Freedom Jazz", 4.3);


        System.out.print(album);
        System.out.println("Total Album Duration: " + album.albumDuration() + "\n");

        System.out.println("=========SORT=========");
        album.sortStyle();
        System.out.println(album);

        System.out.println("=========givenDuration=========");
        double from = 1;
        double to = 4;
        System.out.println("from: " + from + " === to: " + to);
        album.findCompositionsWithDuration(from, to);

    }

}