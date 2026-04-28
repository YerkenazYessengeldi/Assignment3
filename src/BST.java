import java.util.*;

public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {

    class Node {
        K key;
        V val;
        Node left, right;

        Node(K k, V v) {
            key = k;
            val = v;
        }

        public K getKey() { return key; }
        public V getValue() { return val; }
    }

    private Node root;
    private int size = 0;

    public int size() {
        return size;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            size++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;

        return x;
    }

    public Iterator<Node> iterator() {
        List<Node> list = new ArrayList<>();
        inorder(root, list);
        return list.iterator();
    }

    private void inorder(Node x, List<Node> list) {
        if (x == null) return;
        inorder(x.left, list);
        list.add(x);
        inorder(x.right, list);
    }
}