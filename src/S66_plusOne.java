/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/11/16 19:21
 */

/**
 *给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 */
public class S66_plusOne {
    public static int[] plusOne(int[] digits) {
        int num = 0;
        for(int i=digits.length-1;i>=0;i--){
            num += digits[digits.length-1-i] * (Math.pow(10,i));
        }
        num +=1;
        String s= num+"";
        int returnArray[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            returnArray[i] = s.charAt(i)-'0';
        }
        return returnArray;
    }
    public static int[] plusOne1(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i] ++;
            digits[i]= digits[i]%10;
            if(digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    public static int[] plusOne2(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] == 9){
                digits[i]= 0;
            }else{
                digits[i] ++;
                return digits;
            }

        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    public static void main(String[] args) {
        int nums[]={9,9,9,9};
        int a[]=plusOne1(nums);
        System.out.println(a);
    }
}
