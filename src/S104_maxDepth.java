/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/12/12 13:24
 */

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *   /
 *  5
 * 返回它的最大深度 3 。
 */
public class S104_maxDepth {
    public static int maxDepth(TreeNode root) {
        int max = 0;
        return maxDepth(root, max);
    }
    public static int maxDepth(TreeNode root, int max) {
        if(root == null){
            return max;
        }
        max = max + 1;
        return Math.max(maxDepth(root.left, max), maxDepth(root.right, max));
    }
    public static int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
        }

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        root.right.left.left=new TreeNode(5);
        System.out.println(maxDepth(root));
    }
}
