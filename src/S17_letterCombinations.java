/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/4/27 14:36
 */

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */

/**
 * 当输入23时我们需要两层循环，当输入234时，我们需要三层循环，所以想法是用递归
 * 当输入23时，输出9个字符串，当输入234时，只需要将原有的9个字符串和4对应的字符串进行组合
 */
public class S17_letterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> returnList = new ArrayList<>();
        if(digits ==null || digits.length()==0){
            return returnList;
        }
        Map<Integer,List<String>> map = new HashMap();
        String[] letters={"a","b","c"};
        map.put(2, new ArrayList(Arrays.asList(letters)));
        letters= new String[]{"d", "e", "f"};
        map.put(3, new ArrayList(Arrays.asList(letters)));
        letters= new String[]{"g", "h", "i"};
        map.put(4, new ArrayList(Arrays.asList(letters)));
        letters= new String[]{"j", "k", "l"};
        map.put(5, new ArrayList(Arrays.asList(letters)));
        letters= new String[]{"m", "n", "o"};
        map.put(6, new ArrayList(Arrays.asList(letters)));
        letters= new String[]{"p", "q", "r", "s"};
        map.put(7, new ArrayList(Arrays.asList(letters)));
        letters= new String[]{"t","u", "v"};
        map.put(8, new ArrayList(Arrays.asList(letters)));
        letters= new String[]{"w", "x", "y","z"};
        map.put(9, new ArrayList(Arrays.asList(letters)));
        returnList = getString(map.get(digits.charAt(0)-'0'), digits, 1, map);
        return returnList;
    }
    public List<String> getString(List<String> list1,String digits,int i,Map<Integer,List<String>> map){
        if(i==digits.length()){
            return list1;
        }
        List<String> returnList = new ArrayList<>();
        List<String> nextList = map.get(digits.charAt(i)-'0');
        for(String s1: list1){
            for(String s2 : nextList){
                returnList.add(s1+s2);
            }
        }
        return getString(returnList,digits,i+1,map);
    }

    public static void main(String[] args) {
        S17_letterCombinations s17_letterCombinations = new S17_letterCombinations();
        String s1="2";
        List<String> list = s17_letterCombinations.letterCombinations(s1);
        System.out.println(list);
    }
}
