// Video Solution - https://www.youtube.com/watch?v=3zEmFO7EDYI&ab_channel=ProgrammingVidya

import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        int[] moves = new int[1000001];
        for(int i=1; i<= 1000000; i++){
            int least = moves[i - 1];
            for(int j=2; j*j <= i; j++){
                if(i % j == 0){
                    least = Math.min(least, moves[i/j]);
                }
            }
            moves[i] = ++least;
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            System.out.println(moves[sc.nextInt()]);
        }
    }
}
