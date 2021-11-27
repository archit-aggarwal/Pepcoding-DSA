// Combination - I (Repition Not Allowed)
import java.io.*;
import java.util.*;

public class Main {

  public static void generateSelection(int i, String ustr, int ssf, int ts, String asf) {
    if (i == ustr.length()) {
      if(ssf == ts){
        System.out.println(asf);
      }
      return;
    }

    char ch = ustr.charAt(i);
    generateSelection(i + 1, ustr, ssf + 1, ts, asf + ch);
    generateSelection(i + 1, ustr, ssf + 0, ts, asf + "");
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

    generateSelection(0, ustr, 0, k, "");
  }

// Combination - II (Repition Not Allowed)
import java.io.*;
import java.util.*;

public class Main {

  public static void combination(ArrayList<Character> chs, int lastIdx, String res, int k){
    if(res.length() == k){
        System.out.println(res);
        return;
    }
    
    for(int i=lastIdx + 1; i<chs.size(); i++){
        combination(chs, i, res + chs.get(i), k);
    }    
  }
  
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int k = scn.nextInt();
    
    HashSet<Character> uniq = new HashSet<>();
    ArrayList<Character> chs = new ArrayList<>();
    
    for(int i=0; i<str.length(); i++){
        if(uniq.contains(str.charAt(i)) == false){
            chs.add(str.charAt(i));
        }
        uniq.add(str.charAt(i));
    }
    
    combination(chs, -1, "", k);
  }

}

// Combination - III (Repition Allowed)
import java.io.*;
import java.util.*;

public class Main {

public static void combination(int currentChar, String ustr, HashMap<Character, Integer> freq, String res, int k){
    if(res.length() == k){
        System.out.println(res);
        return;
    }
    
    if(currentChar == ustr.length()){
        return;
    }
    
    int val = freq.get(ustr.charAt(currentChar));
    for(int i=val; i>=0; i--){
        if(i + res.length() > k){
            continue;
        }
        
        String newRes = res;
        for(int j=1; j<=i; j++){
            newRes = newRes + ustr.charAt(currentChar);
        }
        
        combination(currentChar + 1, ustr, freq, newRes, k);
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
    
    combination(0, ustr, unique, "", k);
  }

}

// Combination - IV (Repition Allowed)
import java.io.*;
import java.util.*;

public class Main {

  public static void generateSelection(String ustr, int cs, int ts, int lc, HashMap<Character, Integer> freq, String asf) {
    if (cs > ts) {
      System.out.println(asf);
      return;
    }
    if(lc == ustr.length()){
        return;
    }

    for (int i = lc; i < ustr.length(); i++) {
        int oldFreq = freq.get(ustr.charAt(i));
        if(oldFreq > 0){
            freq.put(ustr.charAt(i), oldFreq - 1);
            generateSelection(ustr, cs + 1, ts, i, freq, asf + ustr.charAt(i));
            freq.put(ustr.charAt(i), oldFreq);
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

    generateSelection(ustr, 1, k, 0, unique, "");
  }

}
