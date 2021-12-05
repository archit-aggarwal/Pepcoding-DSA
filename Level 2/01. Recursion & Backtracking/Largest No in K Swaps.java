import java.io.*;
import java.util.*;

public class Main {

	static String max;
	
	public static String swap(String str, int i, int j){
	    String res = "";
	    for(int k=0; k<str.length(); k++){
	        if(k == i)
	            res = res + str.charAt(j);
	        else if(k == j)
	            res = res + str.charAt(i);
	        else res = res + str.charAt(k);
	    }
	    return res;
	}
	
	public static void findMaximum(String str, int k) {
	   if(Integer.parseInt(str) > Integer.parseInt(max)) {
	       max = str;
	   }
	   
	   if(k == 0) return;
	   
	   for(int i=0; i<str.length() - 1; i++){
	       for(int j = i + 1; j < str.length(); j++){
	           if(str.charAt(i) < str.charAt(j)){
	               str = swap(str, i, j);
	               findMaximum(str, k - 1);
	               str = swap(str, i, j);
	           }
	       }
	   }
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

}
