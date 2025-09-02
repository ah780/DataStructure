package Output;

import Tree.MyTree;

import javax.swing.tree.TreeNode;

public class MainOutput {


    public static void main(String[] args) {


        MyTree tree = new MyTree();

        tree.add(10);
        tree.add(7);
        tree.add(15);
        tree.add(6);
        tree.add(12);
        tree.add(8);
        tree.add(9);

        MyTree.TreeNode node = tree.rot.right.left;
        MyTree.TreeNode node1 = tree.rot.left.left;
        doSomething(tree.rot, node);
        doSomething(tree.rot, node1);


    }

    public static boolean doSomething(MyTree.TreeNode root , MyTree.TreeNode node) {

        if(root == null){
            return false;
        }
        if(root == node){
            return true;
        }

        boolean left = doSomething(root.left, node);
        boolean right = false;
        if(!left){
            right = doSomething(root.right, node);
        }
        if(left || right){
            System.out.println(root.data);
        }
        return left || right;
    }


}
