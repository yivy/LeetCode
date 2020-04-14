/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/3/13 19:00
 */

import java.util.*;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 技术：滑动窗口
 */
public class S76_minWindow {
    public static String minWindow(String s, String t) {
        String target="";
        String tmp="";
        if(s==null || t==null || s.length()==0 || t.length()==0 || s.length()<t.length()){
            return target;
        }
        char[] a = initArray(t);
        int i=0;
        int j=0;
        List list = new ArrayList();
        while(i<s.length() || j<s.length()){
//            if(set.size() == t.length()){
//                i= set.;
//                set = new LinkedHashSet();
//                target = tmp.length()<target.length() ? tmp : target;
//                tmp="";
//            }else{
//                tmp+=s.charAt(j)+"";
//                if(t.contains(s.charAt(j)+"")){
//                    set.add(s.charAt(j));
//                }
//                j++;
//
//            }
        }
        return target;
    }
    public Map getMap(String t){
        Map map = new HashMap();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),i);
        }
        return map;
    }
    public static char[] initArray(String t){
        char[] a = new char[t.length()];
        for(int i=0;i<t.length();i++){
            a[i]=0;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECDDEBANC","ABC"));
    }
}
