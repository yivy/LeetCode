/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/11/26 21:12
 */
/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class S70_climbStairs {
    public static int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int dp[] = new int[n];
        for(int i = 0; i<n; i++){
            if(i < 2){
                dp[i] = i+1;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n-1];
    }


    public static void main(String[] args) {
        int n=3;
        System.out.println(climbStairs(n));
    }
}
