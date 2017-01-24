package DataStructureAndAlgorithm.BinaryTree;

/**
 * Created by 10183960 on 2017/1/24.
 */
public class TreeNodeUtil {

    /**
     * 前序遍历
     * @param root 跟节点
     */
    public static void preOrder(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.element + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root 跟节点
     */
    public static void inOrder(TreeNode root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.element + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历
     * @param root 跟节点
     */
    public static void postOrder(TreeNode root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.element + " ");
    }

    public static void main(String[] args) {
        /*
                          60
                      55       100
                   45   57    67   107
                          59      101
         */
        TreeNode<Integer> root = new TreeNode<Integer>(60);
        root.left = new TreeNode<>(55);
        root.right = new TreeNode<>(100);
        root.left.left = new TreeNode<>(45);
        root.left.right = new TreeNode<>(57);
        root.left.right.right = new TreeNode<>(59);
        root.right.left = new TreeNode<>(67);
        root.right.right = new TreeNode<>(107);
        root.right.right.left = new TreeNode<>(101);

        preOrder(root);
        System.out.println("\n--------------------");
        inOrder(root);
        System.out.println("\n--------------------");
        postOrder(root);
    }
}
