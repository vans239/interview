package hackerrank;

import java.util.*;

//https://www.hackerrank.com/challenges/even-tree
public class EvenTree {

    static class Tree {
        int num;
        Tree parent;
        List<Tree> childs = new ArrayList<>();

        int nodes = -1;

        void initTree() {
            int total = 1;
            for (Tree tree : childs) {
                tree.initTree();
                total += tree.nodes;
            }
            nodes = total;
        }

        int solution() {
            int total = 0;
            for(Tree tree: childs) {
                if (tree.nodes % 2 == 0) {
                    ++total;
                }
                total += tree.solution();
            }
            return total;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Tree[] trees = new Tree[n + 1];
        trees[1] = new Tree();
        trees[1].num = 1;
        for(int i = 0; i < m; ++i) {
            int num = scanner.nextInt();
            int parentNum = scanner.nextInt();
            Tree parent = trees[parentNum];
            Tree current = new Tree();
            parent.childs.add(current);
            current.num = num;
            current.parent = parent;
            trees[num] = current;
        }

        //calculate
        trees[1].initTree();

        System.out.println(trees[1].solution());
    }
}