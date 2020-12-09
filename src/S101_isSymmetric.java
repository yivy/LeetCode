
/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/12/7 20:17
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class S101_isSymmetric {
    /**
     * @description: 是否是平衡二叉树，递归方式
     * @author: mengwenyi
     * @date: 2020/12/9 10:16
     */ 
    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public static boolean check(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if(node1.val == node2.val){
            return check(node1.left, node2.right) && check(node1.right, node2.left);
        }else{
            return false;
        }
    }
    /**
     * @description: 迭代方式
     * @author: mengwenyi
     * @date: 2020/12/9 10:42
     */ 
    public static boolean isSymmetric1(TreeNode root) {

        return check1(root, root);
    }
    public static boolean check1(TreeNode node1, TreeNode node2){
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(node1);
        queue.offer(node2);
        while (!queue.isEmpty()){
            node1 = queue.poll();
            node2 = queue.poll();
            if(node1 == null && node2 == null){
                continue;
            }
            if(node1 == null || node2 == null || node1.val != node2.val){
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        System.out.println(isSymmetric1(root));
    }
}
