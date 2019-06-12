package Lab7;

import Lab6.Album;

import java.util.*;

public class MyDLSet implements Set<Album> {

    private Node head;
    private Node tail;
    private int size;

    public MyDLSet() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public MyDLSet(Album someObj) {
        this.setHead(new Node(someObj));
        this.setTail(this.getHead());
        this.size = 1;
    }

    public MyDLSet(List<Album> someList) {
        Node prev, next;
        prev = new Node((Album) someList.toArray()[0]);
        this.setHead(prev);

        int size = 0;
        for (Album smth : someList.subList(1, this.size())) {
            next = new Node(smth);

            if (this.contains(next)) continue;
            ++size;
            prev.setNext(next);
            next.setPrevious(prev);
            prev = next;
        }

        this.setSize(size);
        this.setTail(prev);
    }

    private void setHead(Node node) { this.head = node; }
    private void setTail(Node node) { this.tail = node; }
    private void setSize(int size)  { this.size = size; }

    private Node getHead() { return this.head; }
    private Node getTail() { return this.tail; }

    private class Node {
        private Album data;
        private Node next = null;
        private Node previous = null;

        Node(Album album) {
            this.data = album;
        }

        Album getData() {
            return this.data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(getData(), node.getData());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getData());
        }

        void setNext(Node next) { this.next = next; }

        void setPrevious(Node previous) {
            this.previous = previous;
        }

        Node getNext() { return this.next; }

        Node getPrevious() { return this.previous; }

        @Override
        public String toString() { return this.getData().toString(); }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node next = this.getHead();
        while (next != null) {
            if (next.getData().equals(o)) { return true; }
            next = next.getNext();
        }

        return false;
    }

    private class MyDLSetIterator implements Iterator<Album> {
        Node current;

        // initialize pointer to head of the list for iteration
        MyDLSetIterator(MyDLSet myDLSet) {
            current = myDLSet.getHead();
        }

        // returns false if next element does not exist
        public boolean hasNext() {
            return current != null;
        }

        // return current data and update pointer
        public Album next() {
            Album data = current.getData();
            current = current.getNext();
            return data;
        }

        public void remove() {}
    }

    @Override
    public Iterator<Album> iterator() {
        return new MyDLSetIterator(this);
    }

    @Override
    public Object[] toArray() {
        Node next = this.getHead();
        Object[] arr = new Object[this.size()];
        int i = 0;

        while (next != null) {
            arr[i] = next.getData();
            next = next.getNext();
            ++i;
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (!(a instanceof Album[])) throw new ArrayStoreException();
        if (this.size() > a.length) { return  (T[]) this.toArray(); }

        int i = 0;
        for (Object obj : this.toArray()) {
            a[i] = (T) obj;
            ++i;
        }
        return a;
    }

    @Override
    public boolean add(Album album) {
        if (this.isEmpty()) {
            this.setHead(new Node(album));
            this.setSize(1);
            return true;
        }

        if (this.contains(album)) {
            System.out.println("    Only unique objects expected!\n");
            return false;
        }

        Node newTail = (new Node(album));

        this.getTail().setNext(newTail);
        newTail.setPrevious(tail);
        this.setTail(newTail);

        this.setSize(this.size() + 1);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (! this.contains(o)) { return false; }

        if (this.size() == 1) {
            this.getHead().setPrevious(null);
            this.getHead().setNext(null);
            this.getTail().setPrevious(null);
            this.getTail().setNext(null);

            this.setHead(null);
            this.setTail(null);
            this.setSize(0);
            return true;
        }

        if (this.indexOf(o) == 0) {
            this.setHead(this.getHead().getNext());
            this.getHead().setPrevious(null);
            this.setSize(this.size() - 1);
            return true;
        }

        if (this.lastIndexOf(o) == this.size()-1) {
            this.setTail(this.getTail().getPrevious());
            this.getTail().setNext(null);
            this.setSize(this.size() - 1);
            return true;
        }

        Node next = this.getHead();
        while (! next.getData().equals(o)) { next = next.getNext(); }

        Node newNext = next.getNext();
        Node newPrev = next.getPrevious();

        newNext.setPrevious(newPrev);

        newPrev.setNext(newNext);

        this.setSize(this.size() - 1);
        return true;
    }

    private int indexOf(Object o) {
        Node node = this.getHead();
        for (int i = 0; i < this.size(); ++i) {
            if (node.getData().equals(o)) { return i; }
            node = node.getNext();
        }
        return -1;
    }

    private int lastIndexOf(Object o) {
        Node node = this.getTail();
        for (int i = this.size()-1; i >= 0; --i) {
            if (node.getData().equals(o)) { return i; }
            node = node.getPrevious();
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (! this.contains(obj)) { return false; }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Album> c) {
        for (Object obj : c) { this.add((Album) obj); }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object t : this.toArray()) {
            if (! c.contains(t))
                this.remove(t);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object obj : c) {
            if (obj == null) break;
            this.remove(obj);
        }
        return true;
    }

    @Override
    public void clear() {
        this.getHead().setNext(this.getTail());
        this.getTail().setPrevious(this.getHead());
        this.setHead(null);
        this.setTail(null);
        this.setSize(0);
    }
}

