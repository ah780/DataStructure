package MyCircleQueue;

public class CyrclereQueue<T>{


    int size;
    int first;
    int last;
    T arr[];

    public CyrclereQueue(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
        first = last = -1;
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public boolean isFull() {
        return (last + 1) % size == first;
    }

    public void enqueue(T val) {

        if (!isFull()) {
            if (isEmpty()) {
                first = 0;
            }
            last = (last + 1) % size;
            arr[last] = val;
        }

    }

    public T dequeue() {

        if (isEmpty()) {
            return null;
        }
        T val = arr[first];
        if (first == last) {
            first = last = -1;
        } else {
            first = (first + 1) % size;
        }
        return val;
    }

    @Override
    public String toString() {

        if (isEmpty()) {
            return "[]";
        }
        String res = "[";

        for (int i = first; ; i = (i + 1) % size) {
            res += arr[i];
            if (i == last) {
                break;
            }
            res += ",";
        }
        return res + "]";
    }
}



