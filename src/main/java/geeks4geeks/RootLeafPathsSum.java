package geeks4geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by KatKat on 20/05/17.
 */
//http://practice.geeksforgeeks.org/problems/root-to-leaf-paths-sum
public class RootLeafPathsSum {

    class Tree {
        int data;
        Tree left,right;
        Tree(int d){
            data=d;
            left=null;
            right=null;
        }
    }

    public static int treePathsSum(int parent, Tree root) {
        if (root.left == null && root.right == null) {
            return parent * 10 + root.data;
        } else {
            int sum = 0;
            int next = parent * 10 + root.data;
            if (root.left != null) {
                sum += treePathsSum(next, root.left);
            }
            if (root.right != null) {
                sum += treePathsSum(next, root.right);
            }
            return sum;
        }
    }

    public static int treePathsSum(Tree root)
    {
        return treePathsSum(0, root);
    }
}
