package solution;

import java.util.HashMap;
import java.util.Map;

// medium
// url: https://leetcode.com/problems/lru-cache/description/

// Example 1:
// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]

// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4

// Constraints:
// 1 <= capacity <= 3000
// 0 <= key <= 104
// 0 <= value <= 105
// At most 2 * 105 calls will be made to get and put.

public class LRUCache {

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private final int capacity;
    private final HashMap<Integer, Node> map;

    // prevent null pointer
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void addToFront(Node node) {
        Node first = head.next;

        node.prev = head;
        node.next = first;

        head.next = node;
        first.prev = node;
    }

    private void removeNode(Node node) {
        Node p = node.prev;
        Node n = node.next;

        p.next = n;
        n.prev = p;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private Node popLRU() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;

        moveToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        Node node = map.get(key);

        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToFront(newNode);

        if (map.size() > capacity) {
            Node lru = popLRU();
            map.remove(lru.key);
        }

    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
