import java.util.*;

/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/12/12 14:50
 */

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * peek和poll的区别，，，peek不会从队首移出，只是查看
 * add和offer的区别，add溢出会抛出异常，offer不会
 */
public class S107_levelOrderBottom {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if(root == null){
            return listList;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            listList.add(0,list);
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
        System.out.println(levelOrderBottom(root));
    }
}
