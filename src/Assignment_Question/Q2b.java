package Assignment_Question;

import java.util.LinkedList;
import java.util.Queue;

/* 2.b) You are given an array of binary trees that represent different cities where a certain corporation
has its branch office and the organization wishes to provide service by constructing a service center.
Building service centers at any node, i.e., a city can give service to its directly connected cities where
it can provide service to its parents, itself, and its immediate children. Returns the smallest number of
service centers required by the corporation to provide service to all connected cities. Note that: the root
node represents the head office and other connected nodes represent the branch office connected to the head
office maintaining some kind of hierarchy.

Input: tree= {0,0, null, 0, null, 0, null, null, 0}
Output: 2
Explanation: construction of two service centers denoted by black markk will be enough to provide service
to all cities.
*/
class Tree_Node {
    Tree_Node left;
    Tree_Node right;
    int data;

//    constructor
    Tree_Node(int data){
        this.data=data;
        this.left=this.right=null;
    }
//    empty constructor
    Tree_Node(){

    }
//    a method of the Tree_Node class that builds a binary tree from the given array input
    public Tree_Node add_To_Tree(Object[] input) {
        if (input == null || input.length == 0) {
            return null;
        }

        Tree_Node root = new Tree_Node((int) input[0]);
        Queue<Tree_Node> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < input.length; i += 2) {
            Tree_Node curr = queue.poll();
            if (input[i] != null) {
                curr.left = new Tree_Node((int) input[i]);
                queue.offer(curr.left);
            }
            if (i+1 < input.length && input[i+1] != null) {
                curr.right = new Tree_Node((int) input[i+1]);
                queue.offer(curr.right);
            }
        }

        return root;
    }


}

class ConstructionServiceC {
    int res = 0;
//    takes a binary tree root as input and returns
//    the minimum number of cameras required to monitor all nodes in the tree
    public int minCameraCover(Tree_Node root) {

        return (dfs(root) < 1 ? 1 : 0) + res;
    }

//    a recursive method of the ConstructionServiceC class
    public int dfs(Tree_Node root) {
//  takes  root as input and returns an integer value indicating whether the current node needs a camera or not
        if (root == null) return 2;
        int left = dfs(root.left), right = dfs(root.right);
//  If the current node needs a camera then res is incremented
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }

    public static void main(String[] args) {
        Object[] tree= {0,0, null, 0, null, 0, null, null, 0 , 0 ,null,0};
        Tree_Node root = new Tree_Node().add_To_Tree(tree);
        int ans = new ConstructionServiceC().minCameraCover(root);
        System.out.println(ans);


    }
}



