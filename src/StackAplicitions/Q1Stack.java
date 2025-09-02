package StackAplicitions;

import java.util.Scanner;
import java.util.Stack;

public class Q1Stack {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("ahmad abd alkaream ahmad hanoun");
        System.out.println("202410165");
        System.out.println("plese inter the exprshion :");
        String expr = in.nextLine();
        if(!cheakExp(expr)) {
            System.out.println("invalid expression");
        }
        else {
            calculateExp(expr);
        }

    }

    public static void calculateExp(String expr) {

        // make a stack to store operand
        Stack<Character> operand = new Stack<>();
        // make a stack to store operater
        Stack<Character> operater = new Stack<>();
        // store the first res
        char res = 'z';

        System.out.println("operater/operand1/operand2/res");
        for(int i=0 ; i<expr.length() ; i++){

            char c = expr.charAt(i);

            switch(c){
                case '+':
                case '-':
                case '*':
                case '/':
                    // keep going if the stack is not empty and the prayorty for the peek is biger
                    while(!operater.isEmpty() && prorty(operater.peek()) >= prorty(c)){

                        char op = operater.pop();
                        char op2 = operand.pop();
                        char op1 = operand.pop();

                        System.out.println(op +"\t\t  " + op1 +"\t\t  " + op2 +"\t\t  " + res);
                        operand.push(res);
                        res--;
                    }
                    operater.push(c);
                    break;
                default:
                    operand.push(c);
                    break;
            }

        }

        //print the rest of the stack if its not empty
        while(!operater.isEmpty()){
            char op = operater.pop();
            char op2 = operand.pop();
            char op1 = operand.pop();
            System.out.println(op +"\t\t  " + op1 +"\t\t  " + op2 +"\t\t  " + res);
            operand.push(res);
            res--;
        }

    }

    // cheak the prsyotry for eash operend by return 1 or 2
    public static int prorty(char ch){

        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }



    // cheak is the exprshio is vaild or not
    public static boolean cheakExp(String expr) {

        char first = expr.charAt(0);
        char last = expr.charAt(expr.length() - 1);

        //cheak the first and the last char if its operand return false
        if("-+*/".indexOf(first)!=-1 || "-+/*".indexOf(last)!=-1 ){
            return false;
        }


        for(int i=0 ; i<expr.length() ; i++){
            char c = expr.charAt(i);

            //ceak if the operetar is betwen a and h
            if(Character.isLetter(c)){
                if(c<'a' || c>'h'){
                    return false;
                }
            }
            // cheak if there is no two operand next to eash other
            else if ("-+*/".indexOf(c)!=-1){
                if(i+1<expr.length() && "-+*/".indexOf(expr.charAt(i+1))!=-1){
                    return false;
                }
            }
            // return false to any another char
            else{
                return false;
            }
        }
        return true;
    }


}
