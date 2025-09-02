package StackProblem;

import java.util.*;

public class MainStack {

    public static void main(String[] args) {

    String s = "aabacddd";
        System.out.println(s);
        System.out.println(groubFreq(s));




    }

    public static void sortStack(Stack<Integer> stack){

        for(int i = 0; i < stack.size(); i++){
            for(int j = 0; j < stack.size()-1; j++){
                if(stack.get(j)<stack.get(j+1)){
                    int temp = stack.get(j);
                    stack.set(j, stack.get(j+1));
                    stack.set(j+1, temp);
                }
            }
        }

    }

    public static void reverseStack(Stack<Integer> stack){

        int arr[]=new int[stack.size()];
        int index =0;
        while(!stack.isEmpty()){
            arr[index++]=stack.pop();
        }
        for(int i=0 ; i<index ; i++){
            stack.push(arr[i]);
        }
    }

    public static void findMaxAndMin(Stack<Integer> stack){

        Stack<Integer> temp = copyStack(stack);
        int max = temp.peek();
        int min = temp.peek();
        while(!temp.isEmpty()){
            if(temp.peek()>max){
                max = temp.peek();
            }
            if(temp.peek()<min){
                min = temp.peek();
            }
           temp.pop();
        }
        System.out.println("max:"+max);
        System.out.println("min:"+min);

    }
    public static Stack<Integer> copyStack(Stack<Integer> stack){

        Stack<Integer> temp = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        while(!tempStack.isEmpty()){
            int num = tempStack.pop();
            temp.push(num);
            stack.push(num);
        }
        return temp;
    }

    public boolean present(Stack<Integer> stack , int num){

        for(int i=0 ; i<stack.size(); i++){
            if(stack.get(i)==num){
                return true;
            }
        }
        return false;
    }

    public static void removeDuplicates(Stack<Integer> stack){

        Stack<Integer> temp = new Stack<>();

        while(!stack.isEmpty()){
            int num = stack.pop();
            boolean found = false;
            for(int i=0 ; i<temp.size(); i++){
                if(temp.get(i).equals(num)){
                    found = true;
                    break;
                }
            }
            if(!found){
                temp.push(num);
            }
        }

        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }

    }

    public static void removeDuplicates2(Stack<Integer> stack){

        Set<Integer> set = new HashSet<>();

        while(!stack.isEmpty()){
            int num = stack.pop();
            set.add(num);
        }
        for(int c : set){
            stack.push(c);
        }

    }

    public static void rotateLeft(Stack<Integer> stack , int num){

        Stack<Integer> temp = new Stack<>();

        num = num % stack.size();
        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }
        int arr[] = new int[num];

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = temp.pop();
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }

        for(int i=num-1 ; i>=0 ; i--){
            stack.push(arr[i]);
        }

    }

    public static void remove(Stack<Integer> stack , int num){

        for(int i=0 ; i<stack.size(); i++){
            if(stack.get(i)==num){
                stack.remove(i);
                i--;
            }
        }
    }

    public static void swapTop2(Stack<Integer> stack ){

        int top = stack.pop();
        int top2 = stack.pop();
        stack.push(top);
        stack.push(top2);

    }

    public static int getNth(Stack<Integer> stack , int n ){

        int index = stack.size()-1-n;
        return stack.get(index);

    }

    public static boolean inSubset(Stack<Integer> s1 , Stack<Integer> s2 ){

        Stack<Integer> temp = new Stack<>();
        Set<Integer> set = new HashSet<>();

        while(!s1.isEmpty()){
            int num = s1.pop();
            set.add(num);
            temp.push(num);
        }
        while(!temp.isEmpty()){
            s1.push(temp.pop());
        }
        boolean isSubset = true;

        while(!s2.isEmpty()){
            int num = s2.pop();
            if(!set.contains(num)){
                isSubset = false;
            }
            temp.push(num);
        }
        while(! temp.isEmpty()){
            s2.push(temp.pop());
        }
     return isSubset;
    }

    public static Stack<Integer> findCommon(Stack<Integer> s1 , Stack<Integer> s2){

        HashMap<Integer , Integer> set1 = new HashMap<>();
        Stack<Integer> temp = new Stack<>();
        while(!s1.isEmpty()){
            int num = s1.pop();
            set1.put(num , set1.getOrDefault(num , 0) + 1);
            temp.push(num);
        }
        while(!temp.isEmpty()){
            s1.push(temp.pop());
        }
        while(!s2.isEmpty()){
            int num = s2.pop();
            set1.put(num , set1.getOrDefault(num , 0) - 1);
            temp.push(num);
        }
        while(! temp.isEmpty()){
            s2.push(temp.pop());
        }
        for(int c : set1.keySet()){
           if(set1.get(c)==0){
               temp.push(c);
           }
        }
        return temp;
    }

    public static Stack<Integer> inFirstNotInSecound(Stack<Integer> s1 , Stack<Integer> s2){

        Stack<Integer> temp = new Stack<>();
        Set<Integer> set = new HashSet<>();
        Stack<Integer> res= new Stack<>();

        while(!s2.isEmpty()){
            int num = s2.pop();
            set.add(num);
            temp.push(num);
        }
        while(!temp.isEmpty()){
            s2.push(temp.pop());
        }

        while(!s1.isEmpty()){
            int num = s1.pop();
            if(!set.contains(num)){
                temp.push(num);
            }
            temp.push(num);
        }
        while(! temp.isEmpty()){
            s1.push(temp.pop());
        }
        return temp;
    }

    public static Stack<Integer> merageWithOutDuplicates(Stack<Integer> s1 , Stack<Integer> s2){

        Set<Integer> set = new HashSet<>();
        Stack<Integer> temp = new Stack<>();
        while(!s1.isEmpty()){
            int num = s1.pop();
            set.add(num);
            temp.push(num);
        }
        while(!temp.isEmpty()){
            s1.push(temp.pop());
        }
        while(!s2.isEmpty()){
            int num = s2.pop();
            set.add(num);
            temp.push(num);
        }
        while(! temp.isEmpty()){
            s2.push(temp.pop());
        }
        for(int c : set){
            temp.push(c);
        }
        return temp;
    }

    public static Stack<Integer> parshail(Stack<Integer> s , int first , int second ){


        Stack<Integer> res  = new Stack<>();
        Stack<Integer> temp = copyStack(s);
        Stack<Integer> helpar =new Stack<>();

        int size = temp.size();
        int c=0;
        while(!temp.isEmpty()){
            int num = temp.pop();
            if(c>=first && c<=second){
                helpar.push(num);
            }
            c++;
        }
        while(!helpar.isEmpty()){
            res.push(helpar.pop());
        }
        return res;
    }

    public static Stack<Integer> NotInBothElemeny(Stack<Integer> s1 , Stack<Integer> s2){

        Stack<Integer> res = new Stack<>();
        Set<Integer> set1= new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        Stack<Integer> temp = new Stack<>();
        while(!s1.isEmpty()){
            int num = s1.pop();
            set1.add(num);
            temp.push(num);
        }
        while(!temp.isEmpty()){
            s1.push(temp.pop());
        }
        while(!s2.isEmpty()){
            int num = s2.pop();
            set2.add(num);
            temp.push(num);
        }
        while(! temp.isEmpty()){
            s2.push(temp.pop());
        }

        for(int c : set1){
            if(!set2.contains(c)){
                res.push(c);
            }
        }
        for(int c : set2){
            if(!set1.contains(c)){
                res.push(c);
            }
        }
        return res;
    }

    public static int[] nextGreaterElement(int[] nums) {

        int res[]= new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> s = new Stack<>();
        for(int i=0 ; i<nums.length ; i++){
            while(!s.isEmpty() && nums[s.peek()]<nums[i]){
                res[s.pop()]=nums[i];
            }
            s.push(i);
        }
        return res;
    }

    public static boolean cheakParantheses(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (cheakEquel(stack.peek(), c)) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean cheakEquel ( char c1, char c){

            return c1 == '(' && c == ')'
                    || c1 == '{' && c == '}'
                    || c1 == '[' && c == ']';
        }


        public static int maxArea(int[] height) {

          Stack<Integer> s = new Stack<>();
          int area =0;
          int maxArea = 0;
          int i=0;
          for( i=0 ; i<height.length ; i++){

              if(s.isEmpty() || height[s.peek()] <= height[i]){
                  s.push(i);
              }
              else{
                  int top =s.pop();
                  if(s.isEmpty()){
                      area = height[top]*i;
                  }
                  else{
                      area = height[top] *(i-s.peek()-1);
                  }
                  if(area > maxArea){
                      maxArea = area;
                  }

              }
          }

          while(!s.isEmpty()){

              int top = s.pop();
              if(s.isEmpty()){
                  area = height[top]*i;
              }
              else{
                  area = height[top]*(i-s.peek()-1);
              }
              if(area > maxArea){
                  maxArea = area;
              }
          }
          return maxArea;
    }

    public static void sort(Stack<Integer> s) {

        Stack<Integer> temp = new Stack<>();

        while(!s.isEmpty()){
            int num = s.pop();
            while(!temp.isEmpty() && temp.peek()<num){
               s.push(temp.pop());
            }
            temp.push(num);
        }
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }

    }

    public static void swapFirstLast(Stack<Integer> s) {

        Stack<Integer> temp = new Stack<>();
        int first = s.pop();
        while(!s.isEmpty()){
            temp.push(s.pop());
        }
        int last = temp.pop();
        s.push(first);
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }
        s.push(last);
    }

    public static boolean isPalendrome(Stack<Integer> s){

        Stack<Integer> temp = new Stack<>();

        int size = s.size();

        for(int i=0 ; i<size/2 ; i++){
            temp.push(s.pop());
        }
        if(size%2!=0){
            s.pop();
        }

        while(!temp.isEmpty()){
            if(s.pop() != temp.pop()){
                return false;
            }
        }
        return true;
    }

    public static int dub (Stack<Integer> s){

        Stack<Integer> temp = copyStack(s);

        int max=0;
        int c=1;

        while(! temp.isEmpty()){

            int num = temp.pop();
            if(s.isEmpty()){
                break;
            }

            if(num==s.peek()){
                c++;
            }
            else{
                if(c>max){
                    max=c;
                }
                c=1;
            }
        }
        if(c>max){
            max=c;
        }
        return max;
    }

    public static Stack<Integer> common(Stack<Integer> s1, Stack<Integer> s2){

        Stack<Integer> ss1 = copyStack(s1);
        Stack<Integer> ss2 = copyStack(s2);
        Stack<Integer> res = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        while(!ss1.isEmpty()){
            int c=0;
            int num = ss1.pop();

            while(!ss2.isEmpty()){
                if(num==ss2.peek()){
                    c++;
                    if(c==1){
                        res.push(num);
                    }
                    else{
                        ss2.pop();
                    }
                }
                else{
                    temp.push(ss2.pop());
                }
            }
            while(!temp.isEmpty()){
                ss2.push(temp.pop());
            }
        }
        return res;
    }

    public static Stack<Integer>  peek(Stack<Integer> s){

        Stack<Integer> ss = copyStack(s);
        Stack<Integer> res = new Stack<>();
        if(ss.isEmpty()){
            return null;
        }
        if(ss.size()==1){
            res.push(ss.pop());
            return res;
        }

        int x =s.pop();
        int y = s.peek();

        if(x>=y){
            res.push(x);
        }

        while(!ss.isEmpty()){
            y =s.pop();
            if(ss.isEmpty()){
                if(y>=x){
                    res.push(y);
                    break;
                }
            }
            else{
                if(y>=x && y>=ss.peek()){
                    res.push(y);
                }
                x=y;
            }
        }
        return res;
    }

    public static int maxPalindrome(Stack<Integer> s) {

        Stack<Integer> ss = copyStack(s);
        Stack<Integer> temp = new Stack<>();
        int max=0;
        while(true){
            while(!ss.isEmpty()){
                temp.push(ss.pop());
                if(isPalendrome(temp)){
                    if(count(temp)>max){
                        max=count(temp);
                    }
                }
            }
            while(!temp.isEmpty()){
                ss.push(temp.pop());
            }
            if(ss.isEmpty()){
                break;
            }
            ss.pop();
        }
        return max;
    }

    public static int count(Stack<Integer> s) {

        Stack<Integer> ss = copyStack(s);
        int count =0;
        while(!ss.isEmpty()){
            count++;
        }
        return count;
    }

    public static int[] prevSmalarElements(int arr[]){

        int[] res = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0 ; i<arr.length ; i++){

            while(!s.isEmpty()){

                if(s.peek()<arr[i]){
                    res[i]=s.peek();
                    break;
                }
                else{
                    s.pop();
                }

            }
            if(s.isEmpty()){
               break;
            }
            s.push(arr[i]);
        }
        return res;
    }

    public static Stack<Integer> find(int arr[]){

       if(arr==null || arr.length==0){
           return null;
       }

       Stack<Integer> res= new Stack<>();

       for(int c : arr){

           while(! res.isEmpty() && c>res.peek() ){
               res.pop();
           }
           res.push(c);
       }
       return res;
    }

    public static void printAllCobanishion(String str ){

        if(str==null || str.length()==0){
            return;
        }
        Stack<String> s = new Stack<>();
        s.push(str);
        int index=0;
        while(!s.isEmpty()){
            String curr = s.pop();
            if((index=curr.indexOf('?'))!=-1){
                for(char c='0' ; c<='1' ; c++) {
                    String newStr = curr.substring(0, index) +c + curr.substring(index+1);
                    s.push(newStr);
                }
            }
            else{
                System.out.println(curr);
            }
        }
    }

    public static int longetVaildParnthese(String str){

        if(str==null || str.length()==0){
            return 0;
        }
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int len=0;
        for(int i=0 ; i<str.length() ; i++){

            if(str.charAt(i)==')'){
                s.push(i);
            }
            else{
                s.pop();
                if(s.isEmpty()){
                    s.push(i);
                    continue;
                }
                int currLen = i - s.peek();
                if(currLen>len){
                    len = currLen;
                }

            }
        }
        return len;
    }

    public static void removeNegative(Stack<Integer> s , Queue<Integer> q ){

        Stack<Integer> temp = new Stack<>();

        while(!s.isEmpty()){
            int x = s.pop();
            if(x<0){
                q.offer(x);
            }
            else{
                temp.push(x);
            }
        }
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }

    }

    public static boolean isTheSame(Stack<Integer> s , Queue<Integer> q){

        if(q.size()!=s.size()){
            return false;
        }
        Stack<Integer> temp = new Stack<>();

        int size = q.size();
        for(int i=0 ; i<size ; i++){
            int x =q.poll();
            boolean found = false;
            while(!s.isEmpty()){
                int y=s.pop();
                if(y==x){
                    temp.push(y);
                    found = true;
                    break;
                }
                temp.push(y);
            }
            while(!temp.isEmpty()){
                s.push(temp.pop());
            }
            if(!found){
                return false;
            }
            q.offer(x);
        }
        return true;
    }

    public static void removeSubString(Stack<String> s , String str){

        Stack<String> temp = new Stack<>();
        while(!s.isEmpty()){
            String curr = s.pop();
            if(curr.indexOf(str)==-1){
              temp.push(curr);
            }
        }
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }

    }

    public static void removeChar(Queue<Character> q){

        int size = q.size();
        for(int i=0 ; i<size ; i++){
            char c  = q.poll();
            if(c!='i' && c!='e' && c!='o' && c!='u' && c!='a'){
                q.offer(c);
            }
        }

    }

    public static Map<Character , List<String>> groab(Set<String> set){

        Map<Character , List<String>> map = new HashMap<>();

        for(String s : set){
            char ch = s.charAt(0);
            if(!map.containsKey(ch)){
                map.put(ch , new ArrayList<>());
            }
            map.get(ch).add(s);
        }
        return map;
    }
    public static void prime(Set<String> set){

        Set<String> res = new HashSet<>();
        for(String s : set){
            int size = s.length();
            if(!prime(size)){
                res.add(s);
            }
        }
        for(String s : res){
            set.remove(s);
        }

    }
    public static boolean prime(int size){
        if(size==1){
            return false;
        }
        for(int i=2 ; i<size-1 ; i++){
            if(size%i==0){
                return false;
            }
        }
        return true;
    }

    public static void factoryal(Map<Integer,Integer> mp){

        for(int c : mp.keySet()){
            int fact = faco(mp.get(c));
            mp.put(c, fact);
        }

    }
    public static int faco(int n){

        int fact = 1;
        for(int i=1 ; i<=n ; i++){
            fact *= i;
        }
        return fact;
    }

    public static void removeM(Map<Integer,Integer> mp , int num){

        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if(entry.getValue()%num==0){
                set.add(entry.getKey());
            }
        }
        for(Integer key : set){
            mp.remove(key);
        }
    }

    public static void printFreq(String str){

        Map<String , Integer> mp = new HashMap<>();

        String arr[]=str.split(" ");
        for(String s : arr){
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        for(Map.Entry<String , Integer> entry : mp.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static String removeDuplicates(String str){

        Map<Character , Integer> mp = new HashMap<>();

        for(char c : str.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        String res = "";
        for(Map.Entry<Character,Integer> en : mp.entrySet()){
            res+=en.getKey();
        }
        return res;
    }

    public static Map<Character,Integer> merage(Map<Character , Integer> mp1, Map<Character , Integer> mp2){
        Map<Character , Integer> res = new HashMap<>();

        for(Map.Entry<Character,Integer> entry : mp1.entrySet()){
          res.put(entry.getKey() , entry.getValue());
        }
        for(Map.Entry<Character , Integer> entry : mp2.entrySet()){
            if(res.containsKey(entry.getKey())){
                res.put(entry.getKey() , res.get(entry.getKey())+entry.getValue());
            }else{
                res.put(entry.getKey() , entry.getValue());
            }
        }
     return res;
    }


    public static int maxSubStringWithOutRepatingChar(String str){

        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int max=0;

        while(right < str.length()){

            if(!set.contains(str.charAt(right))){
                set.add(str.charAt(right));
                max = Math.max(max, right-left);
            }
            else{
                while(set.contains(str.charAt(right))){
                    set.remove(str.charAt(left));
                    left++;
                }
            }
            right++;
        }
        return max;
    }

    public static Map<Integer,List<Character>> groubFreq(String str){

        Map<Integer,List<Character>> map = new HashMap<>();
        Map<Character , Integer> mp = new HashMap<>();

        for(char c : str.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character , Integer> entry : mp.entrySet()){

            int freq = entry.getValue();
            List<Character> temp = new ArrayList<>();

            for(Map.Entry<Character , Integer> en : mp.entrySet()){
                if(en.getValue()==freq){
                    temp.add(en.getKey());
                }
            }
            map.put(freq , temp);
        }
        return map;
    }

    public Stack<Integer> mergeStack(Stack<Integer> a, Stack<Integer> b){

       Stack<Integer> res = new Stack<>();
       Stack<Integer> temp = new Stack<>();

       while(!a.isEmpty() && !b.isEmpty()){

           if(a.peek()<b.peek()){
               temp.push(a.pop());
           }
           else {
               temp.push(b.pop());
           }
       }

       while(!a.isEmpty()){
           temp.push(a.pop());
       }
       while(!b.isEmpty()){
           temp.push(b.pop());
       }

       while(!temp.isEmpty()){
           res.push(temp.pop());
       }
       return res;
    }



}

