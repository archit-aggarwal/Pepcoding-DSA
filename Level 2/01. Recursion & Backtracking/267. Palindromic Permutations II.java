import java.io.*;
import java.util.*;

public class Main {

	public static void generatepw(int cB, HashMap<Character, Integer> freq, StringBuilder permutation) {
		if(cB == permutation.length() / 2){
		    System.out.println(permutation);
		    return;
		}
		
		for(Character ch: freq.keySet()){
		    if(freq.get(ch) > 0){
		        
		        int oldFreq = freq.get(ch);
		        freq.put(ch, oldFreq - 2);
		        permutation.setCharAt(cB, ch);
		        permutation.setCharAt(permutation.length() - 1 - cB, ch);
		        
		        generatepw(cB + 1, freq, permutation);
		        
		        permutation.setCharAt(cB, '0');
		        permutation.setCharAt(permutation.length() - 1 - cB, '0');
		        freq.put(ch, oldFreq);
		    }
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		
		
		HashMap<Character, Integer> freq = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);
		}
		
		Character oddFreqChar = '0';
		for(Character ch: freq.keySet()){
		    if(freq.get(ch) % 2 == 1){
		        if(oddFreqChar != '0'){
		            System.out.println("-1");
		            return;
		        }
		        oddFreqChar = ch;
		    }    
		}
		
		StringBuilder permutation = new StringBuilder("");
		for(int i=0; i<str.length(); i++){
		    permutation.append("0");
		}
		
		if(str.length() % 2 == 1){
		    permutation.setCharAt(str.length() / 2, oddFreqChar);
		    freq.put(oddFreqChar, freq.getOrDefault(oddFreqChar, 0) - 1);
		}
		
		generatepw(0, freq, permutation);
	}
	
}
