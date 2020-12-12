/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/12/12 16:18
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class S118_generate {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if(numRows <= 0){
            return listList;
        }
        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            if(i == 0){
                list.add(1);
            }else{
                list.add(1);
                for(int j=0;j<listList.get(i-1).size();j++){
                    if(j+1<listList.get(i-1).size()){
                        list.add(listList.get(i-1).get(j) + listList.get(i-1).get(j+1));
                    }
                }
                list.add(1);
            }
            listList.add(list);
        }
        return listList;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
