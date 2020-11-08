import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache  https://leetcode-cn.com/problems/lru-cache/#/
 */
public class LRUCache {
    Map<Integer,DLinkedNode> cache;
    DLinkedNode head,tail;

    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>(capacity);
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        DLinkedNode node=cache.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node=cache.get(key);
        if(node==null){
            node=new DLinkedNode(key,value);
            cache.put(key,node);
            addToHead(node);
            size++;
            if(size>capacity){
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
                size--;
            }
        }else {
            node.value=value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode(){};
        DLinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
}
