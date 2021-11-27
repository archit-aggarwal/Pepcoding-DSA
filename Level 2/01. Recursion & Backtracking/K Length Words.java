// K Length Words - I (Repition Not Allowed)
import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords(int cc, String ustr, int ssf, int ts, Character[] spots) {
    if (cc == ustr.length()) {
      if(ssf == ts){
        for(int i = 0; i < spots.length; i++){
          System.out.print(spots[i]);
        }
        System.out.println();
      }
      return;
    }

    char ch = ustr.charAt(cc);
    for(int i = 0; i < spots.length; i++){
      if(spots[i] == null){
        spots[i] = ch;
        generateWords(cc + 1, ustr, ssf + 1, ts, spots);
        spots[i] = null;
      }
    }
    generateWords(cc + 1, ustr, ssf + 0, ts, spots);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    Character[] spots = new Character[k];
    generateWords(0, ustr, 0, k, spots);
  }

}

// K Length Words - II (Repition Not Allowed)
import java.io.*;
import java.util.*;

public class Main {

  public static void permutation(String res, String ustr, HashSet<Character> unique, int k){
      if(res.length() == k){
          System.out.println(res);
          return;
      }
      
      for(Character ch: ustr.toCharArray()){
          if(unique.contains(ch) == true){
              unique.remove(ch);
              permutation(res + ch, ustr, unique, k);
              unique.add(ch);
          }
      }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    
    permutation("", ustr, unique, k); 
  }

}

// K Length Words - III (Repition Allowed)
import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords(int cc, String str, int ssf, int ts, Character[] spots,
      HashMap<Character, Integer> lastOccurence) {
    if (cc == str.length()) {
      if (ssf == ts) {
        for (char ch : spots) {
          System.out.print(ch);
        }
        System.out.println();
      }
      return;
    }

    char ch = str.charAt(cc);
    int lo = lastOccurence.get(ch);
    for (int i = lo + 1; i < spots.length; i++) {
      if (spots[i] == null) {
        spots[i] = ch;
        lastOccurence.put(ch, i);
        generateWords(cc + 1, str, ssf + 1, ts, spots, lastOccurence);
        lastOccurence.put(ch, lo);
        spots[i] = null;
      }
    }
    if (lastOccurence.get(ch) == -1) {
      generateWords(cc + 1, str, ssf + 0, ts, spots, lastOccurence);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    Character[] spots = new Character[k];
    HashMap<Character, Integer> lastOccurence = new HashMap<>();
    for (char ch : str.toCharArray()) {
      lastOccurence.put(ch, -1);
    }

    generateWords(0, str, 0, k, spots, lastOccurence);
  }

}
                        
// K Length Words - IV (Repition Allowed)
import java.io.*;
import java.util.*;

public class Main {

  public static void permutation(String res, String ustr, HashMap<Character, Integer> unique, int k){
      if(res.length() == k){
          System.out.println(res);
          return;
      }
      
      for(Character ch: ustr.toCharArray()){
          int oldFreq = unique.get(ch);
          if(oldFreq > 0){
              unique.put(ch, oldFreq - 1);
              permutation(res + ch, ustr, unique, k);
              unique.put(ch, oldFreq);
          }
      }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }
    
    permutation("", ustr, unique, k); 
  }

}
