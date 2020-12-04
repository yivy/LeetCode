/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/12/4 19:12
 */

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *  
 *
 * 提示：
 *
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n

 */
public class S88_merge {
    /**
     * @description: 从前往后
     * @author: mengwenyi
     * @date: 2020/12/4 20:07
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int nums3[] = new int[m];
        System.arraycopy(nums1, 0, nums3, 0, m);
        while(i<m && j<n){
            if(nums3[i] > nums2[j]){
                nums1[k] = nums2[j];
                j++;
            }else{
                nums1[k] = nums3[i];
                i++;
            }
            k++;
        }
        if(i == m){
            System.arraycopy(nums2, j, nums1, k, m+n-k);
        }
        if(j == n){
            System.arraycopy(nums3, i, nums1, k, m+n-k);
        }
    }
    /**
     * @description: 从后往前
     * @author: mengwenyi
     * @date: 2020/12/4 20:07
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m , nums2, n);
        for(int i=0;i<nums1.length;i++){
            System.out.println(nums1[i]);

        }
    }


}
