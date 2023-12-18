import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class ex01 {
}

class Result {

    /*
     * Complete the 'sortRoman' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY names as parameter.
     */

    static Map<Character, Integer> fromRomanToArabic = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100
    );

//    static int romanToArabic(String roman) {
//        int[] chars = roman.chars().toArray();
//        StringBuilder tmp = new StringBuilder();
//        int sum = 0;
//        for (int c : chars) {
//            if (c == 'X') {
//                if (tmp.toString().equals("I")) {
//                    sum += fromRomanToArabic.get("IX");
//                    tmp = new StringBuilder();
//                } else {
//                    tmp.append("X");
//                }
//            } else if (c == 'L') {
//                if (tmp.toString().equals("X")) sum = 40;
//                else sum += fromRomanToArabic.get("L");
//                tmp = new StringBuilder();
//            } else {
//                tmp.append((char) c);
//            }
//        }
//        if (!tmp.isEmpty())
//            sum += fromRomanToArabic.get(tmp.toString());
//        return sum;
//    }

    static int romanToArabicV2(String roman) {
        char[] chars = new StringBuilder(roman).reverse().toString().toCharArray();
        int sum = 0;
        Optional<Integer> previous = Optional.empty();
        for (char c : chars) {
            int current = fromRomanToArabic.get(c);
            if (previous.isPresent() && current < previous.get()) {
                sum -= current;
            } else {
                sum += current;
            }
            previous = Optional.of(current);
        }
        return sum;
    }
    static List<String> sortRomanV2(List<String> names) {
        return names.stream().sorted(
                Comparator
                        .comparing((String name) -> name.split(" ")[0])
                        .thenComparing(name -> romanToArabicV2(name.split(" ")[1]))
        ).toList();
    }


//    static List<String> sortRoman(List<String> names) {
//        return names.parallelStream()
//                .map(s -> s.split(" "))
//                .collect(
//                        collectingAndThen(
//                                groupingBy(
//                                        s -> s[0],
//                                        collectingAndThen(
//                                                mapping(
//                                                        s -> s[1],
//                                                        mapping(roman -> new Pair<>(romanToArabicV2(roman), roman), toList())
//                                                ),
//                                                pairs -> pairs
//                                                        .stream()
//                                                        .sorted(Comparator.comparing(Pair<Integer, String>::first))
//                                                        .toList()
//                                        )
//                                ),
//                                map -> map
//                                        .entrySet()
//                                        .parallelStream()
//                                        .sorted(Map.Entry.comparingByKey())
//                                        .flatMap(e -> e.getValue().stream().map(n -> e.getKey() + " " + n.second))
//                                        .toList()
//                        )
//                );
//    }



    public static void main(String[] args) {

        List<String> names = List.of(
                "Maximus I",
                "Maximus IX",
                "Isabella IV",
                "Atticus V",
                "Valentina VI",
                "Maximus XL",
                "Aurelia VIII",
                "Cassius IX",
                "Octavia X",
                "Isabella II"
        );

//        System.out.println(romanToArabicV2("II"));
//        System.out.println(romanToArabicV2("IX"));
//        System.out.println(romanToArabicV2("IV"));
//        System.out.println(romanToArabicV2("VIII"));
//        System.out.println(romanToArabicV2("XL"));
//        System.out.println(romanToArabic("II"));
//        System.out.println(romanToArabic("IX"));
//        System.out.println(romanToArabic("IV"));
//        System.out.println(romanToArabic("VIII"));
//        System.out.println(romanToArabic("XL"));
//        sortRoman(names).forEach(System.out::println);
        sortRomanV2(names).forEach(System.out::println);
    }

//    record Pair<T, U>(T first, U second) {
//    }
//
}

//    public static List<String> sortRoman(List<String> names) {
//        record Pair(String name, String romanNumber) {};
//        names.stream()
//                .map(s -> s.split(" "))
//                .map(name -> new Pair(name[0], name[1]))
//                .collect(Collectors.groupingBy(Pair::name))
//                .forEach(System.out::println);


//        List<String> romanNumbers = names
//                .stream()
//                .map(s -> s.split(" ")[1])
//                .toList();
//        Map<String, Integer> namesMap = new HashMap<>();
//        for (String s : romanNumbers) {
//            int[] chars = s.chars().toArray();
//            StringBuilder tmp = new StringBuilder();
//            int sum = 0;
//            for (int c : chars) {
//                if (c == 'X') {
//                    if (tmp.toString().equals("I")) sum = fromRomanToArabic.get("IX");
//                    tmp = new StringBuilder();
//                } else if (c == 'L') {
//                    if (tmp.toString().equals("X")) sum = 40;
//                    else sum += 50;
//                    tmp = new StringBuilder();
//                } else {
//                    tmp.append(c);
//                }
//            }
//            if (!tmp.isEmpty())
//                sum += fromRomanToArabic.get(tmp.toString());
//            namesMap.put(s, sum);
//        }
//
//        return namesMap
//                .entrySet()
//                .stream()
//                .sorted(Comparator
//                        .<Map.Entry<String, Integer>, String>comparing(entry -> entry.getKey().split(" ")[1])
//                        .thenComparing(Map.Entry::getValue))
//                .map(Map.Entry::getKey)
//                .toList();
//    }
