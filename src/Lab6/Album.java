package Lab6;

import java.util.Arrays;
import java.util.Comparator;

public class Album {
    private int numOfCompositions;
    private Composition[] compositions;
    private int counter = 0;
    private double albumTotalDuration = 0;


    public Album(int numOfCompositions) {
        this.numOfCompositions = numOfCompositions;
        compositions = new Composition[numOfCompositions];
    }

    public void addRock(String name, String artist, double duration) {
        if (counter < numOfCompositions) {
            compositions[counter++] = new Rock(name, artist, duration);
        } else {
            System.out.println("Album size is exceeded!");
        }
    }

    public void addPop(String name, String artist, double duration) {
        if (counter < numOfCompositions) {
            compositions[counter++] = new Pop(name, artist, duration);
        } else {
            System.out.println("Album size is exceeded!");
        }
    }

    public void addJazz(String name, String artist, double duration) {
        if (counter < numOfCompositions) {
            compositions[counter++] = new Jazz(name, artist, duration);
        } else {
            System.out.println("Album size is exceeded!");
        }
    }

    public double albumDuration() {
        for (Composition composition : compositions) {
            albumTotalDuration += composition.getDuration();
        }
        return albumTotalDuration;
    }


    public void sortStyle() {
        Arrays.sort(compositions, Comparator.comparing(Composition::getStyle));

    }

    public void findCompositionsWithDuration(double min, double max) {
        for (Composition composition : compositions) {
            if (composition.getDuration() >= min & composition.getDuration() <= max) {
                System.out.println(composition);
            }
        }
    }

    @Override
    public String toString() {
        String res = "Album of compositions contains " + counter + " composition with total duration: " + "\n";
        for (int i = 0; i < counter; i++) {
            res += compositions[i].toString() + '\n';
        }
        return res;
    }
}
