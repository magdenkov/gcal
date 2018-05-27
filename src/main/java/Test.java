import java.io.IOException;
import java.util.*;

public class Test {


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

        for (int i = 0; i < aChars.size() - 1; i++) {
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

    public static int arraySearch(Character character, List<Character> aChars) {
        int i = 0;
        for (Character c : aChars) {
            if (c == character) return i;
            i++;
        }
        return -1;
    }


    public static List<Character> toCharSet(String word) {
        List<Character> charSet = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            charSet.add(word.charAt(i));
        }
//        Collections.sort(charSet);
        return charSet;

    }


    public static void main(String[] args) {

        System.out.println(compare("cdab", "abcd"));
        System.out.println(compare("dcba", "abcd"));


//        {
//            if(firstWord.indexOf(c) > -1 && secondWord.indexOf(c) > -1)
//                flag = "YES";
//        }
//
//
//
//        int i = 1;
//        if (i++ == --i) {
//            System.out.printf("0");  // print 0
//        } else {
//            System.out.println("1");
//        }


    }

    static class Key {
        @Override
        public int hashCode() {
            return 42;
        }
    }

}

class TaskBase {
    int getStatusCode(Object obj) throws NullPointerException {
        if (obj != null ) {
            return 1;
        } else {
            return 0;
        }
    }
}

class ParallelTask extends TaskBase {

    @Override
    int getStatusCode(Object obj) throws ArithmeticException {
        return super.getStatusCode(obj);
    }
}
