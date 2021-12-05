import java.io.*;
import java.util.*;

public class Main {

  public static boolean canPlaceHori(int r, int c, char[][] crossword, String word){
      if(c - 1 >= 0 && crossword[r][c - 1] != '+'){
          // two words overlapping horizontally
          // word not completely fill from left side
          return false;
      }
      
      for(int i=0; i<word.length(); i++){
          char ch1 = word.charAt(i);
          
          if(c + i == crossword[0].length){
              // word not completely fill from right side
              return false;
          }
          
          char ch2 = crossword[r][c + i];
          if(ch2 == '+' || (ch2 != ch1 && ch2 != '-')){
              return false;
          }
      }
      
      if(c + word.length() < crossword[0].length && crossword[r][c + word.length()] != '+'){
          return false;
      }
      return true;
  }
  
  public static boolean canPlaceVert(int r, int c, char[][] crossword, String word){
      if(r - 1 >= 0 && crossword[r - 1][c] != '+'){
          // two words overlapping vertically
          // word not completely fill from top side
          return false;
      }
      
      for(int i=0; i<word.length(); i++){
          char ch1 = word.charAt(i);
          
          if(r + i == crossword.length){
              // word not completely fill from bottom side
              return false;
          }
          
          char ch2 = crossword[r + i][c];
          if(ch2 == '+' || (ch2 != ch1 && ch2 != '-')){
              return false;
          }
      }
      
      if(r + word.length() < crossword.length && crossword[r + word.length()][c] != '+'){
          return false;
      }
      
      return true;      
  }
  
  public static String placeHori(int r, int c, char[][] crossword, String word){
      String oldWord = "";
      for(int i=0; i<word.length(); i++){
          oldWord += crossword[r][c + i];
          crossword[r][c + i] = word.charAt(i);
      }
      return oldWord;
  }
  
  public static String placeVert(int r, int c, char[][] crossword, String word){
      String oldWord = "";
      for(int i=0; i<word.length(); i++){
          oldWord += crossword[r + i][c];
          crossword[r + i][c] = word.charAt(i);
      }
      return oldWord;
  }
  
  
  public static void solution(char[][] crossword, String[] words, int vidx) {
      if(vidx == words.length){
          print(crossword);
          return;
      }
      
      for(int i=0; i<crossword.length; i++){
          for(int j=0; j<crossword[0].length; j++){
              if(crossword[i][j] == '-' || crossword[i][j] == words[vidx].charAt(0)){
                  
                  // horizontal
                  if(canPlaceHori(i, j, crossword, words[vidx])){
                      String oldWord = placeHori(i, j, crossword, words[vidx]);
                      solution(crossword, words, vidx + 1);
                      placeHori(i, j, crossword, oldWord); 
                      // placing the old word => unplacing the new word (horizontally)
                  } 
                  
                  // vertical
                 if(canPlaceVert(i, j, crossword, words[vidx])) {
                     String oldWord = placeVert(i, j, crossword, words[vidx]);
                     solution(crossword, words, vidx + 1);
                     placeVert(i, j, crossword, oldWord);              
                     // placing the old word => unplacing the new word (vertically)
                 }
              }
          }
      }
  }


  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}
