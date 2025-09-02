package QueueProplem;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class QProplem {

    public static void main(String[] args) {

       Queue<Integer> q = new LinkedList<>();
       q.add(5);
       q.add(3);
       q.add(4);
       q.add(1);
       q.add(2);
        System.out.println(q);

        System.out.println(q);
    }

    public static void rotateLeft(Queue<Integer> q , int k) {

        for (int i = 0; i < k% q.size() ; i++) {
            q.add(q.poll());
        }
    }

    public static void rotateRight(Queue<Integer> q , int k) {

        for(int i=0 ; i<q.size()-k ; i++){
            q.add(q.poll());
        }
    }

    public static void reverseQueue(Queue<Integer> q) {

        Stack<Integer> s = new Stack<Integer>();
        while(!q.isEmpty()){
            s.push(q.poll());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }

    }

    public static void printEvenOdd(Queue<Integer> q) {

        Stack<Integer> s = new Stack();
        int size=q.size();
        for(int i=0 ; i<size; i++){
            int x = q.poll();
            if(x%2==0){
                q.offer(x);
            }
            else{
                s.push(x);
            }
        }
        while(!s.isEmpty()){
            q.offer(s.pop());
        }
        System.out.println(q);
    }

    public static void reverseFirstHalf(Queue<Integer> q) {

        Stack<Integer> s = new Stack();
        int size=q.size();
        for(int i=0 ; i<=size/2  ; i++){
            s.push(q.poll());
        }
        while(!s.isEmpty()){
            q.offer(s.pop());
        }
        rotateRight(q, (size/2)+1);
    }

    public static void evenOdd(Queue<Integer> q) {

        int size = q.size();
        for(int i=0 ; i<size ;i++){
            int x = q.poll();
            for(int j=0 ; j<size-1 ; j++){
                int y = q.poll();
                if(x%2!=0 && y%2==0){
                    q.offer(x);
                    x=y;
                }
                else{
                    q.offer(y);
                }
            }
            q.offer(x);
        }

    }

    public static void swapBetwenEvryTwoElements(Queue<Integer> q) {

        int size = q.size();
        for(int i=0 ; i<size/2 ; i++){
            int x = q.poll();
            int y = q.poll();
            q.offer(y);
            q.offer(x);
        }
        if(size%2!=0){
            q.offer(q.poll());
        }

    }

    public static void reverseEvryKth(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack();
        int size=q.size();
        for(int i=0 ; i<size/k ; i++){
            for(int j =0; j<k ; j++){
                s.push(q.poll());
            }
            while(!s.isEmpty()){
                q.offer(s.pop());
            }
        }
    }

    public static int min9(int n) {

        Queue<Integer> q = new LinkedList<>();
        q.add(9);
        while(true){
            int top = q.poll();
            if(n%top==0){
                return top;
            }
            q.add(top*10);
            q.add((top*10)+9);
        }
    }

    public static void pynaryGenerate(int n){

        Queue<String> q = new LinkedList<>();

        q.add("1");
        for(int i=0 ; i<n ; i++){
            String x = q.poll();
            System.out.print(x+" ");
            q.add(x+"0");
            q.add(x+"1");
        }

    }

    static int min(Queue<Integer> q){

        int size = q.size();
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<size ; i++){
            int x = q.poll();
            if(x<min){
                min = x;
            }
            else{
                q.offer(x);
            }
        }
        return min;
    }

    public static void rotateMax(Queue<Integer> q) {
        int size = q.size();
        int x = q.poll();
        for(int i=0 ; i<size ; i++){
            int y = q.poll();
            if(x<y){
                q.offer(x);
                x=y;
            }
            else{
                q.offer(y);
            }
        }
        q.offer(x);
    }

    public static void sort(Queue<Integer> q) {

        int size = q.size();
        for (int i = 0; i < size; i++) {
            int x = q.poll();//first element
            for (int j = 0; j < size - 1; j++) {
                int y = q.poll();
                if (x > y) {
                    q.offer(y);
                } else {
                    q.offer(x);
                    x = y;
                }
            }
            q.offer(x);
        }
    }

    public static void addFirst(Queue<Integer> q , int n) {

        int size = q.size();
        q.add(n);
        rotateRight(q,1);
    }

    public static ArrayList<Integer> maxWoinow(int arr[] , int k){

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int c=0;

        for(int i=0 ; i<k-1 ; i++){
            q.offer(arr[c++]);
        }

        while(c<arr.length){
            q.add(arr[c++]);
            int max = Integer.MIN_VALUE;
            for(int i=0 ; i<k ; i++){
                int x = q.poll();
                if(x>max){
                    max=x;
                }
                q.offer(x);
            }
            res.add(max);
            q.poll();
        }
       return res;
    }

    public static Stack<String>  removeSeqwanseSama(Queue<String> q){

        Stack<String> s = new Stack<>();
        int size=q.size();
        for(int i=0 ; i<size ; i++){

            String x = q.poll();
            if(!s.isEmpty() && x.equals(s.peek())){
                s.pop();
            }
            s.push(x);
        }
     return s;
    }

    public Comparable findMax(Queue<Comparable> q){

        int size=q.size();
        Comparable max =(Comparable) Integer.MIN_VALUE;
        for(int i=0 ; i<size ; i++){
            Comparable x = (Comparable) q.poll();
            if(x.compareTo(max)>0){
                max=x;
            }
            q.offer(x);
        }
        return max;
    }



}
