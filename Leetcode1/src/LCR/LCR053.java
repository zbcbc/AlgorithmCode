package LCR;

/**
 * ClassName: LCR.LCR053
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/5/30 10:05
 * @Version 1.0
 */
public class LCR053 {
     static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
  }

    static TreeNode pre = null;
    static TreeNode res = null;
    public  static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        return res;
    }
    public static void inorder(TreeNode root, TreeNode p){
        if(root == null) return;

        inorderSuccessor(root.left, p);
        if(pre != null && pre.val == p.val){
            res = root;
            return;
        }
        pre = root;
        inorderSuccessor(root.right, p);
    }

    public static void main(String[] args) {
        Integer[] root = {5, 3, 6, 2, 4, null, null, 1};

    }
}

