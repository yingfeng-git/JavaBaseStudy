package ClassicCase.UnionSet;

import java.util.*;

public class UnionSet<V> {
    private static class Node<V> {
        V value;

        Node(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private final HashMap<V, Node<V>> nodes;
    private final HashMap<Node<V>, Node<V>> parent;
    private final HashMap<Node<V>, Integer> counts;

    UnionSet(List<V> set) {
        nodes = new HashMap<>();
        parent = new HashMap<>();
        counts = new HashMap<>();
        for (V v : set) {
            Node<V> node = new Node<V>(v);
            nodes.put(v, node);
            parent.put(node, node);
            counts.put(node, 1);
        }
    }

    public Node<V> findFather(V v) {
        Node<V> node = nodes.get(v);
        Deque<Node<V>> changes = new LinkedList<>();
        while (node != parent.get(node)) {
            node = parent.get(node);
            changes.add(node);
        }
        while (!changes.isEmpty()) {
            parent.put(changes.pop(), node);
        }
        return node;
    }

    public boolean isSameSet(V a, V b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) return false;
        return findFather(a) == findFather(b);
    }

    public void union(V a, V b) {
        if (!isSameSet(a, b)) {
            Node<V> aHead = findFather(a);
            Node<V> bHead = findFather(b);
            Node<V> big = counts.get(aHead) > counts.get(bHead) ? aHead : bHead;
            Node<V> small = counts.get(aHead) > counts.get(bHead) ? bHead : aHead;
            parent.put(small, big);
            counts.put(big, counts.get(big) + counts.get(small));
            counts.remove(small);
        }
    }

    @Override
    public String toString() {
        return '{' +
                "\"nodes\":" +
                nodes +
                ",\"parent\":" +
                parent +
                ",\"counts\":" +
                counts +
                '}';
    }

    public static void swap(char[] c, int i, int j){
        char temp;
        temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
    public static void process(char[] chars, int i){

        if (i == chars.length){
            for (char aChar : chars) {
                System.out.print(aChar+"");
            }
            System.out.println();
        }

        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            process(chars, i + 1);
            swap(chars, i, j);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        process(str.toCharArray(), 0);
    }
}
