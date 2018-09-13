package dataStructure.hashTable;

import java.util.TreeMap;
//哈希表：均摊复杂度为O(1)，牺牲了存储数据的顺序性，

//由于hash冲突时存储在treemap中所以要对键实现Comparable的约束
public class HashTable<K extends Comparable, V>{
    //由于需要动态增加（缩小）hash数组的长度，而粗暴地直接*2或者/2会使得m变为非质数，所以需要从capacity数组中查询m的值
    private final static int[] capacity = {53,97,193,389,769,1543,3079,6151,12289,24593,49157,98317,196613,393241
                                          ,786433,1572869,3145739,6291469,12582917,25165843,50331653,100663319
                                          ,201326611,402653189,805306457,1610612741};
    private int capacityIndex = 0;
    //size/m=10的时候到达上界需要进行增加m值
    private final static int upperTol = 10;
    //size/m=2的时候到达下界需要进行缩小m值
    private final static int lowerTol = 2;
    private TreeMap<K, V>[] treeMaps ;
    //hash数组的长度
    private int m;
    //hashTable中元素的个数
    private int size;

    public HashTable(){
        m = capacity[capacityIndex];
        size = 0;
        treeMaps = new TreeMap[m];
        for (int i = 0; i < m; i++) {
            treeMaps[i] = new TreeMap<>();
        }

    }


    private int hash(K key){
        //hashcode值有可能是负数，所以要去除符号位
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public void add(K key, V value){
        TreeMap<K, V> map = treeMaps[hash(key)];
        //containsKey内部是equals实现的所以意思是hashcode相同但不是同一个对象
        // （如果覆盖了equals方法指自己制定对象是否相同的标准，如果没覆盖指的是内存地址是否相同）
        if(!map.containsKey(key)){
            map.put(key, value);
            size ++;
        }
        //更新key的值
        else{
            map.put(key, value);
        }
        if(size >= upperTol * m && capacityIndex + 1 < capacity.length)
            resize(capacity[capacityIndex++]);
    }

    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = treeMaps[hash(key)];
        if(map.containsKey(key)){
            ret = map.remove(key);
            size --;
            if(size <= lowerTol * m && capacityIndex >= 1)
                resize(capacity[capacityIndex--]);
        }
        return ret;
    }

    public void set(K key, V value){
        TreeMap<K, V> map = treeMaps[hash(key)];
        if(!map.containsKey(key))
            throw new IllegalArgumentException(key + "doesn't exist");
        map.put(key, value);
    }

    public V get(K key){
        TreeMap<K, V> map = treeMaps[hash(key)];
        if(!map.containsKey(key))
            throw new IllegalArgumentException(key + "doesn't exist");
        return map.get(key);
    }


    private void resize(int capacity){
        int oldm = m;
        m = capacity;
        TreeMap<K, V>[] treeMaps2 = new TreeMap[m];
        for (int i = 0; i < m; i++) {
            treeMaps2[i] = new TreeMap<>();
        }
        for (int i = 0; i < oldm; i++) {
            for (K key : treeMaps[i].keySet()) {
                treeMaps2[hash(key)].put(key, treeMaps[i].get(key));
            }
        }
        treeMaps = treeMaps2;
    }



    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(K key){
        return treeMaps[hash(key)].containsKey(key);
    }




}
