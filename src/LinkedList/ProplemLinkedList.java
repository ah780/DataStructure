package LinkedList;

public class ProplemLinkedList {

    public static void main(String[] args) {

        MylinkedList list = new MylinkedList();
        list.add(2);
        list.add(6);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(19);
        System.out.println(list);
        newOrder(list.head);
        System.out.println(list);


    }

    public static void newOrder(Node head){

        Node pre = head;
        while(pre !=null && pre.next!=null) {

            if (pre.next.value % 2 == 0) {
                Node next = pre.next;
                while (next != null && next.value % 2 == 0) {
                    next = next.next;
                }
                if (next != null) {
                    Integer curr = pre.value;
                    pre.next.value = next.value;
                    next.value = pre.value;
                }
            }
            pre = pre.next;
        }

        }




    public static void print(Node node){
        while(node != null){
            System.out.print(node.value+" ");
            node = node.next;
        }
    }

    public static void swapByIndex(Node head , int firstIndex, int secondIndex) {

        Node  x = get(firstIndex , head);
        Node xx = get(firstIndex-1 , head);
        Node y = get(secondIndex , head);
        Node yy = get(secondIndex-1 , head);

        Node temp = y.next;

        if(xx==null){
            head = y;
        }
        else{
            xx.next = y;
        }
        if(yy==null){
            head=x;
        }
        else{
            yy.next = x;
        }
        y.next = x.next;
        x.next = temp;

    }

    public static Node get(int index , Node head) {

        Node temp = head;
        for (int i = 0 ; i < index ;  i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void inserValue(Node head , int val){

        Node temp = head;
        Node newNode = new Node(val);

        if(temp==null || val<temp.value){
            newNode.next = head;
            head = newNode;
            return;
        }

        while(temp.next != null){
            if(val<temp.next.value){
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        }
    }

    public static Node[] split (Node head){

        if(head==null || head.next==null){
            return null;
        }
        Node mid =  midle(head);
        Node temp = head;

        while(temp != null){
            if(temp.next == mid){
                break;
            }
            temp = temp.next;
        }
        temp.next = null;
        return new Node[]{head,mid};
    }

    public static Node midle(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node removeDuplicates(Node head){

        if(head==null || head.next==null){
            return head;
        }
        Node temp = head;
        Node dummy = new Node(-1);
        dummy.next = temp;
        Node tail = dummy;

        while(temp != null){
            if(temp.value != tail.value){
                tail.next = temp;
                tail=temp;
            }
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void rerangeOddEven(Node head){

        if(head==null || head.next==null){
            return;
        }
        Node h1 = head;
        Node h2 = head.next;
        Node tail1 = h1;
        Node tail2 = h2;

        while(tail1.next != null && tail2.next != null){
            tail1.next = tail1.next.next;
            tail1=tail1.next;
            tail2.next = tail2.next.next;
            tail2=tail2.next;
        }
        if(tail2.next != null){
            tail2.next = null;
        }
        if(tail1.next!= null){
            tail1.next = null;
        }

        tail1.next = reverse(h2);


    }

    public static Node reverse(Node head){

        if(head==null || head.next==null){
            return head;
        }
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node shulfMerage(Node a , Node b){

      if(a==null){
          return b;
      }
      if(b==null){
          return a;
      }

        Node dummy = new Node(-1);
        Node tail = dummy;

        while(true){

            if(a  == null){
                tail.next = b;
                break;
            }
            if(b  == null){
                tail.next = a;
                break;
            }
            else{
                tail.next = a;
                tail = a;
                a = a.next;

                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        return dummy.next;
    }

    public static Node sortedMerage(Node a , Node b){

        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        Node dummy = new Node(-1);
        Node tail = dummy;

        while(a!=null && b!=null) {

            if (a.value <= b.value) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        return dummy.next;
    }

    public static Node merageKLinkedList(Node[] list , int k){

        for(int i = 0 ; i < list.length-1 ; i++){
            list[i+1] = sortedMerage(list[i] , list[i+1]);
        }
        return list[list.length-1];
    }

    public static Node intersection(Node a, Node b){
        if(a==null || b==null){
            return null;
        }
        Node dummy = new Node(-1);
        Node tail = dummy;

        while(a!=null && b!=null){

            if(a.value == b.value){
                tail.next = new Node(a.value);
                tail = tail.next;
                a = a.next;
                b=b.next;
            }
            else if(a.value < b.value){
                a=a.next;
            }
            else{
                b = b.next;
            }
        }
        return dummy.next;
    }


    public static int count(Node head){


        int c=0;
        Node temp =head;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        return c;
    }

    public static Node reverseKthNode(Node head , int k){

       Node curr = head;
       Node prev= null;
       Node next = null;
       int count=0;
       while(count<k && curr!=null){
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
           count++;
       }

       if(next != null){
           head.next = reverseKthNode(next , k);
       }
       return prev;
    }

    public static Node deleteNodes(Node head , int n , int m){

        if(head==null || head.next==null){
            return head;
        }

        Node temp = head;
        Node prev = head;

        for(int i=1 ; temp!=null && i<=m ; i++){
            prev = temp;
            temp = temp.next;
        }
        for(int i=1 ; temp!=null && i<=n ; i++){
           temp = temp.next;
        }
        prev.next = temp;
        deleteNodes(temp , n , m);
        return head;
    }

    public static boolean isPalindrome(Node head){

        if(head==null || head.next==null){
            return true;
        }

        Node temp = head;
        Node midle = midle(temp);
        Node secHalf = midle.next;
        midle.next=null;
        secHalf =reverse(secHalf);

        while(secHalf != null){

            if(temp.value!=secHalf.value){
                return false;
            }
            temp = temp.next;
            secHalf = secHalf.next;
        }
        return true;
    }

    public static boolean canBePalindrome(Node head){

        if(head==null || head.next==null){
            return true;
        }

        Node temp = head;

        int freq[]=new int[101];
        while(temp!=null){
            freq[temp.value]++;
            temp = temp.next;
        }
        int c=0;
        for(int i : freq){
            if(i%2!=0){
                c++;
                if(c>1){
                    return false;
                }
            }
        }
    return true;
    }

    public static Node rerange1(Node head){

        if(head==null || head.next==null){
            return null;
        }

        Node prev = head;
        Node curr = head.next;

        while(curr!=null){

            if(prev.value > curr.value){
                int temp = curr.value;
                curr.value = prev.value;
                prev.value = temp;
            }
            if(curr.next!=null && curr.next.value>curr.value){
                int temp = curr.value;
                curr.value = prev.value;
                prev.value = temp;
            }
            prev = curr.next;
            if(curr.next==null){
                break;
            }
            curr=curr.next.next;

        }
        return head;
    }



}
