import java.io.*;
import java.util.*;

public class Main {

	public static String solution(String str){
		    StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length()-1; i++)
        {
            sb.append(str.charAt(i)); // append first character in pair
            sb.append(str.charAt(i+1) - str.charAt(i)); // append difference in ASCII values in pair
        }
        
        sb.append(str.charAt(str.length() - 1)); // append last character (corner case) 
		    return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
