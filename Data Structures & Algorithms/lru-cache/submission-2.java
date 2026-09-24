class Node{
    int key,value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key=key;
        this.value=value;
        this.prev = this.next = null;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);

        head.next=tail;
        tail.prev=head;

    }

    public void removeFromTail(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insertToHead(Node node){
        Node next = head.next;
        next.prev = node;
        node.next = next;
        node.prev = head;
        head.next = node;

    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            removeFromTail(map.get(key));
            insertToHead(map.get(key));
            return map.get(key).value;
            
        }
        return -1;        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeFromTail(node);
        }
        Node newNode = new Node(key,value);
        map.put(key,newNode);
        insertToHead(newNode);

        if(map.size()>capacity){
            Node lru = tail.prev;
            removeFromTail(lru);
            map.remove(lru.key);
        }
        
    }
}

//1 = put,get
//n = map
