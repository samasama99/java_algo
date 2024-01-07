import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberOfSubstrings {
    static public int numberOfSubstrings(String s) {
        return (int) BackwardPermutations(s)
                .parallelStream()
                .flatMap(b -> ForwardPermutations(b).stream())
                .peek(System.out::println)
                .collect(Collectors.toList())
                .stream()
                .map(NumberOfSubstrings::StringToSet)
                .map(Set::size)
                .filter(l -> l == 3)
                .count();
    }

    static Set<Character> StringToSet(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }
    static List<String> ForwardPermutations(String s) {
        List<String> permutations = new ArrayList<>();
        StringBuilder current = new StringBuilder(s);
        permutations.add(current.toString());
        for (int i = 0; i < s.length() - 1; i++) {
            current.deleteCharAt(0);
            permutations.add(current.toString());
        }
        return permutations;
    }

    static List<String> BackwardPermutations(String s) {
        List<String> permutations = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        permutations.add(current.toString());
        for (int i = 0; i < s.length(); i++) {
            current.append(s.charAt(i));
            permutations.add(current.toString());

        }
        return permutations;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }
}
