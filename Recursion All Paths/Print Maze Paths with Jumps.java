import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        printMazePaths(0, 0, n - 1, m - 1, "");
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr > dr || sc > dc){
            return;
        }

        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }

        for(int move = 1; move <= dc - sc; move++){
            printMazePaths(sr, sc + move, dr, dc, psf + "h" + move);
        }
        
        for(int move = 1; move <= dr - sr; move++){
            printMazePaths(sr + move, sc, dr, dc, psf + "v" + move);
        }

        for(int move = 1; move <= dc - sc && move <= dr - sr; move++){
            printMazePaths(sr + move, sc + move, dr, dc, psf + "d" + move);
        }
    }
}
