/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/2/5 20:38
 */
public class S1_twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] returns=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j&&nums[i]+nums[j]==target){
                    returns[0]=i;
                    returns[1]=j;
                    return returns;
                }
            }
        }
        return returns;
    }

    public static void main(String[] args) {
        S1_twoSum s1TwoSum = new S1_twoSum();
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int[] returns;
        returns = s1TwoSum.twoSum(nums, target);
        for(int i=0;i<returns.length;i++){
            System.out.println(i);
        }
    }
}
