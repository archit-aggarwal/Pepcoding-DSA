import java.io.*;
import java.util.*;

public class Main {

    public static boolean isPalindrome(String str)
    {
        int left = 0, right = str.length() - 1;
        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
                return false;
            
            left++; right--;
        }
        return true;
    }
    
	public static void solution(String str){
		Scanner scn = new Scanner(System.in);
		for(int st=0; st< str.length(); st++)
		{
		    for(int end=st; end<str.length(); end++)
		    {
		        String subString = 
		          str.substring(st, end + 1);
		        
		        if(isPalindrome(subString) == true)
		            System.out.println(subString);
		    }
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}
