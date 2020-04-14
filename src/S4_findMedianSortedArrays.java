/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/3/23 14:52
 */
/*
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    你可以假设 nums1 和 nums2 不会同时为空。

    示例 1:
    nums1 = [1, 3]
    nums2 = [2]
    则中位数是 2.0

    示例 2:
    nums1 = [1, 2]
    nums2 = [3, 4]
    则中位数是 (2 + 3)/2 = 2.5
 */
public class S4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double a=1;
        int i=0;
        int j=nums1.length-1;

        int k=0;
        int m=nums2.length-1;

        int c=0;
        if((nums1.length+nums2.length)%2!=0){
            c=(nums1.length+nums2.length)/2-1;
        }else{
            c = (nums1.length+nums2.length)/2;
        }
        int cvalue=0;
        while(i< nums1.length&& j<nums2.length){
            if((nums1[i] + nums1[j])> (nums1[k] + nums1[m])){

            }
        }
        return a;
    }
}
