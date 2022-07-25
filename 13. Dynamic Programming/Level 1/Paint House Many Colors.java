// O(N ^ 3)
// import java.io.*;
// import java.util.*;

// public class Main {

//   public static void main(String[] args) throws Exception {
//     Scanner scn = new Scanner(System.in);
//     int n = scn.nextInt();
//     int colors = scn.nextInt();
//     int[][] cost = new int[n][colors];
//     for (int i = 0; i < n; i++)
//     {
//       for (int j = 0; j < colors; j++)
//         cost[i][j] = scn.nextInt();
//     }


//     int[][] dp = new int[n][colors];
//     for (int c = 0; c < colors; c++)
//       dp[0][c] = cost[0][c];

//     for (int house = 1; house < n; house++)
//     {
//       // Curr house: which color to paint
//       for (int color = 0; color < colors; color++)
//       {
//             int MinAns = Integer.MAX_VALUE;
//             // Exploring rest colors in previous house
//             for (int c = 0; c < colors; c++)
//             {
//               if (c != color)
//                 MinAns = Math.min(dp[house - 1][c], MinAns);
//             }
            
//             dp[house][color] = MinAns + cost[house][color];
//       }
//     }
    
//     int minAns = Integer.MAX_VALUE;
//     for(int c=0; c<colors; c++)
//         minAns = Math.min(minAns, dp[n-1][c]);
//     System.out.println(minAns);
//   }
// }


// O(N ^ 2)
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int colors = scn.nextInt();
    int[][] cost = new int[n][colors];
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < colors; j++)
        cost[i][j] = scn.nextInt();
    }

    int[][] dp = new int[n][colors];
    for (int c = 0; c < colors; c++)
      dp[0][c] = cost[0][c];

    for (int house = 1; house < n; house++)
    {
      int MinAns = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
      for (int c = 0; c < colors; c++)
      {
        if (dp[house - 1][c] <= MinAns) {
          secondMin = MinAns;
          MinAns = dp[house - 1][c];
        }
        else if (dp[house - 1][c] <= secondMin) {
          secondMin = dp[house - 1][c];
        }
      }

      // Curr house: which color to paint
      for (int color = 0; color < colors; color++)
      {

        if(dp[house - 1][color] == MinAns)
            dp[house][color] = secondMin + cost[house][color];
        else
            dp[house][color] = MinAns + cost[house][color];
      }
    }

    int minAns = Integer.MAX_VALUE;
    for (int c = 0; c < colors; c++)
      minAns = Math.min(minAns, dp[n - 1][c]);
    System.out.println(minAns);
  }
}
