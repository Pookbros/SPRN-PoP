
import java.util.NoSuchElementException;

public class OperatorProcessor {

    static boolean commentMode = false;
    private static final int[] randomNumber = new int[] {1804289383,846930886,1681692777, 1714636915, 1957747793, 424238335, 719885386,
            1649760492, 596516649, 1189641421, 1025202362, 1350490027, 783368690, 1102520059, 2044897763, 1967513926,
            1365180540, 1540383426, 304089172, 1303455736, 35005211, 521595368, 1804289383 };
    private static  int randomSeed = 0;

    public static String processEquals() {
        Integer currentAnswer = Stack.peekNumber();

        if (currentAnswer == null)
            return "Stack empty.";
        else
            return formatOutput(currentAnswer);
    }

    public static void process(String operator) {
        // Using long for the result so the code can check whether the value is higher than the max or min int value
        long result;

        switch (operator) {
            case Operators.PLUS:
                checkStackLength();
                result = plus(Stack.removeNumber(), Stack.removeNumber());
                addResultToStack(result);
                break;
            case Operators.MINUS:
                checkStackLength();
                result = minus(Stack.removeNumber(), Stack.removeNumber());
                addResultToStack(result);
                break;
            case Operators.MULTIPLY:
                checkStackLength();
                result = multiply(Stack.removeNumber(), Stack.removeNumber());
                addResultToStack(result);
                break;
            case Operators.DIVIDE:
                checkStackLength();
                result = divide(Stack.removeNumber(), Stack.removeNumber());
                addResultToStack(result);
                break;
            case Operators.MODULUS:
                checkStackLength();
                result = modulus(Stack.removeNumber(), Stack.removeNumber());
                addResultToStack(result);
                break;
            case Operators.POWER:
                checkStackLength();
                result = powerOf(Stack.removeNumber(), Stack.removeNumber());
                addResultToStack(result);
                break;
            case Operators.PRINT:
                Stack.printNumbers();
                return;
            case Operators.COMMENT:
                commentMode = true;
                return;
            case Operators.RANDOM:
                processRandom();
                return;
            default:
                System.out.println("Unrecognised operator or operand \"" + operator + "\"");
        }
    }

    private static void processRandom() {
        try {
            Stack.addNumber(randomNumber[randomSeed]);
            randomSeed++;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Stack overflow.");
        }
    }

    private static void addResultToStack(long result) {
        // Handle int saturation
        if (result < Integer.MIN_VALUE) {
            Stack.addNumber(Integer.MIN_VALUE);
        } else if (result > Integer.MAX_VALUE) {
            Stack.addNumber(Integer.MAX_VALUE);
        } else {
            Stack.addNumber((int) result);
        }
    }



    private static String formatOutput(Integer output) {
        return String.format("%s", output);
    }

    // Checks stack size before removing any elements
    private static void checkStackLength() {
        if (Stack.size() < 2) {
            throw new NoSuchElementException();
        }
    }

    private static long plus(long value2, long value1) {
        return value1 + value2;
    }

    private static long minus(long value2, long value1) {
        return value1 - value2;
    }

    private static long multiply(long value2, long value1) {
        return value1 * value2;
    }

    private static long divide(long value2, long value1) {
        return value1 / value2;
    }

    private static long modulus(long value2, long value1) {
        return value1 % value2;
    }

    private static long powerOf(long power, long value) {
        return (int) Math.pow(value, power);
    }
}
