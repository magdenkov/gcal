import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tester {

    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static boolean[] twins(String[] a, String[] b) {
        boolean[] result = new boolean[a.length];
        for (int i = 0; i < a.length - 1; i++) {
            result[i] = compare(a[i], b[i]);

        }
        return result;
    }

    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        List<Character> aChars = toCharSet(a);
        List<Character> bChars = toCharSet(b);

        for (int i = 0; i < aChars.size(); i++) {
            int bKey = arraySearch(aChars.get(i), bChars);
            if (bKey < 0) {
                return false;
            }
            if ((i % 2 == 0 && bKey % 2 == 0) || (i % 2 != 0 && bKey % 2 != 0)) {
                return true;
            } else if ((i % 2 == 0 && bKey % 2 != 0) || (i % 2 != 0 && bKey % 2 == 0)) {
                return false;
            }

        }
        return false;
    }

    public static List<Character> toCharSet(String word) {
        List<Character> charSet = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            charSet.add(word.charAt(i));
        }
//        Collections.sort(charSet);
        return charSet;

    }


    public static int arraySearch(Character character, List<Character> aChars) {
        int i = 0;
        for (Character c : aChars) {
            if (c == character) return i;
            i++;
        }
        return -1;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine().trim());
        String[] a = new String[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextLine();
        }

        int m = Integer.parseInt(in.nextLine().trim());
        String[] b = new String[m];
        for(int i = 0; i < m; i++) {
            b[i] = in.nextLine();
        }

        // call twins function
        boolean[] results = twins(a, b);

        for(int i = 0; i < results.length; i++) {
            System.out.println(results[i]? "Yes" : "No");
        }
    }
}