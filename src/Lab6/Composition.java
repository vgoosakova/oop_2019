package Lab6;

public class Composition {
    private String name;
    private String artist;
    private double duration;
    private String style;

    public Composition(String name, String artist, double duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }


    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    public void setStyle(String style) {
        this.style = style;
    }


    public String getStyle() {
        return style;
    }
}
