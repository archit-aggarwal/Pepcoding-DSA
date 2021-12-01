import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        ArrayList<String> ans = getPaths(0, n, m);
        System.out.println(ans.size());
        System.out.println(ans);
        
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
    
    public static ArrayList<String> getPaths(int src, int dest, int moves)
    {
        if(src > dest)
        {
            ArrayList<String> ans = new ArrayList<String>();
            return ans;    
        }
        
        if(src == dest)
        {
            ArrayList<String> ans = new ArrayList<String>();
            ans.add("");
            return ans;
        }
        
        
        ArrayList<String> curr = new ArrayList<String>();
        for(int jump=1; jump<=moves; jump++)
        {
            ArrayList<String> temp = getPaths(src + jump, dest, moves);
            
            for(int j=0; j<temp.size(); j++)
                curr.add(jump + temp.get(j));
        }
        
        return curr;
    }
    
}
