/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/4/23 18:27
 */

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class S16_threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<3){
            return 0;
        }
        int near=Integer.MAX_VALUE;
        int s=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(Math.abs(nums[i] +nums[j]+nums[k]-target) <near){
                        near = Math.abs(nums[i] +nums[j]+nums[k]-target);
                        s=nums[i] +nums[j]+nums[k];
                    }
                }
            }
        }
        return s;
    }
    public int threeSumClosest1(int[] nums, int target) {
        if(nums==null || nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int near=Integer.MAX_VALUE;
        int s=0;
        for(int k=0;k<nums.length-2;k++){
            int i=k+1;
            int j=nums.length-1;
            while(i<j){
                if(Math.abs(nums[i] +nums[j]+nums[k]-target) <near){
                    near = Math.abs(nums[i] +nums[j]+nums[k]-target);
                    s=nums[i] +nums[j]+nums[k];
                }
                if(nums[i] +nums[j]+nums[k]==target){
                    return target;
                }else if(nums[i] +nums[j]+nums[k]<target){
                    i++;
                }else{
                    j--;
                }
                while((i-1)>0 && (i-1)<j && nums[i]==nums[i-1]) i++;
                while((j-1)>i && nums[j-1]==nums[j]) j--;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        S16_threeSumClosest s16_threeSumClosest = new S16_threeSumClosest();
        int[] nums={-1,2,1,-4,8};
        int[] nums1={1,1,-1,-1,3};
        int[] nums3={1,2,5,10,11};
        int[] nums4={0,0,0};

        System.out.println(s16_threeSumClosest.threeSumClosest1(nums3,12));
    }
}
