/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/5/7 10:50
 */

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */
public class S20_isValid {
    public boolean isValid(String s) {
        if(s==null || s.length()==0){
            return true;
        }
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                char a = stack.pop();
                if(s.charAt(i) == ')'){
                    if(a != '('){
                        return false;
                    }
                }else if(s.charAt(i) == ']'){
                    if(a != '['){
                        return false;
                    }
                }else if(s.charAt(i) == '}'){
                    if(a != '{'){
                        return false;
                    }
                }
            }else{
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        S20_isValid s20_isValid = new S20_isValid();

        String s1="()";//true
        String s2="()[]{}";//true
        String s3="(]";//false
        String s4="([)]";//false
        String s5="{[]}";//true
        String s6="){";//true

        System.out.println(s20_isValid.isValid(s6));
    }
}
