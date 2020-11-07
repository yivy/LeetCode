/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/11/7 12:54

/**
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

**/
public class S28_strStr {
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack == null || haystack.length() == 0 || needle.length() > haystack.length()){
            return -1;
        }
        int i = 0;
        int j = 0;
        int start = 0;
        while(start < (haystack.length()- needle.length()) + 1){
            if(haystack.charAt(i) == needle.charAt(j)){
                if(j ==0){
                    start = i;
                }
                if(j == needle.length() -1){
                    return i-j;
                }else{
                    i++;
                    j++;
                }
            }else {
                if(j!=0){
                    i = start + 1;
                }else{
                    i++;
                }
                j=0;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
//        String haystack ="hello";
//        String needle = "ll";
//        String haystack ="aaaaa";
//        String needle = "bba";
//        String haystack ="mississippi";
//        String needle = "issip";
        String haystack ="qq";
        String needle = "qq";
        System.out.println(strStr(haystack, needle));
    }
}
