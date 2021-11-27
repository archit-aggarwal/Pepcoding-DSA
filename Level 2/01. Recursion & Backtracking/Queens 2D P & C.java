// Permutations - 2D as 2D - Box Choses
import java.io.*;
import java.util.*;

public class Main {
    public static void queensPermutations(int qpsf, int tq, int cellNo, String mat, boolean[] vis){
        if(cellNo == tq * tq){
            if(qpsf == tq){
                System.out.println(mat);
                System.out.println();
            }    
            return;
        }
        
        if(cellNo % tq == tq - 1){
            // Apni Row ka last element, agli row ke pehle element par jana hai
            for(int i=0; i<tq; i++){
                if(vis[i] == false){
                    vis[i] = true;
                    queensPermutations(qpsf + 1, tq, cellNo + 1, mat + "q" + (i + 1) + "	", vis); // yes
                    vis[i] = false;
                }
            }
            queensPermutations(qpsf, tq, cellNo + 1, mat + "-	", vis); // no
        } else {
            for(int i=0; i<tq; i++){
                if(vis[i] == false){
                    vis[i] = true;
                    queensPermutations(qpsf + 1, tq, cellNo + 1, mat + "q" + (i + 1) + "	" , vis); // yes
                    vis[i] = false;
                }
            }
            queensPermutations(qpsf, tq, cellNo + 1, mat + "-	", vis); // no
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, "", queens);
    }
}

// Permutations - 2D As 2D - Queen Chooses
import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        if(qpsf == tq){
            for(int row = 0; row < chess.length; row++){
                for(int col = 0; col < chess.length; col++){
                    System.out.print(chess[row][col] != 0? "q"+ chess[row][col] + "\t": "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int row = 0; row < chess.length; row++){
            for(int col = 0; col < chess.length; col++){
                if(chess[row][col] == 0){
                    chess[row][col] = qpsf + 1;
                    queensPermutations(qpsf + 1, tq, chess);
                    chess[row][col] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess);
    }
}



// Combinations - 2D As 2D - Queen Choses
import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, Character[][] chess, int lastQueenRow, int lastQueenCol){
        if(qpsf == tq){
            for(int i=0; i<tq; i++) {
                for(int j=0; j<tq; j++){
                    System.out.print(chess[i][j] + "	");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int j=lastQueenCol + 1; j < tq; j++){
            if(chess[lastQueenRow][j] == '-'){
                chess[lastQueenRow][j] = 'q';
                queensCombinations(qpsf + 1, tq, chess, lastQueenRow, j);
                chess[lastQueenRow][j] = '-';
            }
        }
        
        for(int i=lastQueenRow + 1; i < tq; i++){
            for(int j=0; j<tq; j++){
                if(chess[i][j] == '-'){
                    chess[i][j] = 'q';
                    queensCombinations(qpsf + 1, tq, chess, i, j);
                    chess[i][j] = '-';
                }   
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Character[][] chess = new Character[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                chess[i][j] = '-';
            }
        }
        
        queensCombinations(0, n, chess, 0, -1);
    }
}

// Combinations - 2D As 1D - Queen Chooses
import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, Character[][] chess, int lastcellNo){
        if(qpsf == tq){
            for(int i=0; i<tq; i++) {
                for(int j=0; j<tq; j++){
                    System.out.print(chess[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int c=lastcellNo + 1; c < tq * tq; c++){
            int rowNo = c / tq;
            int colNo = c % tq;
            
            chess[rowNo][colNo] = 'q';
            queensCombinations(qpsf + 1, tq, chess, c);
            chess[rowNo][colNo] = '-';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Character[][] chess = new Character[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                chess[i][j] = '-';
            }
        }
        queensCombinations(0, n, chess, -1);
    }
}

// Combinations - 2D As 2D - Box Chooses
import java.io.*;
import java.util.*;

public class Main {

    // qpsf -> Queens placed so far, tq -> total Queens
    public static void queensCombinations(int qpsf, int tq, int row, int col, String mat){
        if(row == tq){
            if(qpsf == tq){
                System.out.println(mat);
            }    
            return;
        }
        
        if(col == tq - 1){
            // Apni Row ka last element, agli row ke pehle element par jana hai
            
            queensCombinations(qpsf + 1, tq, row + 1, 0, mat + 'q' + ''); // yes
            queensCombinations(qpsf, tq, row + 1, 0, mat + '-' + ''); // no
        } else {
            queensCombinations(qpsf + 1, tq, row, col + 1, mat + 'q'); // yes
            queensCombinations(qpsf, tq, row, col + 1, mat + '-'); // no
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}

// Combinations - 2D As 1D - Box Chooses
import java.io.*;
import java.util.*;

public class Main {

    // qpsf -> Queens placed so far, tq -> total Queens
    public static void queensCombinations(int qpsf, int tq, int cellNo, String mat){
        if(cellNo == tq * tq){
            if(qpsf == tq){
                System.out.println(mat);
            }    
            return;
        }
        
        if(cellNo % tq == tq - 1){
            // Apni Row ka last element, agli row ke pehle element par jana hai
            queensCombinations(qpsf + 1, tq, cellNo + 1, mat + 'q' + ''); // yes
            queensCombinations(qpsf, tq, cellNo + 1, mat + '-' + ''); // no
        } else {
            queensCombinations(qpsf + 1, tq, cellNo + 1, mat + 'q'); // yes
            queensCombinations(qpsf, tq, cellNo + 1, mat + '-'); // no
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        queensCombinations(0, n, 0, "");
    }
}
