public class MyHashTable<K, V> {
    private HashNode<K, V>[] table;
    private int M = 11;
    private int size = 0;

    public MyHashTable() {
        table = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        table = new HashNode[M];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    public void put(K key, V value) {
        int i = hash(key);
        HashNode<K, V> head = table[i];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = table[i];
        table[i] = newNode;
        size++;
    }

    public V get(K key) {
        int i = hash(key);
        HashNode<K, V> head = table[i];

        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void printBuckets() {
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> head = table[i];
            while (head != null) {
                count++;
                head = head.next;
            }
            System.out.println("Bucket " + i + ": " + count);
        }
    }
}