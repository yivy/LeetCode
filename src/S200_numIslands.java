/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/3/10 20:56
 */
/*
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3

 */
public class S200_numIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int total = 0;
        for(int r=0; r< grid.length; r++){
            for(int c=0; c<grid[0].length;c++){
                if(grid[r][c] =='1'){
                    total++;
                    dfs(grid,r,c);
                }
            }
        }
        return total;
    }
    public void dfs(char[][] grid, int r, int c){
        if(r<0 || r>grid.length-1 || c<0 || c>grid[0].length-1 || grid[r][c] == '0'){
            return;
        }
        grid[r][c]='0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        S200_numIslands s200_numIslands = new S200_numIslands();
        System.out.println(s200_numIslands.numIslands(grid));
    }
}
