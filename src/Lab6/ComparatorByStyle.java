package Lab6;
import java.util.Comparator;

public class ComparatorByStyle implements Comparator<Composition> {

    @Override
    public int compare(Composition o1, Composition o2) {
        return Integer.compare(o1.getTotalDuration(), o2.getTotalDuration());
    }
}
