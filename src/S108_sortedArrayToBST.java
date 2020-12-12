/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/12/12 13:58
 */

import java.util.List;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class S108_sortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    public static TreeNode sortedArrayToBST(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, left, mid -1);
        treeNode.right = sortedArrayToBST(nums, mid+1, right);
        return treeNode;
    }

    public static void main(String[] args) {
        int nums[] = {-10,-3,0,5,9};
        print(sortedArrayToBST(nums));
    }
    public static void print(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        print(treeNode.left);
        System.out.println(treeNode.val);
        print(treeNode.right);
    }
}
