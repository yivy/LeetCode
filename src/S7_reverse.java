/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/3/27 17:20
 */

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 */
public class S7_reverse {
    public int reverse(int x) {
        int t=0;
        while(x!=0){
            int pop = x%10;
            x=x/10;
            System.out.println(t);
            if (t > Integer.MAX_VALUE/10 || (t == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (t < Integer.MIN_VALUE/10 || (t == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            t=t*10+pop;
        }
        return t;
    }

    public static void main(String[] args) {
        S7_reverse s7_reverse = new S7_reverse();
        System.out.println(s7_reverse.reverse(1534236469));
    }
}
