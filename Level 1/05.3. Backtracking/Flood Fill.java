import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
                visited[i][j] = false;
            }
        }
        
        floodfill(arr, 0, 0, "", visited);
    }
    
    public static void floodfill(int[][] maze, int sr, int sc, String output, boolean[][] visited) {
        // -ve base
        if(sr < 0 || sc < 0 || sr >= maze.length || sc >= maze[0].length || maze[sr][sc] == 1 || visited[sr][sc] == true)
        {
            return;
        }
        
        // +ve base
        if(sr == maze.length - 1 && sc == maze[0].length - 1)
        {
            System.out.println(output);
            return;
        }
        
        visited[sr][sc] = true;
        
        // top
        floodfill(maze, sr - 1, sc, output + "t", visited);
        
        // left
        floodfill(maze, sr, sc - 1, output + "l", visited);
        
        // down
        floodfill(maze, sr + 1, sc, output + "d", visited);
        
        // right
        floodfill(maze, sr, sc + 1, output + "r", visited);
        
        // backtracking step
        visited[sr][sc] = false;
    }
}
