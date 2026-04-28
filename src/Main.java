import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // HASH TABLE TEST
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>(20);
        Random r = new Random();

        for (int i = 0; i < 10000; i++) {
            table.put(new MyTestingClass(r.nextInt(1000)), i);
        }

        table.printBuckets();

        // BST TEST
        BST<Integer, String> tree = new BST<>();

        tree.put(5, "A");
        tree.put(2, "B");
        tree.put(8, "C");

        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() +
                    " and value is " + elem.getValue());
        }
    }
}