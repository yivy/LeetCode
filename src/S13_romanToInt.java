/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/4/20 18:47
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 */
public class S13_romanToInt {
    public int romanToInt(String s) {
        int a=0;
        if(s==null || s.length()==0){
            return a;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'I'){
                if((i+1)<s.length() && s.charAt(i+1) == 'V'){
                    a+=4;
                    i++;
                }else if((i+1)<s.length() && s.charAt(i+1) == 'X'){
                    a+=9;
                    i++;
                }else{
                    a+=1;
                }
            }else if(s.charAt(i) == 'V'){
                a+=5;
            }else if(s.charAt(i) == 'X'){
                if((i+1)<s.length() && s.charAt(i+1) == 'L'){
                    a+=40;
                    i++;
                }else if((i+1)<s.length() && s.charAt(i+1) == 'C'){
                    a+=90;
                    i++;
                }else{
                    a+=10;
                }
            }else if(s.charAt(i) == 'L'){
                a+=50;
            }else if(s.charAt(i) == 'C'){
                if((i+1)<s.length() && s.charAt(i+1) == 'D'){
                    a+=400;
                    i++;
                }else if((i+1)<s.length() && s.charAt(i+1) == 'M'){
                    a+=900;
                    i++;
                }else{
                    a+=100;
                }
            }else if(s.charAt(i) == 'D'){
                a+=500;
            }else if(s.charAt(i) == 'M'){
                a+=1000;
            }
        }
        return a;
    }
    public int romanToInt1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int a=0;
        if(s==null || s.length()==0){
            return a;
        }
        for(int i=0;i<s.length();i++){
            if((i+1)<s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                a-=map.get(s.charAt(i));
            }else{
                a+=map.get(s.charAt(i));
            }
        }
        return a;
    }

    public static void main(String[] args) {
        S13_romanToInt s13_romanToInt = new S13_romanToInt();
        System.out.println(s13_romanToInt.romanToInt1("III"));//3
        System.out.println(s13_romanToInt.romanToInt1("IV"));//4
        System.out.println(s13_romanToInt.romanToInt1("IX"));//9
        System.out.println(s13_romanToInt.romanToInt1("LVIII"));//58
        System.out.println(s13_romanToInt.romanToInt1("MCMXCIV"));//1994

    }
}
