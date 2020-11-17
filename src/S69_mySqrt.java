/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/11/16 20:56
 */

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class S69_mySqrt {
    public static int mySqrt(int x) {
        if(x ==0){
           return 0;
        }
        if(x == 1){
            return 1;
        }
        for(int i =1;i<x; i++){
            if((long)i*i == x){
                return i;
            }else if((long)i*i > x){
                return i-1;
            }
        }
        return 1;
    }
    public static int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    /**
     * @description: 二分法
     * @author: mengwenyi
     * @date: 2020/11/17 12:50
     */
    public static int mySqrt2(int x) {
        int i = 0, j=x;
        while (i <= j) {
            int mid = (i+j)/2;
            if ((long) mid * mid < x) {
                i = mid + 1;
            } else if ((long) mid * mid > x){
                j = mid - 1;
            }else {
                return mid;
            }
        }
        return i-1;
    }
    /**
     * @description: 牛顿法
     * @author: mengwenyi
     * @date: 2020/11/17 11:27
     * xi = 1/2(x0+c/xo)
     */

    public static int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }


    public static void main(String[] args) {
        System.out.println(mySqrt3(Integer.MAX_VALUE));;
    }
}
