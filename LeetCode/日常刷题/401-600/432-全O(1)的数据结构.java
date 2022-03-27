class AllOne {
    // 每次加减都为 1，使用双向链表，加减过渡平缓
    // 多个 key 的计数可能一样
    // 只查询最大最小计数的任意 key，其分布在双向链表两端，可以轻松查到

    // 计数为 val 的类
    class Node {
        Node pre, next;
        Set<String> set = new HashSet<String>();
        int val;

        Node(int val) { this.val = val; }
        public void insertNext(Node newNode) {
            newNode.next = this.next;
            this.next.pre = newNode;
            newNode.pre = this;
            this.next = newNode;
        }

        public void insertPrev(Node newNode) {
            newNode.pre = this.pre;
            this.pre.next = newNode;

            newNode.next = this;
            this.pre = newNode;
        }
    }

    private Map<String, Node> map = new HashMap<>();
    Node head = new Node(0), tail = new Node(-1);

    public AllOne() {
        head.next = tail; tail.pre = head;
    }
    
    public void inc(String key) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.set.remove(key);
        } else {
            node = head;
        }
        if (node.next.val != node.val+1) {
            node.insertNext(new Node(node.val+1));
        }
        node = node.next;
        node.set.add(key);
        map.put(key, node);

        clear(node.pre);
    }
    
    public void dec(String key) {
        Node node;
        // 题目保证每次 dec 时都存在 key
        node = map.get(key);
        node.set.remove(key);
        if (node.val == 1) { 
            map.remove(key);
            clear(node);
            return;
        }

        if (node.pre.val != node.val-1) {
            node.insertPrev(new Node(node.val-1));
        }
        node = node.pre;
        node.set.add(key);
        map.put(key, node);

        clear(node.next);
    }

    private void clear(Node node) {
        if (node.val != -1 && node.val != 0 && node.set.size() == 0) {
            node = node.pre;
            node.next = node.next.next;
            node.next.pre = node;
        }
    }
    
    public String getMaxKey() {
        // if (map.size() == 0) {} return "";
        Node node = tail.pre;
        for (String s : node.set) { return s; }
        return "";
        // return tail.pre.set.iterator().next;
        
    }
    
    public String getMinKey() {
        // if (map.size() == 0) return "";
        Node node = head.next;
        for (String s : node.set) { return s; }
        return "";
        // return head.next.set.iterator().next;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */