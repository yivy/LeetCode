/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/4/27 15:41
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 */
public class S18_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums==null || nums.length<4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<>();
        for(int k=0;k<nums.length-3;k++){
            if(k>0 && nums[k] == nums[k-1]){
                continue;
            }
            //最小值都大于目标值，直接停止
            if(nums[k]+nums[k+1]+nums[k+2]+nums[k+3]>target){
                break;
            }
            //当前循环的最大值都比目标值小，以后会越来越小，所以直接进入下一个循环
            if(nums[k]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1]<target){
                continue;
            }
            for(int m=k+1;m<nums.length-2;m++){
                //当m与前面的值相等时忽略
                if(m>k+1 && nums[m] == nums[m-1]){
                    continue;
                }
                int i=m+1;
                int j=nums.length-1;
                //最小值都大于目标值结束此次循环
                if(nums[k]+nums[m]+nums[i]+nums[i+1]>target){
                    continue;
                }
                //当前循环的最大值都比目标值小，以后会越来越小，所以直接进入下一个循环
                if(nums[k]+nums[m]+nums[j-1]+nums[j]<target){
                    continue;
                }
                while (i<j){
                    if(nums[k]+nums[m]+nums[i]+nums[j]==target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[k]);
                        list.add(nums[m]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        returnList.add(list);
                        while((i+1)<j && nums[i+1]==nums[i]) i++;
                        while(j-1>i && nums[j-1] ==nums[j]) j--;
                        i++;
                        j--;
                    }else if(nums[k]+nums[m]+nums[i]+nums[j]<target){
                        i++;
                    }else{
                        j--;
                    }

                }
            }
        }

        return  returnList;
    }

    public static void main(String[] args) {
        S18_fourSum s18_fourSum = new S18_fourSum();
        int[] nums={1, 0, -1, 0, -2, 2};
        int target=0;
        System.out.println(s18_fourSum.fourSum(nums,target));
    }
}
