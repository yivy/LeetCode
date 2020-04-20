/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/4/20 17:52
 */

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * area=min(h[i],h[j])*t;
 * 为什么移动短板，因为t肯定是不断减小的，主要取决于min(h[i],h[j])
 * （1）如果移动短板，min(h[i],h[j])的值可能变大
 * （2）如果移动移动长板，min(h[i],h[j])的值变小或者不变，所以移动长板必然使结果变小
 */
public class S11_maxArea {

    public int maxArea(int[] height) {
        int area=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int temarea = (j-i)*Math.min(height[i],height[j]);
                if(temarea>area){
                    area=temarea;
                }
            }
        }
        return area;
    }
    public int maxArea1(int[] height) {
        int area=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            int temarea = (j-i)*Math.min(height[i],height[j]);
            if(temarea>area){
                area=temarea;
            }
            if(height[i]<=height[j]){//移动左指针
                i++;
            }else{//移动右指针
                j--;
            }
        }
        return area;
    }
    public static void main(String[] args) {
        S11_maxArea s11_maxArea = new S11_maxArea();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height1 = {1};

        System.out.println(s11_maxArea.maxArea1(height1));
    }
}
