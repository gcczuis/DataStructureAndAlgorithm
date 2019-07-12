package algorithm.hashmap;

/**
 * {@author: gcc}
 * {@Date: 2019/7/10 14:31}
 * 主要是实现put，get方法还有resize方法
 */
public class MyHashMap {
    //默认初始化大小 16
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    //默认负载因子 0.75
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    //临界值
    private int threshold;
    //元素个数
    private int size;


    private Entry[] table;

    public MyHashMap() {
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
        threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        size = 0;
    }

    public MyHashMap(int capacity) {

        table = new Entry[capacity];
        threshold = (int) (capacity * DEFAULT_LOAD_FACTOR);
        size = 0;
    }

    private int index(Object key, int newCapacity) {
        //根据key的hashcode和table长度取模计算key在table中的位置
        //hashcode值可能为负数，所以先去掉符号位
        return (key.hashCode() & Integer.MAX_VALUE) % newCapacity;
    }

    public void put(Object key, Object value) {
        //key为null时，简化处理
        if (key == null) {
            return;
        }
        int index = index(key, table.length);

        //遍历index位置上的entry，若找到重复的key则更新对应entry的值，然后返回
        Entry entry = table[index];
        while (entry != null) {
            if (entry.key.hashCode() == key.hashCode() && (entry.key == key || entry.key.equals(key))) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        //若index位置没有entry或者未找到重复的key，则将新key添加到table的index位置
        add(index, key, value);
    }

    private void add(int index, Object key, Object value) {
        //将新的entry放到table的index位置第一个，若原来有值则以链表形式存放
        Entry entry = new Entry(key, value, table[index]);
        table[index] = entry;
        //判断size是否达到临界值，若已达到则进行扩容，将table的capacicy翻倍
        if (++size >= threshold) {
            resize(table.length * 2);
        }
    }

    private void resize(int capacity) {
        if (capacity <= table.length) {
            return;
        }

        Entry[] newTable = new Entry[capacity];

        //遍历原table，将每个entry都重新计算hash放入newTable中
        for (int i = 0; i < table.length; i++) {
            Entry old = table[i];
            while (old != null) {
                Entry next = old.next;
                int index = index(old.key, capacity);
                //下面顺序不能颠倒，很重要
                old.next = newTable[index];
                newTable[index] = old;
                old = next;
            }
        }

        table = newTable;
        threshold = (int) (table.length * DEFAULT_LOAD_FACTOR);
    }

    public Object get(Object key) {
        if (key == null) {
            return null;
        }

        Entry entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    private Entry getEntry(Object key) {

        Entry entry = table[index(key, table.length)];
        while (entry != null) {
            if (entry.key.hashCode() == key.hashCode() && (entry.key == key || entry.key.equals(key))) {
                return entry;
            }
            entry = entry.next;
        }
        return null;
    }

    //remove方法可以不写
    public void remove(Object key) {
        if (key == null) {
            return;
        }

        int index = index(key, table.length);
        Entry pre = null;
        Entry entry = table[index];
        while (entry != null) {
            if (entry.key.hashCode() == key.hashCode() && (entry.key == key || entry.key.equals(key))) {
                if (pre == null) {
                    table[index] = entry.next;
                } else pre.next = entry.next;
                //如果成功找到并且删除的haul
                size--;
                return;
            }
            pre = entry;
            entry = entry.next;
        }
    }

    //containsKey方法也可以不写
    public boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return getEntry(key) != null;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("size:%d capacity:%d \n", size, table.length));
        for (Entry entry : table) {
            while (entry != null) {
                sb.append(entry.key + ":" + entry.value + "\n");
                entry = entry.next;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("ss", 11);
        map.put("111", 13);
        map.put("112", 14);
        map.put("113", 111);
        map.put("2", 132);
        map.put("1", 132);
        map.put("3", 132);
        map.put("4", 132);
        map.put("5", 132);
        map.put("6", 132);
        map.put("7", 132);
        map.put("8", 132);
        System.out.println(map);
        System.out.println(map.get("112"));
        map.remove("111");
        System.out.println(map);


    }
}

class Entry {
    Object key;
    Object value;
    Entry next;

    public Entry(Object key, Object value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}


