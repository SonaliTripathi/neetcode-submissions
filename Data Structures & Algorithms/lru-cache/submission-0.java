class Node{
    int key;
    int value;
    Node prev;
    Node next;

    private Node(int key, int value){
        this.key=key;
        this.value=value;
        this.prev=this.next=null;
    }
}

class LRUCache {

    int cap;
    Map<Integer,Node> cache;
    Node right;
    Node left;

    public LRUCache(int capacity) {
        this.cap=capacity;
        cache = new HashMap<>();
        this.right = new Node(0,0);
        this.left = new Node(0,0);

        this.left.next=right;
        this.right.prev=left;
        
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next=next;
        next.prev=prev;        
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        prev.next=node;
        node.prev=prev;
        node.next=this.right;
        this.right.prev=node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode = new Node(key,value);
        cache.put(key,newNode);
        insert(newNode);

        if(cache.size()>this.cap){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }

        
    }
}

//1 = put,get
//n= map
