package dataStructure.map;

public class LinkedListMap<K,V> implements Map<K,V> {

    private Node dummyHead;
    private int size;

    private class Node{
        //为了方便设定值，设定为public就不再需要繁琐的set，get方法了
        public K key;
        public V value;
        public Node next;
        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key, V value){
            this(key, value, null);
        }
        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString(){
            return "key:" + key + ",value:" + value;
        }
    }

    public LinkedListMap(){
        size = 0;
        dummyHead = new Node();
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size ++;
        }
        else{
            node.value = value;
        }
    }

    /**
     *
     * @param key 待删除节点的key
     * @return  如果存在这个key则返回对应的value，如果不存在这个key则返回null
     */
    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key))
                break;
            prev = prev.next;
        }
        if(prev.next == null)
            return null;
        else {
            Node toRemove = prev.next;
            prev.next = toRemove.next;
            toRemove.next = null;
            size --;
            return toRemove.value;
        }

    }

    @Override
    public boolean contains(K key) {
        return getNode(key) == null ? false : true;
    }

    @Override
    public V get(K key) {
        return getNode(key).value;
    }

    @Override
    public void set(K key, V value) {
        getNode(key).value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 根据key找到那个node，
     * @param key 要找的那个key
     * @return  如果找到则返回，找不到返回null
     */
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null) {
            if(cur.key.equals(key))
               break;
            cur = cur.next;
        }
        return cur;
    }
}
