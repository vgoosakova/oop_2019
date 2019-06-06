package Lab7;

import Lab6.Album;

public class MySetCheck {
    public static void main(String[] args) {
        System.out.println("=======ALBUMS=======");

        Album albumAlone = new Album(3);

        albumAlone.addRock("Highway to hell", "AC/DC", 1.5);
        albumAlone.addPop("Angel", "The Alice Band", 3.7);
        albumAlone.addJazz("Bye-Bye", "Freedom Jazz", 4);

        Album albumSecond = new Album(3);

        albumSecond.addRock("Highway to hell", "AC/DC", 1.5);
        albumSecond.addJazz("Bye-Bye", "Freedom Jazz", 4);
        albumSecond.addJazz("Bye-Bye", "Freedom Jazz", 4);

        // Check if set does not add similar object
        Album albumThird = new Album(3);

        albumThird.addRock("Highway to hell", "AC/DC", 1.5);
        albumThird.addJazz("Bye-Bye", "Freedom Jazz", 4);
        albumThird.addJazz("Bye-Bye", "Freedom Jazz", 4);

        MyDLSet setMult = new MyDLSet(albumSecond);
        setMult.add(albumAlone);
        setMult.add(albumSecond); // Should not add!

        for (Album album : setMult) {
            System.out.println(album);
        }

    }
}
