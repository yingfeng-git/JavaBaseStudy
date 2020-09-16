package ClassicCase.Tree;

public class Main {
    public static void main(String[] args) {
        String[] s = new String[]{"1", "2", "4", null, null, "5", null, null, "3", "6", null, null, "7", null, null};
        TreeNode head = Tree.buildTree(s);
        System.out.println(head);
    }

}
