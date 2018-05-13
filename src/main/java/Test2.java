import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {


    static boolean twins2(String a, String b) {
        if (a.length() == b.length()) {
            if (containsSameChars(a, b)) {
                char[] charsOfA = a.toCharArray();
                char[] charsOfB = b.toCharArray();
                StringBuilder oddOfA = new StringBuilder();
                StringBuilder evenOfA = new StringBuilder();
                StringBuilder oddOfB = new StringBuilder();
                StringBuilder evenOfB = new StringBuilder();
                for (int i = 0; i < charsOfA.length; i++) {
                    if (i % 2 == 0) {
                        oddOfA.append(charsOfA[i]);
                        oddOfB.append(charsOfB[i]);
                    } else {
                        evenOfA.append(charsOfA[i]);
                        evenOfB.append(charsOfB[i]);
                    }
                }
                if (containsSameChars(oddOfA.toString(), oddOfB.toString())
                        && containsSameChars(evenOfA.toString(), evenOfB.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean containsSameChars(String s1, String s2) {
        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }



    public static void main(String[] args) {

        System.out.println(twins2("cdab", "abcd"));
        System.out.println(twins2("dcba", "abcd"));


//        {
//            if(firstWord.indexOf(c) > -1 && secondWord.indexOf(c) > -1)
//                flag = "YES";
//        }
//
//
//
//        int i = 1;
//        if (i++ == --i) {
//            System.out.printf("0");
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

