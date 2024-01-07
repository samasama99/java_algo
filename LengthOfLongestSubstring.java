import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    // first solution no help
    static public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        LinkedHashSet<Character> set = new LinkedHashSet<>(s.length());
        int max = 0;

        for (char c : chars) {
            while (set.contains(c)) {
                Iterator<Character> iterator = set.iterator();
                iterator.next();
                iterator.remove();
            }
            set.add(c);
            max = Integer.max(set.size(), max);
        }

        return max;
    }

    // second solution using help
    static public int lengthOfLongestSubstringV2(String s) {
        int len = s.length();
        Set<Character> set = new LinkedHashSet<Character>(len);

        int i = 0;
        int j = 0;
        int max = 0;
        int currentMax = 0;

        while (i < len && j < len) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                currentMax--;
                i++;
            } else {
                set.add(s.charAt(j));
                currentMax++;
                max = Integer.max(currentMax, max);
                j++;
            }
        }

        return max;
    }

    // third solution using help
    static public int lengthOfLongestSubstringV3(String s) {
        int len = s.length();
        int[] histogram = new int[128];
        Arrays.fill(histogram, -1);
        int i = 0;
        int j = 0;
        int max = 0;

        while (i < len && j < len) {
            char c = s.charAt(j);
            if (histogram[c] != -1) {
                histogram[s.charAt(i)] = -1;
                i++;
            } else {
                histogram[c] = j;
                j++;
                max = Integer.max(j - i + 1, max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String test = "pwwkew";
        System.out.println(lengthOfLongestSubstring(test));
        System.out.println(lengthOfLongestSubstringV2(test));
        System.out.println(lengthOfLongestSubstringV3(test));
    }
}
