package ProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "Timur";
        int times = in.nextInt();

        for (int i = 0; i < times; i++) {
            int length = in.nextInt();
            String s = in.next();
            boolean flag = true;


            if (length != 5) {
                flag = false;
            }

            for (int j = 0; j < length; j++) {
                if (!str.contains(s.charAt(j) + "")) {
                    flag = false;
                    break;
                }
            }


            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


    }
}




