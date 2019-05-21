package Lab6;
import java.util.Arrays;

public class Album {
    private int numOfCompositions;
    private Composition[] compositions;
    private int counter = 0;
    private int albumTotalDuration = 0;


    public Album(int numOfCompositions) {
        this.numOfCompositions = numOfCompositions;
        compositions = new Composition[numOfCompositions];
    }

    public void addAllofme(String name, String style ,  double duration) {
        if (counter < numOfCompositions) {
            compositions[counter++] = new Allofme(name, style, duration);
        } else {
            System.out.println("Album size is exceeded!");
        }
    }

    public void addFly(String name, String style ,  double duration) {
        if (counter < numOfCompositions) {
            compositions[counter++] = new Fly(name, style, duration);
        } else {
            System.out.println("Album size is exceeded!");
        }
    }

    public void addFurElise(String name, String style ,  double duration) {
        if (counter < numOfCompositions) {
            compositions[counter++] = new FurElise(name, style, duration);
        } else {
            System.out.println("Album size is exceeded!");
        }
    }

    public int albumDuration(){
        for (Composition composition:compositions) {
            albumTotalDuration += composition.getTotalDuration();
        }
        return albumTotalDuration;
    }


    public void sortStyle() {
        Arrays.sort(compositions, new ComparatorByStyle());
    }

    public void findCompositionsWithDuration(double min, double max) {
        for (Composition composition : compositions) {
            if (composition.getDuration() >= min & composition.getDuration() <= max) {
                System.out.println(composition);
            }
        }
    }

    public Composition[] getCompositions() {
        return compositions;
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
