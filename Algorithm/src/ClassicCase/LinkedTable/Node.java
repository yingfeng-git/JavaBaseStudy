package ClassicCase.LinkedTable;

public class Node {
    Node next;
    int val;
    Node(int val, Node next){
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + " ";
    }
}
