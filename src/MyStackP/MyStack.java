package MyStackP;

public class MyStack <T>{


    public class Node1 <T>{

        T data;
        Node1<T> next;

        public Node1(T data){
            this.data = data;
            this.next = null;
        }


    }


    Node1<T> head;
    int size;

    public MyStack(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(T item){
        Node1 newNode = new Node1(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T pop(){

        if(isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T item = head.data;
        head = head.next;
        size--;
        return item;
    }

    public T peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return head.data;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node1<T> current = head;
        while(current != null){
            str.append(current.data);
            if(current.next != null){
                str.append(",");
            }
            current = current.next;
        }
        str.append("]");
        return str.toString();
    }
}