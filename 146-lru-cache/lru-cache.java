class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}


class LRUCache {
    int capacity;
    Map<Integer,ListNode> dic;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dic = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev= head;
        
    }
    
    public int get(int key) {
        if(!dic.containsKey(key)){
            return -1;
        }

        ListNode node = dic.get(key);
        remove(node);
        add(node);
        return node.val;
        
    }
    
    public void put(int key, int value) {
        if(dic.containsKey(key)){
            ListNode oldnode = dic.get(key);
            remove(oldnode);
        }
        ListNode node = new ListNode(key,value);
        dic.put(key,node);
        add(node);

        if(dic.size()>capacity){
            ListNode nodetodel = head.next;
            remove(nodetodel);
            dic.remove(nodetodel.key);
        } 
    }

    public void add(ListNode node){
        ListNode prvend = tail.prev;
        prvend.next = node;
        node.prev= prvend;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev= node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */