package Lab6;

public class Rock extends Composition {
    public Rock(String name, String artist, double duration) {

        super(name, artist, duration);
        this.setStyle("Rock");

    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " |"
                + " artist: " + this.getArtist() + " |"
                + " style: " + this.getStyle() + " |"
                + " duration: " + this.getDuration();
    }
}
