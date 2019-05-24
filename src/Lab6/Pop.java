package Lab6;

public class Pop extends Composition {

    public Pop(String name, String artist, double duration) {

        super(name, artist, duration);
        this.setStyle("Pop");

    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " |"
                + " artist: " + this.getArtist() + " |"
                + " style: " + this.getStyle() + " |"
                + " duration: " + this.getDuration();
    }

}
