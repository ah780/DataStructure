package QueueMain;

public class MyQueue<T>{

    public class Node {

        private  T data;
        private Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

        public T getData(){
            return this.data;
        }
        public Node getNext(){
            return this.next;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public void setData(T data){
            this.data = data;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public MyQueue(){
        head = tail = null;
        size=0;
    }

    public void enqueue(T data){

        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T dequeue(){

        if(head==null){
            return null;
        }

        T oldData = head.getData();
        head = head.getNext();
        if(head==null){
            tail=null;
        }
        size--;
        return oldData;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public T peek(){
        if(head==null){
            return null;
        }
        return head.getData();
    }

    public int size(){
        return size;
    }
    public Node getHead(){
        return head;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder("[");
        Node temp = head;
        while(temp!=null){
            res.append(temp.data);
            if(temp.getNext()!=null){
                res.append(", ");
            }
            temp = temp.getNext();
        }
        return res.append("]").toString();
    }

}
