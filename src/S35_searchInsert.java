/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/11/7 14:44
 */

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 */
public class S35_searchInsert {
    /**
     * @description: 暴力法
     * @author: mengwenyi
     * @date: 2020/11/7 14:53
     */
    public static int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
    /**
     * @description: 二分法
     * @author: mengwenyi
     * @date: 2020/11/7 14:53
     */
    public static int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>target) {
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int nums[] ={1,3,5,6};
        int target = 4;
//        int target = 2;
//        int target = 7;
//        int target = 0;
        System.out.println(searchInsert1(nums, target));
    }
}
