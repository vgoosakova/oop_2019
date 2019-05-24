package Lab6;

public class Jazz extends Composition {
    public Jazz(String name, String artist, double duration) {

        super(name, artist, duration);
        this.setStyle("Jazz");

    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " |"
                + " artist: " + this.getArtist() + " |"
                + " style: " + this.getStyle() + " |"
                + " duration: " + this.getDuration();
    }
}
