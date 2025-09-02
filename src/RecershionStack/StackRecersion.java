package RecershionStack;

import java.util.Stack;

public class StackRecersion {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        addBotom(s,-1);
        System.out.println(s);
    }

    static void printStack(Stack<Integer> s) {

        if(s.isEmpty()){
            return ;
        }
        int x = s.pop();
        System.out.println(x);
        printStack(s);
        s.push(x);
    }

    static void addBotom(Stack<Integer> s , int y){

        if(s.isEmpty()){
            s.push(y);
            return;
        }
        int x = s.pop();
        addBotom(s, y);
        s.push(x);
    }

    static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int x = s.pop();
        reverseStack(s);
        addBotom(s, x);
    }

    static void sortdStack(Stack<Integer>s){

        if(s.isEmpty()){
            return;
        }
        int x = s.pop();
        sortdStack(s);
        insertSorted(s,x);
    }
    static void insertSorted(Stack<Integer> s , int y){

        if(s.isEmpty() || y>=s.peek()){
            s.push(y);
            return ;
        }
        int x = s.pop();
        insertSorted(s, y);
        s.push(x);
    }

}
