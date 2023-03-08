// Добавленный класс не имеет модификаторов доступа как указано в описании к задаче
class Util {

    public static BinaryOperator getBinaryOperator(String string) throws Exception {
        return switch (string) {
            case ("+") -> BinaryOperator.PLUS;
            case ("-") -> BinaryOperator.MINUS;
            case ("*") -> BinaryOperator.MULTIPLY;
            case ("/") -> BinaryOperator.DIVIDE;
            default -> throw new Exception("Недопустимый оператор");
        };
    }

    public static Argument stringToArgument(String argumentString) throws Exception {
        return switch (argumentString.length()) {
            case (1) -> getSingleCharacterArgument(argumentString);
            case (2) -> getTwoCharacterArgument(argumentString);
            case (3) -> getThreeCharacterArgument(argumentString);
            case (4) -> getFourCharacterArgument(argumentString);
            default -> throw new Exception("Недопустимый аргумент");
        };
    }

    public static Integer argumentToInteger(Argument argument) throws Exception {
        return switch (argument) {
            case ONE, ONE_ROMAN -> 1;
            case TWO, TWO_ROMAN -> 2;
            case THREE, THREE_ROMAN -> 3;
            case FOUR, FOUR_ROMAN -> 4;
            case FIVE, FIVE_ROMAN -> 5;
            case SIX, SIX_ROMAN -> 6;
            case SEVEN, SEVEN_ROMAN -> 7;
            case EIGHT, EIGHT_ROMAN -> 8;
            case NINE, NINE_ROMAN -> 9;
            case TEN, TEN_ROMAN -> 10;
            default -> throw new Exception("Один из аргументов не является" +
                    " числом или не попадает в диапазон от 1 до 10 включительно");
        };
    }

    public static boolean isArgumentsSameType(Argument argument1, Argument argument2){
        return (isArgumentArabic(argument1) && isArgumentArabic(argument2)) ||
                (isArgumentRoman(argument1) && isArgumentRoman(argument2));
    }

    public static boolean isArgumentArabic(Argument argument){
        return argument == Argument.ONE ||
                argument == Argument.TWO ||
                argument == Argument.THREE ||
                argument == Argument.FOUR ||
                argument == Argument.FIVE ||
                argument == Argument.SIX ||
                argument == Argument.SEVEN ||
                argument == Argument.EIGHT ||
                argument == Argument.NINE ||
                argument == Argument.TEN;
    }

    public static boolean isArgumentRoman(Argument argument){
        return argument == Argument.ONE_ROMAN ||
                argument == Argument.TWO_ROMAN ||
                argument == Argument.THREE_ROMAN ||
                argument == Argument.FOUR_ROMAN ||
                argument == Argument.FIVE_ROMAN ||
                argument == Argument.SIX_ROMAN ||
                argument == Argument.SEVEN_ROMAN ||
                argument == Argument.EIGHT_ROMAN ||
                argument == Argument.NINE_ROMAN ||
                argument == Argument.TEN_ROMAN;
    }

    public static String intToRoman(int number){
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[number / 1000] + hundreds[(number % 1000) / 100] + tens[(number % 100) / 10] + units[number % 10];
    }

    private static Argument getSingleCharacterArgument(String string) throws Exception {
        return switch (string) {
            case ("1") -> Argument.ONE;
            case ("2") -> Argument.TWO;
            case ("3") -> Argument.THREE;
            case ("4") -> Argument.FOUR;
            case ("5") -> Argument.FIVE;
            case ("6") -> Argument.SIX;
            case ("7") -> Argument.SEVEN;
            case ("8") -> Argument.EIGHT;
            case ("9") -> Argument.NINE;
            case ("I") -> Argument.ONE_ROMAN;
            case ("V") -> Argument.FIVE_ROMAN;
            case ("X") -> Argument.TEN_ROMAN;
            default -> throw new Exception("Недопустимый аргумент");
        };
    }

    private static Argument getTwoCharacterArgument(String string) throws Exception {
        return switch (string) {
            case ("10") -> Argument.TEN;
            case ("II") -> Argument.TWO_ROMAN;
            case ("IV") -> Argument.FOUR_ROMAN;
            case ("VI") -> Argument.SIX_ROMAN;
            case ("IX") -> Argument.NINE_ROMAN;
            default -> throw new Exception("Недопустимый аргумент");
        };
    }

    private static Argument getThreeCharacterArgument(String string) throws Exception {
        return switch (string) {
            case ("III") -> Argument.THREE_ROMAN;
            case ("VII") -> Argument.SEVEN_ROMAN;
            default -> throw new Exception("Недопустимый аргумент");
        };
    }

    private static Argument getFourCharacterArgument(String string) throws Exception {
        return switch (string) {
            case ("VIII") -> Argument.EIGHT_ROMAN;
            default -> throw new Exception("Недопустимый аргумент");
        };
    }
}



