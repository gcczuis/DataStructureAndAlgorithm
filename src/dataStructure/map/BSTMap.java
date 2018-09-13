package dataStructure.map;

public class BSTMap<K extends Comparable,V> implements Map<K,V>{

    private class Node{
        //为了方便设定值，设定为public就不再需要繁琐的set，get方法了
        public K key;
        public V value;
        public Node left;
        public Node right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
        @Override
        public String toString(){
            return "key:" + key + ",value:" + value;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value){
        root = add(key, value, root);
    }

    private Node add(K key, V value, Node node){
        if(node == null){
            size ++;
            return new Node(key, value);
        }
        if(key.compareTo(node.key) > 0){
            node.right = add(key, value, node.right);
        }
        else if(key.compareTo(node.key) < 0){
            node.left = add(key, value, node.left);
        }
        else{//element.compareTo(node.element) = 0如果key相同默认更新value
            node.value = value;
        }
            return node;
    }





    @Override
    public V remove(K key){
        Node node = getNode(key);
        if(node != null) {
            root = remove(key, root);
            return node.value;
        }
        return null;
    }

    /**
     * 删除以node为根节点下的指定键
     * @param key 要删除的键
     * @param node  根节点
     * @return  删除后的新的根节点
     */
    private Node remove(K key,Node node) {
        if (node == null) return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(key, node.left);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(key, node.right);
            return node;
        } else {//element.compareTo(node.element) = 0
            //如果节点的右孩子为空
            if (node.right == null) {
                node.left = null;
                size--;
                return node.left;
            }
            //如果节点的左孩子为空
            else if (node.left == null) {
                node.right = null;
                size--;
                return node.right;
            }
            //待删除节点左右孩子均不为空的情况
            //找到这个待删除元素右子树的最小元素，
            //用这个节点顶替待删除节点的位置
            else {
                Node successor = minimum(node.right);
                //remove操作的时候已经size--了，所以不需要再写
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }
    }


    /**
     * 删除以node为根节点下的最小元素
     * @param node 根节点
     * @return  删除后新的根节点
     */
    private Node removeMin(Node node){
        if(node.left ==null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //返回以node为根节点下的最大值所在节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    @Override
    public boolean contains(K key){
        return contains(key, root);
    }

    private boolean contains(K key, Node node){
        if (node == null)
            return false;
        if (key.compareTo(node.key) < 0)
            return contains(key, node.left);
        else if (key.compareTo(node.key) > 0)
            return contains(key, node.right);
        else //element.compareTo(node.element) = 0
            return true;
    }


    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
        }
    }

    private Node getNode(K key){
        return getNode(key,root);
    }

    /**
     *
     * @param key 待查找的key
     * @param node  在以此node为根节点下搜寻
     * @return 如果存在返回此node，如果不存在则返回null
     */
    private Node getNode(K key, Node node){
       if(node == null)
           return null;
       else if(node.key.equals(key))
           return node;
       else if(key.compareTo(node.key) > 0)
           return getNode(key,node.right);
       else //(key.compareTo(node.key) < 0)
           return getNode(key,node.left);

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
