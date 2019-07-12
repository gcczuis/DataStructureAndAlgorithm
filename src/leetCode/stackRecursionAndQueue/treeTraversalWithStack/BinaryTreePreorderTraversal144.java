package leetCode.stackRecursionAndQueue.treeTraversalWithStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * {@author: gcc}
 * {@Date: 2019/6/19 11:19}
 */
public class BinaryTreePreorderTraversal144 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Command {
        private String s;//go,print
        TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }
    //利用栈模拟系统栈来实现前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Command> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.node!=null){
                if(command.s.equals("go")){
                    stack.push(new Command("go", command.node.right));
                    stack.push(new Command("go", command.node.left));
                    stack.push(new Command("print", command.node));
                }else{//command.s.equals("print")
                    list.add(command.node.val);
                }
            }
        }
        return list;
    }

    //利用栈模拟系统栈来实现中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Command> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.node!=null){
                if(command.s.equals("go")){
                    stack.push(new Command("go", command.node.right));
                    stack.push(new Command("print", command.node));
                    stack.push(new Command("go", command.node.left));
                }else{//command.s.equals("print")
                    list.add(command.node.val);
                }
            }
        }
        return list;
    }

    //利用栈模拟系统栈来实现后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Command> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.node!=null){
                if(command.s.equals("go")){
                    stack.push(new Command("print", command.node));
                    stack.push(new Command("go", command.node.right));
                    stack.push(new Command("go", command.node.left));
                }else{//command.s.equals("print")
                    list.add(command.node.val);
                }
            }
        }
        return list;
    }
}
