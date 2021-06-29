class LRUCache {

    // LRU缓存
    // 相当于一个模板 背下来
    
    private class Node {
        // 一个Node中要存储两个数据
        // 一个key 一个value
        public int key;
        public int value;
        public Node pre;
        public Node next;
    }
    
    private HashMap<Integer, Node> map;
    // 头尾添加保护节点
    private Node head;
    private Node tail;
    private int capacity;
    
    // 这是LRU的构造函数
    // 因为我们是用其他数据结构来实现这个LRU
    // 所以构造函数中还会涉及一些我们自己写的数据结构
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // 建造我们自己添加的map
        this.map = new HashMap<Integer, Node>();
        // 建造一个空的双向链表 也是我们自己添加的数据结构
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        
    }
    
    public int get(int key) {
        
        // 不存在的情况 返回-1
        if (!map.containsKey(key)) return -1;
        // 存在的情况
        Node node = map.get(key);
        // 根据LRU性质会更新成最近访问的 删除后重新放在链表头部
        removeFromList(node);
        insertToListHead(node.key, node.value);
        return node.value;
    }
    
    public void put(int key, int value) {
        
        // map中存在key的情况 和get类似
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 从链表中删掉
            removeFromList(node);
            // 重新插入到头部，维护时间顺序
            insertToListHead(key, value);
        } else {
            // 在链表中插入新结点，返回新结点引用
            insertToListHead(key, value);
        }
        // 插入后 需要检查容量有没有满
        if (map.size() > capacity) {
            // 满的话删除最后一个结点
            removeFromList(tail.pre);
        }
    }
    
    private void removeFromList(Node node) {
        // 双向链表的删除操作
        node.pre.next = node.next;
        node.next.pre = node.pre;
        // 链表中需要删除 map中也要删除
        map.remove(node.key);
    }
    
    private Node insertToListHead(int key, int value) {
        // 首先新建一个Node 把数据放入
        Node node = new Node();
        node.key = key;
        node.value = value;
        // node与head的下一个点之间建立联系
        node.next = head.next;
        head.next.pre = node;
        // node与head之间建立联系
        node.pre = head;
        head.next = node;
        // 在map中建立映射关系
        map.put(key, node);
        return node;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */