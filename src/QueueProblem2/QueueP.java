package QueueProblem2;

import java.util.*;

public class QueueP {

    public static void main(String[] args) {

      int arr[]={-8,2,3,-6,10};
        System.out.println(Arrays.toString(arr));
        System.out.println(firstNegativeWindows(arr,2));

    }
    public static void rotateRight(Queue<Integer> q , int k) {

        int n = k%q.size();

        for(int i=0 ; i<n  ; i++){
            q.add(q.poll());
        }
    }

    public static void rotateLeft(Queue<Integer> q , int k) {

        int n = q.size()-k%q.size();
        for(int i=0 ; i<n  ; i++){
            q.add(q.poll());
        }
    }

    public static void reverse(Queue<Integer> q) {

        Stack<Integer> s = new Stack<Integer>();
        int size = q.size();
        for(int i=0 ; i<size ; i++){
            s.push(q.poll());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void evenOdd(Queue<Integer> q) {

        int n = q.size();
        Stack<Integer> s = new Stack<>();
        for(int i=0 ; i<n ; i++){

            int num = q.poll();
            if(num%2==0){
                q.offer(num);
            }
            else{
                s.push(num);
            }

        }
        while(!s.isEmpty()){
            q.offer(s.pop());
        }

    }

    public static void evenOdd2(Queue<Integer> q) {


        int n = q.size();

        for(int i=0 ; i<n ; i++){

            int x =q.poll();

            for(int j=0 ; j<n-1; j++){

                int y= q.poll();

                if(x%2==0 && y%2!=0){
                    q.offer(x);
                    x = y;
                }else{
                    q.offer(y);
                }
            }
            q.offer(x);
        }

    }

    public static int min(Queue<Integer> q) {
        int n = q.size();
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++){
            int num = q.poll();
            if(num<min){
                min = num;
            }
            q.offer(num);
        }
        return min;
    }

    public static void putMinLast(Queue<Integer> q) {

        int n = q.size();
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++){
            int num = q.poll();
            if(num<min){
                min=num;
            }
            q.offer(num);
        }

        boolean removed = false;
        for(int i=0 ; i<n ; i++){
            int num = q.poll();
            if(num==min && !removed){
                removed=true;
                continue;
            }
            q.offer(num);
        }
        q.offer(min);
    }

    public static void reversePart1(Queue<Integer> q) {

        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for(int i=0  ; i<size/2 ; i++){
            s.push(q.poll());
        }
        while(!s.isEmpty()){
            q.offer(s.pop());
        }
        if(size%2!=0){
            size=size+1;
        }
        for(int i=0 ; i<size/2 ; i++){
            q.offer(q.poll());
        }
    }

    public static void reversePart2(Queue<Integer> q) {

        int size =q.size();
        Stack<Integer> s = new Stack<>();
        rotateRight(q, size/2);
        for(int i=0 ; i<size/2 ; i++){
            s.push(q.poll());
        }
        while(!s.isEmpty()){
            q.offer(s.pop());
        }
    }

    public static void swap2(Queue<Integer> q) {
        int n = q.size();
        for(int i=0 ; i<n/2 ; i++){
            int x = q.poll();
            int y = q.poll();
            q.offer(y);
            q.offer(x);
        }
    }

    public static void sort(Queue<Integer> q) {

        int n = q.size();

        for(int i=0 ; i<n ; i++){
            int x = q.poll();

            for(int j=0 ; j<n-1 ; j++){

                int y =q.poll();
                if(x<y){
                    q.offer(x);
                    x=y;
                }else{
                    q.offer(y);
                }
            }
            q.offer(x);
        }
    }
    public static void removlast(Queue<Integer> q){

        int n = q.size();
        rotateLeft(q,1);
        q.poll();
    }

    public static void addFirst(Queue<Integer> q , int val) {

        q.offer(val);
        rotateLeft(q,1);

    }

    public static void reverseK(Queue<Integer> q , int k) {

        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for(int i=0 ; i<size/k ; i++){
            for(int j=0 ; j<k ; j++){
                s.push(q.poll());
            }
            while(!s.isEmpty()){
                q.offer(s.pop());
            }
        }
       q.offer(q.poll());

    }

    public static int maxMultiple3(int [] arr) {

        Queue<Integer> q0 = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Arrays.sort(arr);
        for(int c : arr){
            if(c%3==0){
                q0.add(c);
            }
           else if(c%3==1){
               q1.add(c);
            }
           else{
               q2.add(c);
            }
        }
        int sum=0;
        for(int c : arr){
            sum+=c;
        }

        int rem=sum%3;
        if(rem==1){

            if(q1.size()>=1){
                q1.poll();
            }
            else if(q2.size()>=2){
                q2.poll();
                q2.poll();
            }
            else{
                return -1;
            }
        }
        if(rem%3==2) {
            if (q1.size() >= 1) {
                q1.poll();
            } else if (q2.size() >= 2) {
                q2.poll();
                q2.poll();
            } else {
                return -1;
            }
        }

        int res[]=new int[arr.length];
        int c=0;
        while(!q0.isEmpty()){
            res[c++]=q0.poll();
        }
        while(!q1.isEmpty()){
            res[c++]=q1.poll();
        }
        while(!q2.isEmpty()){
            res[c++]=q2.poll();
        }
        Arrays.sort(res);
        for(int i=c-1 ; i>=0 ; i--){
            System.out.print(res[i]+" ");
        }
        return -1;
    }

    public static int smallest90(int rem){

        Queue<Integer> q = new LinkedList<>();
        q.offer(9);
        while(true) {

            int num = q.poll();
            if (num % rem == 0) {
                return num;
            }
            q.add(num * 10);
            q.add(num * 10 + 9);
        }
    }

    public static List<Integer> maxWindows(int[] nums, int k) {

        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int c=0;
        for(int i=0 ; i<k-1 ; i++){
            q.offer(nums[c++]);
        }
        while(c<nums.length){

            q.offer(nums[c++]);
            int max = Integer.MIN_VALUE;
            for(int i=0 ; i<k ; i++){
                int x = q.poll();
                if(x>max){
                    max=x;
                }
            }
            res.add(max);
            q.poll();
        }
        return res;
    }

    public static int removeConsecutiveSame(Queue<String> q) {

        Stack<String> s = new Stack<>();

        while(!q.isEmpty()){
            String x = q.poll();
            if(s.isEmpty()){
                s.push(x);
            }
            else{
                if(x.equals(s.peek())){
                    s.pop();
                }
                else{
                    s.push(x);
                }
            }
        }
        return s.size();
    }

    public static void genereteBinary(int n){

        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for(int i=0 ; i<n ; i++){
            String x = q.poll();
            System.out.println(x);
            q.offer("0"+x);
            q.offer("1"+x);
        }

    }

    public static List<Integer> firstNegativeWindows(int[] arr, int k) {

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int c=0;
        for(int i=0 ; i<k-1 ; i++){
            q.offer(arr[c++]);
        }

        int index= 0;

        while(c<arr.length){
            boolean found=true;
            q.offer(arr[c++]);
            for(int i=0 ; i<k ; i++){
                int x =q.poll();
                if(x<0){
                    res.add(x);
                    found=false;
                }
                q.offer(x);
            }
            if(found){
                res.add(0);
            }
            q.poll();
        }
        return res;
    }

}
