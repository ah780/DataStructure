package Tree;

import java.util.*;

public class MyTree {

    public class TreeNode {

        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }


    public TreeNode rot;

    public MyTree() {
        rot = null;
    }

    public TreeNode add(TreeNode root, int val) {

        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val > root.data) {
            root.right = add(root.right, val);
        } else if (val < root.data) {
            root.left = add(root.left, val);
        }
        return root;
    }

    public void add(int val) {
        rot = add(rot, val);
    }

    public int count(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    //helper method
    public int count() {
        return count(rot);
    }

    public int sum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return root.data + sum(root.left) + sum(root.right);
    }

    //helper method
    public int sum() {
        return sum(rot);
    }

    public int countLeaf(TreeNode root) {

        if (root == null) {
            return 0;
        } else if (isLeaf(root)) {
            return 1 + countLeaf(root.left) + countLeaf(root.right);
        }
        return countLeaf(root.left) + countLeaf(root.right);
    }

    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    //helbar method
    int countLeaf() {
        return countLeaf(rot);
    }

    public int sumLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (isLeaf(root)) {
            return root.data + sumLeaf(root.left) + sumLeaf(root.right);
        }
        return sumLeaf(root.left) + sumLeaf(root.right);
    }

    //helpar method
    public int sumLeaf() {
        return sumLeaf(rot);
    }

    public int maxoBt(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maxoBt(root.left), maxoBt(root.right)));
    }

    //helper method
    public int maxoBt() {
        return maxoBt(rot);
    }

    public int maxoBst(TreeNode root) {

        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.data;
    }

    //helper method
    public int maxoBst() {
        return maxoBst(rot);
    }

    public boolean searchBt(TreeNode root, int key) {

        if (root == null) {
            return false;
        } else if (root.data == key) {
            return true;
        }
        return searchBt(root.left, key) || searchBt(root.right, key);
    }

    //helper method
    public boolean searchBt(int key) {
        return searchBt(rot, key);
    }

    public boolean searchBst(TreeNode root, int key) {

        if (root == null) {
            return false;
        } else if (root.data > key) {
            return searchBst(root.left, key);
        } else if (root.data < key) {
            return searchBst(root.right, key);
        }
        return true;
    }

    //helper method
    public boolean searchBst(int key) {
        return searchBst(rot, key);
    }

    public boolean isSemitric(TreeNode root) {
        return isMeror(root.left, root.right);
    }

    public boolean isMeror(TreeNode a, TreeNode b) {

        if (a == null || b == null) {
            return a == b;
        }
        if (a.data != b.data) {
            return false;
        }
        return isMeror(a.left, b.right) && isMeror(a.right, b.left);
    }

    //helper method
    public boolean isSemitric() {
        return isSemitric(rot);
    }

    public boolean cheakSame(TreeNode a, TreeNode b) {

        if (a == null || b == null) {
            return a == b;
        }
        if (a.data != b.data) {
            return false;
        }
        return cheakSame(a.left, b.left) && cheakSame(a.right, b.right);
    }

    public boolean hasBathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        if (isLeaf(root) && sum - root.data == 0) {
            return true;
        }
        return hasBathSum(root.left, sum - root.data) || hasBathSum(root.right, sum - rot.data);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return res;
        }
        q.add(root);
        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.data);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {

        if (root.data > a.data && root.data > b.data) {
            return lowestCommonAncestor(root.left, a, b);
        }
        if (root.data < a.data && root.data < b.data) {
            return lowestCommonAncestor(root.right, a, b);
        }
        return root;
    }

    //helper method
    public Integer LCA(int a, int b) {

        if (!searchBst(a) || !searchBst(b)) {
            return null;
        }
        TreeNode node1 = new TreeNode(a);
        TreeNode node2 = new TreeNode(b);
        return lowestCommonAncestor(rot, node1, node2).data;
    }

    public boolean isFullBt(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return isFullBt(root.left) && isFullBt(root.right);
        }
        return false;
    }

    public boolean isCompleteBt(TreeNode root, int index, int count) {

        if (root == null) {
            return true;
        }

        if (index >= count) {
            return false;
        }

        return isCompleteBt(root.left, index * 2 + 1, count) && isCompleteBt(root.right, index * 2 + 2, count);
    }

    public boolean isCompleteBt() {
        return isCompleteBt(rot, 0, count());
    }

    public boolean isBerfectBt(TreeNode root, int depth, int level) {

        if (root == null) {
            return true;
        }
        if (isLeaf(root)) {
            return depth == level + 1;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return isBerfectBt(root.left, depth, level + 1) && isBerfectBt(root.right, depth, level + 1);
    }

    //helper method;
    public int depthCount(TreeNode root) {
        int count = 0;
        for (TreeNode curr = rot; curr != null; curr = curr.left) {
            count++;
        }
        return count;
    }

    public boolean isBerfectBt() {
        return isBerfectBt(rot, depthCount(rot), 0);
    }

    @Override
    public String toString() {
        return print(rot, "");
    }

    // in-order sorted
    public String print(TreeNode root, String s) {
        if (root == null) {
            return s;
        }
        s = print(root.left, s);
        s += root.data + " ";
        s = print(root.right, s);
        return s;
    }

    public void printPreOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void printPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        printInOrder(root.left);
        printInOrder(root.right);
    }

    public int countParent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1 + countParent(root.left) + countParent(root.right);
        }
        return countParent(root.left) + countParent(root.right);
    }

    public int countPrime(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (isPrime(root.data)) {
            return 1 + countPrime(root.left) + countPrime(root.right);
        }
        return countPrime(root.left) + countPrime(root.right);
    }

    public boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }


    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int leftDepth = depthCount(root.left);
        int rightDepth = depthCount(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int minDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        if(root.left==null && root.right == null){
            return 1;
        }

        if (root.left != null) {
            return 1+minDepth(root.left);
        }
        if(root.right !=null){
            return 1+minDepth(root.right);
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode sub) {

        if (root == null) {
            return false;
        }
        if (cheakSame(root, sub)) {
            return true;
        }
        return isSubtree(root.left, sub) || isSubtree(root.right, sub);
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return res;
        }
        q.add(root);
        boolean f = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.data);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            if (!f) {
                Collections.reverse(list);
            }
            res.add(list);
            f = !f;
        }
        return res;
    }

    public int sumOfLeftLeafValues(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.data;
            }
        }
        sum += sumOfLeftLeafValues(root.left);
        sum += sumOfLeftLeafValues(root.right);
        return sum;
    }

    int count = 0;
    int res = -1;

    public void KthSmallest(TreeNode root, int k) {

        if (root == null) {
            return;
        }
        KthSmallest(root.left, k);
        count++;
        if (count == k) {
            res = root.data;
            return;
        }
        KthSmallest(root.right, k);
    }


    public void KthLargestElement(TreeNode root, int k) {

        if (root == null) {
            return;
        }
        KthLargestElement(root.right, k);
        count++;
        if (count == k) {
            res = root.data;
        }
        KthLargestElement(root.left, k);
    }


    public int countOfLeafUsingStack(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        int count = 0;
        while (!s.isEmpty()) {

            TreeNode curr = s.pop();
            if (curr.left == null && curr.right == null) {
                count++;
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
            if (curr.right != null) {
                s.push(curr.right);
            }
        }
        return count;
    }


    public static List<Integer> RightVew(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        RightVewHelper(root, 0, res);
        return res;
    }


    public static TreeNode lcaBt(TreeNode root, TreeNode a, TreeNode b) {

        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }

        TreeNode left = lcaBt(root.left, a, b);
        TreeNode right = lcaBt(root.right, a, b);

        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static void RightVewHelper(TreeNode root, int level, List<Integer> res) {

        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(root.data);
        }
        RightVewHelper(root.right, level + 1, res);
        RightVewHelper(root.left, level + 1, res);
    }


    //Vertical Order Traversal of Binary Tree

    class Table {

        TreeNode nod;
        int row;
        int col;

        public Table(TreeNode rot, int col, int row) {
            this.nod = rot;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //col               row        { }
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Table> q = new LinkedList<>();
        q.offer(new Table(root, 0, 0));

        while (!q.isEmpty()) {

            Table table = q.poll();

            int col = table.col;
            int row = table.row;

            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }
            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new ArrayList<>());
            }
            map.get(col).get(row).add(table.nod.data);

            if (table.nod.left != null) {
                q.offer(new Table(table.nod.left, col - 1, row + 1));
            }
            if (table.nod.right != null) {
                q.offer(new Table(table.nod.right, col + 1, row + 1));
            }

        }
        List<List<Integer>> res = new ArrayList<>();


        for (Integer mp : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            TreeMap<Integer, List<Integer>> map1 = map.get(mp);
            for (Integer mp2 : map1.keySet()) {
                List<Integer> list2 = map1.get(mp2);
                for (Integer mp3 : list2) {
                    list.add(mp3);
                }
            }
            res.add(list);
        }

        return res;
    }


    //print leaf in the arr that is pre order with out recursive
    public void printLeaf(int arr[], int start, int end) {

        if (start > end) {
            return;
        }

        if (start == end) {
            System.out.println(arr[start]);
            return;
        }

        int root = arr[start];
        int split = start + 1;

        while (split <= end && arr[split] < root) {
            split++;
        }

        printLeaf(arr, start, split - 1);
        printLeaf(arr, split + 1, end);
    }


    //top view
    class T {

        TreeNode nod;
        int col;

        public T(TreeNode nod, int col) {
            this.nod = nod;
            this.col = col;
        }

    }

    public List<Integer> topVew(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Queue<T> q = new LinkedList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        q.add(new T(root, 0));

        while (!q.isEmpty()) {

            T t = q.poll();
            int col = t.col;

            if (!mp.containsKey(col)) {
                mp.put(col, t.nod.data);
            }
            if (t.nod.left != null) {
                q.offer(new T(t.nod.left, col - 1));
            }
            if (t.nod.right != null) {
                q.offer(new T(t.nod.right, col + 1));
            }

        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }


    //level Order From Bottom
    public List<List<Integer>> levelOrderTraversalFromBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> s = new Stack<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.add(curr.data);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            s.push(level);
        }
        while (!s.isEmpty()) {
            res.add(s.pop());
        }
        return res;
    }

    // if the heap is min or max return true otherwise return false
    public boolean isMaxHeapOrMinHeap(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //true at first
        boolean isMaxHeap = true;
        boolean isMinHeap = true;
        while (!q.isEmpty() && (isMaxHeap || isMinHeap)) {

            TreeNode node = q.poll();
            if (node.left != null) {
                if (node.data > node.left.data) {
                    isMinHeap = false;
                }
                if (node.data < node.left.data) {
                    isMaxHeap = false;
                }
                q.offer(node.left);
            }

            if (node.right != null) {

                if (node.data > node.right.data) {
                    isMinHeap = false;
                }
                if (node.data < node.right.data) {
                    isMaxHeap = false;
                }
            }
        }
        return isMaxHeap || isMinHeap;
    }

    public void getMaxBst(TreeNode root) {

        if (root == null) {
            return ;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int maxSize = 0;
        TreeNode theOne = null;


        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.data);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            TreeNode BST = buildTree(list);

            if(list.size() > maxSize){
                maxSize = list.size();
                theOne = BST;
            }
        }
        printPost(theOne);
    }
    public void printPost(TreeNode root) {
        if (root == null) {
            return;
        }
        printPost(root.left);
        System.out.print(root.data + " ");
        printPost(root.right);
    }

    public TreeNode buildTree(List<Integer> list) {

        TreeNode root = null;

        for(int val : list){
            root = insertData(val , rot);
        }
        return root;
    }

    public TreeNode insertData(int val , TreeNode root) {

        if(root == null){
            return new TreeNode(val);
        }
        if(val < root.data){
            root.left = insertData(val , root.left);
        }
        if(val > root.data){
            root.right = insertData(val , root.right);
        }
        return root;
    }


}
