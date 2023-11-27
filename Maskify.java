public class Maskify {
    public static String maskify(String str) {
        if (str.length() <= 4) return str;
        return new StringBuilder(str)
                .replace(
                        0,
                        str.length() - 4,
                        "#".repeat(str.length() - 4)
                ).toString();
    }
}
