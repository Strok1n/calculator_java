import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);

            // Вводите строку для обработки в консоль и нажмите Enter для вывода результата.
            // Если в строке нет ошибок синтаксиса, то она выведет результат и продолжит работу.
            // Если есть ошибки, программа выбросит исключение и прекратит работу.

            while (true) {
                System.out.println(calc(scanner.nextLine()));
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static String calc(String input) throws Exception {

        // проверка на пробелы
        if (!input.contains(" ")) throw new Exception("Аргументы должны быть отделены от символа операции пробелами");

        // проверка на отсутствие дробных чисел (требование 4)
        if (input.contains(".") || input.contains(",")) throw new Exception("Строка ввода не должна содержать символы . или ,");


        // находим символы пробелов и по ним находим аргументы и символ операции
        int indexOfFirstSpaceSymbol = input.indexOf(" ");
        int indexOfSecondSpaceSymbol = input.lastIndexOf(" ");
        int indexOfBinaryOperationSymbol = (indexOfFirstSpaceSymbol + indexOfSecondSpaceSymbol) / 2;

        String firstArgumentString = input.substring(0, indexOfFirstSpaceSymbol);
        String secondArgumentString = input.substring(indexOfSecondSpaceSymbol + 1);


        BinaryOperator operator = Util.getBinaryOperator(input.substring(indexOfBinaryOperationSymbol, indexOfBinaryOperationSymbol + 1));
        Argument firstArgument = Util.stringToArgument(firstArgumentString);
        Argument secondArgument = Util.stringToArgument(secondArgumentString);

        // проверка требования однородности вводимых чисел (требование 5)
        if(!Util.isArgumentsSameType(firstArgument, secondArgument))
            throw new Exception("Оба аргумента одновременно не являются арабскими или римскими");

        int firstArgumentInteger = Util.argumentToInteger(firstArgument);
        int secondArgumentInteger = Util.argumentToInteger(secondArgument);
        int resultInteger = getResult(firstArgumentInteger,
                secondArgumentInteger, operator);

        String result = Integer.toString(resultInteger);

        if (Util.isArgumentRoman(firstArgument))
            if (resultInteger < 1) // требование 10
                throw new Exception("Результат работы программы с римскими числами меньше единицы");
            else // если аргументы римские, то ответ будет выведен римским числом (требование 6)
                result =  Util.intToRoman(resultInteger);

        return result;

    }
    private static Integer getResult(int a, int b, BinaryOperator operator) throws Exception {
        return switch (operator) {
            case PLUS -> a + b;
            case MINUS -> a - b;
            case MULTIPLY-> a * b;
            case DIVIDE -> a / b;
            // требование 8
            default -> throw new Exception("Бинарный оператор не является одим из символов: +, -, *, /");
        };
    }
}