package dataStructure.AVLTree;
//满二叉树：除了叶子节点外，其他所有节点都有左右两个子树
//完全二叉树：节点是一排一排慢慢铺开的，非叶子节点（倒数第二行节点）未必有左右两个子树（可能只有左子树），空缺的节点总是在一整棵树的右下角比如堆
//线段树：叶子节点的深度相差不会超过1。
//平衡二叉树：对于任意一个节点，左子树和右子树的高度差不能超过1（条件最为宽松）

//  AVL是一棵平衡二叉树，需要记录每一个节点的高度值，叶子节点的高度值为1，需要记录每个节点的平衡因子（左子树高度值 - 右子树高度值），若
// 平衡因子的绝对值大于1，此时AVL就不是一棵平衡二叉树，需要进行一些特殊的处理，比如左旋转或者右旋转。
import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            //在书中添加元素一定是在叶子节点的位置添加，所以高度为1
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //封装的目的是为了判断这个node是否为空
    private int getHeight(Node node){
        if(node == null)
            return 0;
        return node.height;

    }

    //得到节点的平衡因子
    private int getBalanceFactor(Node node){
        if(node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // 向二分搜索树中添加新的元素(key, value)
    public void add(K key, V value){
        root = add(root, key, value);
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){

        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0
            node.value = value;
        //更新height值
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        //平衡的维护

        //LL,添加的元素在左子树的左边
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);
        //RR，添加的元素在右子树的右边
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);
        //LR,添加的元素在左子树的右边
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //RL,添加的元素在右子树的边
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    // 旋转后的树需要同时满足二叉树的性质和平衡二叉树的性质
    // 二叉树的性质：T1 < z < T2 < x < y < T4,旋转后仍满足此性质
    // 平衡二叉树的性质：由于是在叶子节点新插入一个元素然后不断回溯父节点查看是否平衡，所以如果查看到y是不平衡的话那x和z一定是平衡的
    // 假设T1和T2中较高的高度为h，则z的高度为h+1，由于x是getBalanceFactor(node.left) > 0所以x的高度为h+2，由于y的平衡因子为2（
    // 由于只增加了一个元素y变不平衡了，所以只能是2），所以T4的高度为h，旋转后平衡二叉树（对于任意一个节点，左子树和右子树的高度差不能超
    // 过1）的性质仍旧是成立的。

    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;
        //开始旋转
        y.left = T3;
        x.right = y;
        //更新height值，只需要更新x和y的height值
        //先更新y的height值，因为y的height值对x的height值有影响
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;

    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    // 分析逻辑同右旋转
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;
        //开始旋转
        x.left = y;
        y.right = T2;
        //更新height值，只需要更新x和y的height值
        //先更新y的height值，因为y的height值对x的height值有影响
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
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

    // 从二分搜索树中删除键为key的节点
    public V remove(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if( node == null )
            return null;
        Node retNode ;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            retNode = node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            retNode = node;
        }
        else{   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                retNode = rightNode;
            }

            // 待删除节点右子树为空的情况
            else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                retNode = leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
           else{
                Node successor = minimum(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;

                node.left = node.right = null;

                retNode = successor;
            }

        }

        if(retNode == null) return null;
            //更新height值
            retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right)) + 1;
            //计算平衡因子
            int balanceFactor = getBalanceFactor(retNode);
            //平衡的维护

            //LL,添加的元素在左子树的左边
            if(balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
                return rightRotate(retNode);
            //RR，添加的元素在右子树的右边
            if(balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
                return leftRotate(retNode);
            //LR,添加的元素在左子树的右边
            if(balanceFactor > 1 && getBalanceFactor(retNode.left) < 0){
                retNode.left = leftRotate(retNode.left);
                return rightRotate(retNode);
            }
            //RL,添加的元素在右子树的边
            if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
                retNode.right = rightRotate(retNode.right);
                return leftRotate(retNode);
            }
            return retNode;
    }

    //判断是否为二分搜索树
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 0; i < keys.size() - 1; i++) {
            if(keys.get(i).compareTo(keys.get(i + 1)) > 0)
                return false;
        }
        return true;

    }

    //中序遍历，用在BST中就是从小到大排列
    private void inOrder(Node node, ArrayList<K> keys){
        if(node == null) return ;
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    //判断是否是平衡二叉树(对于任意一个节点，左子树和右子树的高度差不能超过1)
    public boolean isBalanced(){
        return isBalanced(root);
    }


    private boolean isBalanced(Node node){
        if(node == null) return true;
        if(Math.abs(getBalanceFactor(node)) > 1)
            return false;
        else
            return isBalanced(node.left) && isBalanced(node.right);
    }



    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("files\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            System.out.println("is BST:" + map.isBST());
            System.out.println("is balanced:" + map.isBalanced());
            for (String word : words) {
                map.remove(word);
                if(!map.isBalanced() || !map.isBST())
                    throw new RuntimeException("error");
            }
        }

        System.out.println();
    }
}


