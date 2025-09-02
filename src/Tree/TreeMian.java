package Tree;

import java.util.Arrays;

public class TreeMian {

    public static void main(String[] args) {


     MyTree t = new MyTree();

       // 50, 30, 70, 20, 40, 60, 80

        t.add(50);
        t.add(30);
        t.add(70);
        t.add(20);
        t.add(40);
        t.add(60);
        t.add(80);

        System.out.println(t.verticalTraversal(t.rot));




    }





}
