package datastructure;

import java.util.Scanner;

public class MakingAnagrams {
    public static int numberNeeded(String first, String second) {
        int sum = 0;
        int [] alphabet = new int[26];
        for (char c : first.toCharArray()){
            alphabet[c - 'a']++;
        }
        for (char c : second.toCharArray()){
            alphabet[c - 'a']--;
        }
        for (int i : alphabet){
            sum += Math.abs(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
