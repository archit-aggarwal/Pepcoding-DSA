import java.io.*;
import java.util.*;

public class Main {

  public static String compression1(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++)
    {
      if ((i == 0) || (str.charAt(i) != str.charAt(i - 1)))
      {
        // First occurence -> append the char
        sb.append(str.charAt(i));
      }
    }
    return sb.toString();
  }

  public static String compression2(String str) {
    StringBuilder sb = new StringBuilder();
    int counter = 0;
    for (int i = 0; i < str.length(); i++)
    {
      if ((i == 0) || (str.charAt(i) != str.charAt(i - 1)))
      {
        // Previous Group -> Frequency
        if (counter > 1 && i > 0)
          sb.append(counter);

        // Current Group -> First Occurence Letter
        sb.append(str.charAt(i));

        counter = 1;
      }
      else
      {
        counter++;
      }
    }

    // last group frequency
    if (counter > 1) sb.append(counter);

    return sb.toString();
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(compression1(str));
    System.out.println(compression2(str));
  }

}
