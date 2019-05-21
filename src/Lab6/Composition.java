package Lab6;

public class Composition {
    private String name;
    private String style;
    private double duration;
    private double totalDuration;

    public Composition (String name, String style, double duration) {
        this.name = name;
        this.style = style;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Name: " + name + " |"
                + " style: " + style + " |"
                + " duration: " + duration + " |"
                + " total duration: " + totalDuration;
    }


    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public double getDuration() {
        return duration;
    }
    public double getTotalDuration() {
        return totalDuration;
    }

}
