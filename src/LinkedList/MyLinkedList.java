package LinkedList;

class MylinkedList {

    int size;
    Node head;
    Node tail;

    public MylinkedList(){
        size=0;
        head=tail=null;
    }


    public void add(int value){
        Node newNode = new Node(value);

        if(size==0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }

    public void add(int value , int index){

        if(index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            addFirst(value);
        }
        else if(index==size-1){
            add(value);
        }
        else{
            Node newNode = new Node(value);
            Node temp = head;
            for(int i=0 ; i<index-1 ; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public void addFirst(int value){
        Node newNode = new Node(value);
        if(size==0){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
        size++;
    }

    public int get(int index){

        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        Node temp = head;

        for(int i=0 ; i<index ; i++){
            temp=temp.next;
        }
        return temp.value;
    }

    public int getFirst(){

        if(size==0){
            throw new IndexOutOfBoundsException();
        }
        return head.value;

    }
    public int getLast(){
        if(size==0){
            throw new IndexOutOfBoundsException();
        }
        return tail.value;
    }

    public int removeFirst(){

        if(size==0){
            throw new IndexOutOfBoundsException();
        }
        int oldValue = head.value;
        head = head.next;
        if(head==null){
            tail = null;
        }
        size--;
        return oldValue;
    }

    public int remove(int index){

        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        if(index==0) {
            int oldValue = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return oldValue;
        }
        Node temp = head;
        for(int i=0 ; i<index-1 ; i++){
            temp=temp.next;
        }
        int oldValue = temp.next.value;
        if(index==size-1){
            temp.next = null;
            tail = temp;
            size--;
            return oldValue;
        }
        else{
            temp.next = temp.next.next;
            size--;
            return oldValue;
        }
    }

    public int set(int index , int value){

        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        Node temp =head;

        for(int i=0 ; i<index ; i++){
            temp=temp.next;
        }
        int oldValue = temp.value;
        temp.value = value;
        return oldValue;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int... values){

        for(int i : values){
            add(i);
        }
    }

    @Override
    public String toString() {

        Node temp = head;
        String s ="";
        while(temp != null){
            s+=temp.value+" ";
            temp=temp.next;
        }
        return s;
    }
}
