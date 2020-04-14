/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/3/12 21:03
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 滑动窗口
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class S3_lengthOfLongestSubstring {
//    public int lengthOfLongestSubstring(String s) {
//        if(s==null || s.length()==0){
//            return 0;
//        }
//        int max=0;
//        for(int i=0;i<s.length();i++){
//            for(int j=i+1;j<s.length();j++){
//                if(lengthOfLongestSubstring(s,i,j)){
//                    max=Math.max(max,j-i);
//                }
//            }
//        }
//        return max;
//    }
//    public boolean lengthOfLongestSubstring(String s, int start, int end) {
//        Set set = new HashSet();
//        for(int i=start;i<end;i++){
//            Character character = s.charAt(i);
//            if(!set.contains(character)){
//                set.add(character);
//            }else{
//                return false;
//            }
//        }
//        return true;
//    }
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int i=0;
        int j=0;
        int max=0;
        HashSet set = new HashSet();
        while( (i<s.length() && j<s.length())){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max=Math.max(max,j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
    /**
     * @description: pwwkew，我们可以从出现w以后的位置重新开始找
     * @author: mengwenyi
     * @date: 2020/3/12 22:24
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
        S3_lengthOfLongestSubstring s3 = new S3_lengthOfLongestSubstring();
        System.out.println(s3.lengthOfLongestSubstring(s));
    }
}
