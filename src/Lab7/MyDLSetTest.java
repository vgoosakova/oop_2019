package Lab7;

import Lab6.Album;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.Iterator;

class MyDLSetTest {

    private MyDLSet set;
    private Album album;
    private Album albumSecond;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        album = new Album(3);

        album.addRock("Highway to hell", "AC/DC", 1.5);
        album.addPop("Angel", "The Alice Band", 3.7);
        album.addJazz("Bye-Bye", "Freedom Jazz", 4);

        albumSecond = new Album(3);

        albumSecond.addRock("Highway to hell", "AC/DC", 1.5);
        albumSecond.addJazz("Bye-Bye", "Freedom Jazz", 4);
        albumSecond.addJazz("Bye-Bye", "Freedom Jazz", 4);

        set = new MyDLSet(album);

        System.out.println("Set up new album ...");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("... tear down\n");
    }

    @org.junit.jupiter.api.Test
    void size() {
        Assertions.assertEquals(1, set.size());

        System.out.println("    size() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        MyDLSet empty = new MyDLSet();

        Assertions.assertTrue(empty.isEmpty());
        Assertions.assertFalse(set.isEmpty());

        System.out.println("    empty() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void contains() {
        Assertions.assertTrue(set.contains(album));

        Assertions.assertFalse(set.contains(albumSecond));

        System.out.println("    contains() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        Iterator iter = set.iterator();
        Assertions.assertEquals(album, iter.next());
        Assertions.assertFalse(iter.hasNext());

        System.out.println("    iterator() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void toArray() {
        Object[] array = { album };

        Assertions.assertEquals(array[0], set.toArray()[0]);

        System.out.println("    toArray() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void toArray1() {
        Album[] albums = new Album[1];
        Album[] albumSet = set.toArray(albums);

        Assertions.assertEquals(albumSet.length, set.size());
        Assertions.assertEquals(albumSet[0], set.toArray()[0]);

        System.out.println("    toArray1() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void add() {
        set.add(albumSecond);

        Assertions.assertEquals(2, set.size());
        Assertions.assertTrue(set.contains(albumSecond));

        System.out.println("    add() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void remove() {
        set.remove(album);

        Assertions.assertFalse(set.contains(album));
        Assertions.assertEquals(0, set.size());

        System.out.println("    remove() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void containsAll() {
        ArrayList<Album> list = new ArrayList<>();
        list.add(albumSecond);

        Assertions.assertFalse(set.containsAll(list));

        System.out.println("    containsAll() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void addAll() {
        ArrayList<Album> list = new ArrayList<>();
        list.add(albumSecond);

        set.addAll(list);

        Assertions.assertEquals(2, set.size());
        Assertions.assertTrue(set.contains(albumSecond));


        System.out.println("    addAll() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void retainAll() {
        ArrayList<Album> list = new ArrayList<>();

        set.retainAll(list);

        Assertions.assertFalse(set.contains(album));
        Assertions.assertEquals(0, set.size());

        System.out.println("    retainAll() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void removeAll() {
        ArrayList<Album> list = new ArrayList<>();
        list.add(albumSecond);

        set.removeAll(list);

        Assertions.assertTrue(set.contains(album));
        Assertions.assertEquals(1, set.size());

        System.out.println("    removeAll() -> Success!");
    }

    @org.junit.jupiter.api.Test
    void clear() {
        set.clear();

        Assertions.assertEquals(0, set.size());
        //Assertions.assertFalse(set.contains(album));

        System.out.println("    clear() -> Success!");
    }
}