package leetcode;

public class FindPrefix {
    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        System.out.println("Result: " + findPrefix(str));
    }

     private static String findPrefix(String[] str) {
        if (str.length == 0)
            return "";

        String prefix = str[0];
        for (int i = 0; i < str.length; i++) {
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
