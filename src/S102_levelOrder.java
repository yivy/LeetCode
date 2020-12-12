import java.util.*;

/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/12/12 15:25
 */

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class S102_levelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if(root == null){
            return listList;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for(int i =0; i< size; i++){
                TreeNode treeNode = queue.poll();
                levelList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            listList.add(levelList);
        }
        return listList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        root.right.left.left=new TreeNode(5);
        System.out.println(levelOrder(root));
    }
}
