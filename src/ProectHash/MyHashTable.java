package ProectHash;

import java.util.Arrays;
import java.util.Objects;

public class MyHashTable<T> {



    public class Node<T> {


        private T key;
        private Node<T> next;

        public Node(T key ) {
            this.key = key;
            this.next = null;
        }

        public T getKey() {
            return key;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }


    private Node<T>[] table;
    private int capacity;
    private int size;
    private double loadFactor;

    public MyHashTable() {
        this(5, 0.75); // capacity = 10 , loadFactor = 0.75
    }


    public MyHashTable(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.size = 0;
        table = (Node<T>[]) new Node[capacity];
    }


    private int hash(T key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void add(T key) {
        int index = hash(key);
        Node<T> newNode = new Node<>(key);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<T> current = table[index];
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
        if(((double)size/capacity)> loadFactor){
            resize();
        }
    }

    public void resize(){

        Node<T> old[] = table;
        capacity *= 2;
        table = (Node<T>[]) new Node[capacity];
        size=0;
        for(Node<T> n : old){
            Node<T> curr = n;
            while(curr!=null ){
                add(curr.getKey());
                curr = curr.getNext();
            }
        }
        System.out.println("resize called");
    }

    public boolean contains(T key) {
        int index = hash(key);
        Node<T> curr = table[index];
        while (curr != null) {
            if(curr.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }


    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            Node<T> current = table[i];
            while (current != null) {
                System.out.print(current.getKey() + " -> ");
                current = current.getNext();
            }
        }
    }

    public int getSize() {
        return size;
    }
}



