package dataStructure.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node{
        public Node left, right;
        public E element;
        public Node(E element){
            this.element = element;
        }
        @Override
        public String toString(){
            return element.toString();
        }

    }

    private int size;
    private Node root;
    public BST(){
        root = null;
        size = 0;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public void add(E element){
        root = add(element, root);
    }

    private Node add(E element, Node node){
        if(node == null){
            size ++;
            return new Node(element);
        }
        if(element.compareTo(node.element) > 0){
            node.right = add(element, node.right);
            return node;
        }
        else if(element.compareTo(node.element) < 0){
            node.left = add(element, node.left);
            return node;
        }
        else//element.compareTo(node.element) = 0
            return node;
    }

   /* //查询的非递归实现
    public boolean contains(E element){
        Node cur = root;
        while(cur != null){
            if(element.compareTo(cur.element) < 0)
                cur = cur.left;
            else if(element.compareTo(cur.element) > 0)
                cur = cur.right;
            else return true;
        }
        return false;
    }*/

   public boolean contains(E element){
        return contains(element,root);
   }

   private boolean contains(E element, Node node){
       if (node == null)
           return false;
       if (element.compareTo(node.element) < 0)
           return contains(element, node.left);
       else if (element.compareTo(node.element) > 0)
           return contains(element, node.right);
       else //element.compareTo(node.element) = 0
           return true;
   }

   //二分搜索树的前序遍历
   public void preOrder(){
       preOrder(root);
   }
   private void preOrder(Node node){
       if(node == null) return ;
       System.out.println(node);
       preOrder(node.left);
       preOrder(node.right);
   }

   //前序遍历的非递归（用栈）实现
   public void preOrderWithStack(){
       Stack<Node> stack = new Stack<>();
       if(root == null) return ;
       stack.push(root);
       while(!stack.isEmpty()){
           Node pop = stack.pop();
           System.out.println(pop.element);
           if(pop.right != null)//由于后入栈的元素先出栈，所以先把右子节点放入
               stack.push(pop.right);
           if(pop.left != null)
               stack.push(pop.left);
       }
   }

   //二分搜索树的中序遍历，自带从小到大排序功能
   public void inOrder(){
       inOrder(root);
   }
   private void inOrder(Node node){
       if(node == null) return ;
       inOrder(node.left);
       System.out.println(node);
       inOrder(node.right);
   }

    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null) return ;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node);
    }

    //层序遍历，广度优先遍历（使用队列来实现）
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        if(root == null) return ;

        q.add(root);
        while(!q.isEmpty()){
            Node remove = q.remove();
            System.out.println(remove.element);
            if(remove.left != null)
                q.add(remove.left);
            if(remove.right != null)
                q.add(remove.right);
        }
    }



    public E removeMax(){
       if(isEmpty())
           throw new IllegalArgumentException("the BST is empty");
        return removeMax(root).element;
    }

    /**
     * 删除以node为根节点下的最大元素
     * @param node 根节点
     * @return  删除后新的根节点
     */
    private Node removeMax(Node node){
       if(node.right == null){
           Node leftNode = node.left;
           node.left = null;
           size --;
           return leftNode;
       }
       node.right = removeMax(node.right);
       return node;
    }

    public E removeMin(){
       if(isEmpty())
           throw new IllegalArgumentException("the BST is empty");
        return removeMin(root).element;
    }

    /**
     * 删除以node为根节点下的最小元素
     * @param node 根节点
     * @return  删除后新的根节点
     */
    private Node removeMin(Node node){
       if(node.left == null){
           Node rightNode = node.right;
           node.right = null;
           size --;
           return rightNode;
       }
       node.left = removeMin(node.left);
       return node;
    }

    public void remove(E element){
        remove(element, root);
    }

    /**
     * 删除以node为根节点下的指定元素
     * @param element 要删除的元素
     * @param node  根节点
     * @return  删除后的新的根节点
     */
    private Node remove(E element,Node node){
        if(node == null) return null;
        if(element.compareTo(node.element) < 0){
            node.left = remove(element, node.left);
            return node;
        }
        else if(element.compareTo(node.element) > 0){
            node.right = remove(element, node.right);
            return node;
        }
        else{//element.compareTo(node.element) = 0
            //如果节点的右孩子为空
            if(node.right == null){
                node.left = null;
                size -- ;
                return node.left;
            }
            //如果节点的左孩子为空
            else if(node.left == null){
                node.right = null;
                size -- ;
                return node.right;
            }
            //待删除节点左右孩子均不为空的情况
            //找到这个待删除元素右子树的最小元素，
            //用这个节点顶替待删除节点的位置
            else{
                Node successor = minimum(node.right);
                //remove操作的时候已经size--了，所以不需要再写
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }
    }

    //查找BST的最大元素
    public E Maximum(){
        if(isEmpty())
            throw new IllegalArgumentException("the BST is empty");
       return Maximum(root).element;

    }

    //返回以node为根节点下的最大值所在节点
    private Node Maximum(Node node){

        if(node.right == null)
            return node;
        return Maximum(node.right);
    }

    //查找BST的最小元素
    public E minimum(){
        if(isEmpty())
            throw new IllegalArgumentException("the BST is empty");
        return minimum(root).element;

    }

    //返回以node为根节点下的最大值所在节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }






   public static void main(String[] args){
       BST<Integer> bst = new BST<>();
       bst.add(4);
       bst.add(2);
       bst.add(3);
       bst.add(5);
       bst.add(1);

       bst.levelOrder();

       bst.remove(2);
       System.out.println();
       bst.levelOrder();
   }





}
