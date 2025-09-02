package RecershionStack;

import java.util.LinkedList;
import java.util.Queue;

public class QueeRecurshion {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q);
        print(q);
        System.out.println(q);
    }


    static void print(Queue<Integer> q) {

        if(q.isEmpty()){
            return ;
        }
        int x = q.poll();
        System.out.print(x+" ");
        print(q);
        q.offer(x);
    }

    static void reverse(Queue<Integer> q) {
        if(q.isEmpty()){
            return ;
        }
        int x = q.poll();
        reverse(q);
        q.offer(x);
    }


}
