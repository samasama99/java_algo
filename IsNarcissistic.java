public class IsNarcissistic {
    public static boolean isNarcissistic(int number) {
        String _number = String.valueOf(number);
        int length = _number.length();
        return _number.chars()
                .map(Character::getNumericValue)
                .reduce(0, (acc, n) -> (int) Math.pow(n, length) + acc) == number;
    }

}
