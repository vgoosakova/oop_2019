package Lab6;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composition that = (Composition) o;
        return Double.compare(that.getDuration(), getDuration()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getArtist(), that.getArtist()) &&
                Objects.equals(getStyle(), that.getStyle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getArtist(), getDuration(), getStyle());
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
