package RecershionStack;


public class LinkedListRecurshion {

    public class Node {

        int value;
        Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }



    public static void main(String[] args) {



    }

    public static boolean isSorted(Node head){

        if(head==null || head.next==null){
            return true;
        }

        if(head.value < head.next.value){
            return false;
        }
        return isSorted(head.next);
    }

}
