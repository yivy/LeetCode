/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/4/20 20:11
 */

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 */
public class S14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String s="";
        if(strs ==null || strs.length==0){
            return s;
        }
        if(strs.length==1){
            return strs[0];
        }
        String s1=strs[0];

        for(int i=0;i<s1.length();i++){
            for(int j=1;j<strs.length;j++){
                if(i== strs[j].length() || s1.charAt(i) != strs[j].charAt(i)){//判断到最后一个还没有进入，证明都一样，说明直接第一个就是
                    return s1.substring(0,i);
                }
            }
        }
        return s1;
    }

    public static void main(String[] args) {
        S14_longestCommonPrefix s14_longestCommonPrefix = new S14_longestCommonPrefix();
        String[] strs={"flower","flow","flight"};
        String[] strs1={"aa","ab"};
        String[] strs2={"aa","aa"};

        System.out.println(s14_longestCommonPrefix.longestCommonPrefix(strs2));
    }
}
