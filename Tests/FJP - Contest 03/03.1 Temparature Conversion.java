import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        float f = scn.nextFloat();
        float c = ((f - 32.0f) * 5.0f) / 9.0f;
        System.out.println(c);
    }
}