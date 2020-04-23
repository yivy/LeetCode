/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/4/23 15:52
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class S15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        if(nums==null || nums.length<3){
            return returnList;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i] +nums[j]+nums[k] ==0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if(!returnList.contains(list)){
                            returnList.add(list);
                        }
                    }
                }
            }
        }
        return returnList;
    }
    /**
     * @description: 双指针法
     * @author: mengwenyi
     * @date: 2020/4/23 16:20
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        if(nums.length<3){
            return returnList;
        }
        Arrays.sort(nums);

        for(int k=0;k<(nums.length-2);k++){
            if((k-1)>=0 && nums[k] == nums[k-1]){
                continue;
            }
            if(nums[k]>0){
                continue;
            }
            int i=k+1;//左指针
            int j=nums.length-1;//右指针
            while(i<j){
                if(nums[i] +nums[j]+nums[k] ==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    returnList.add(list);

                    while(i+1<j&&nums[i]==nums[i+1]) i++;
                    while(i<j-1&&nums[j]==nums[j-1]) j--;
                    i++;
                    j--;
                }else if(nums[i] +nums[j]+nums[k]<0){
                    i++;
                }else{
                    j--;
                }
            }
        }
        return returnList;
    }
    public List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int k=0;k<=nums.length-3;k++){
            int i=k+1;
            int j=nums.length-1;
            if(nums[k]>0){
                continue;
            }
            else if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            while(i<j){
                int s = nums[k]+nums[i]+nums[j];
                if(s==0){
                    ArrayList<Integer> arr = new ArrayList();
                    arr.add(nums[k]);arr.add(nums[i]);arr.add(nums[j]);
                    result.add(arr);
                    while(i+1<j&&nums[i]==nums[i+1]) i++;
                    while(i<j-1&&nums[j]==nums[j-1]) j--;
                    i++;
                    j--;
                }
                else if(s<0){
                    i++;
                    continue;
                }
                else if(s>0){
                    j--;
                    continue;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        S15_threeSum s15_threeSum = new S15_threeSum();
        int[] nums={-1, 0, 1, 2, -1, -4};
        System.out.println(s15_threeSum.threeSum1(nums));
    }
}
