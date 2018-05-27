
public class BalanceBracets {


    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int[] returnArray = new int[expressions.length];
        for (int i = 0; i < maxReplacements.length; i++) {
            returnArray[i] = 0;
        }

        for (int i = 0; i < expressions.length; i++) {
            int count = i;
            String eachData = expressions[count];

            String checkString = expressions[count];
            int replacementCount = 0;

            boolean continueLoop = true;
            while (checkString.length() >= 1 && continueLoop) {
                int openingCount = checkString.length() - checkString.replace("<", "").length();
                int closingCount = checkString.length() - checkString.replace(">", "").length();

                if (openingCount > closingCount) {
                    replacementCount = maxReplacements[count] + 1;
                    continueLoop = false;
                } else if (checkString.charAt(0) == '>') {
                    replacementCount++;
                    checkString = checkString.substring(1);
                } else {
                    checkString = checkString.replace("<>", "");
                }
            }

            if (replacementCount <= maxReplacements[count]) {
                returnArray[count] = 1;
            }
        }

        return returnArray;
    }


    public static void main(String[] args) {
        String[] expressions = new String[]{"<<><>><", "><><><"};
        int[] replacements = new int[]{2, 2};

        final int[] ints = balancedOrNot(expressions, replacements);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}

