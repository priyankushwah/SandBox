package dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class CompareTree {

    public static void main(String[] args){
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> a = new ArrayList<>();

        System.out.println(q.offer(1));
        System.out.println(q.add(2));
        System.out.println(q);

    }
}
