package ClassicCase.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

import static ClassicCase.Tree.Tree.*;

public class Main {
    public static void main(String[] args) {
//        String[] s = new String[]{"1", "2", "4", null, null, "5", null, null, "3", "6", null, null, "7", null, null};
        String[] s = new String[]{
                "1", "2", "4", "8", null, null, "9", "a",
                "b", null, null, null, null, "5", "10",
                null, null, "11", null, null, "3", "6",
                "12", null, null, "13", null, null, "7",
                "14", null, null, "15", null, null
        };

        TreeNode head = Tree.buildTree(s);
        System.out.println(searchInfoByTree(head));

        row(head);
//        System.out.println(head);
//
//        preorder(head);
//        System.out.println();
//        unRecursionPreorder(head);
//        System.out.println();
//
//        inorder(head);
//        System.out.println();
//        unRecursionInorder(head);
//        System.out.println();
//
//        postorder(head);
//        System.out.println();
//        unRecursionPostorder(head);
//        System.out.println();

    }

}
