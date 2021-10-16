public class OperatorProcessor {

    public static String processEquals(Integer currentAnswer) {
        if (currentAnswer == null)
            return "Stack empty.";
        else
            return formatOutput(currentAnswer);
    }

    public static Integer process(String command, Integer firstValue, Integer secondValue) {
        // Using long for the result so the code can check whether the value is higher than the max or min int value
        long result;
        switch (command) {
            case Operators.PLUS:
                result = plus(firstValue, secondValue);
                break;
            case Operators.MINUS:
                result = minus(firstValue, secondValue);
                break;
            case Operators.MULTIPLY:
                result = multiply(firstValue, secondValue);
                break;
            case Operators.DIVIDE:
                result = divide(firstValue, secondValue);
                break;
            case Operators.MODULUS:
                result = modulus(firstValue, secondValue);
                break;
            case Operators.POWER:
                result = powerOf(firstValue, secondValue);
                break;
          default:
              return null;
        }

        if (result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if (result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }

    private static String formatOutput(Integer output) {
        return String.format("%s", output);
    }

    private static long plus(long value1, Integer value2) {
        return value1 + value2;
    }

    private static long minus(Integer value1, Integer value2) {
        return value1 - value2;
    }

    private static long multiply(Integer value1, Integer value2) {
        return (long) value1 * value2;
    }

    private static long divide(Integer value1, Integer value2) {
        return value1 / value2;
    }

    private static long modulus(Integer value1, Integer value2) {
        return value1 % value2;
    }

    private static long powerOf(Integer value, Integer power) {
        return (int) Math.pow(value, power);
    }
}
