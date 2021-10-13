public class OperatorProcessor {

    public static String processEquals(Integer currentAnswer) {
        if (currentAnswer == null)
            return "Stack empty.";
        else
            return formatOutput(currentAnswer);
    }

    public static Integer processOperator(String command, Integer firstValue, Integer secondValue) {
            switch (command) {
                case Operators.PLUS:
                    return plus(firstValue, secondValue);
                case Operators.MINUS:
                    return minus(firstValue, secondValue);
                case Operators.MULTIPLY:
                    return multiply(firstValue, secondValue);
                case Operators.DIVIDE:
                    return divide(firstValue, secondValue);
                case Operators.MODULUS:
                    return modulus(firstValue, secondValue);
                case Operators.POWER:
                    return powerOf(firstValue, secondValue);
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
    }

    private static String formatOutput(Integer output) {
        return String.format("%s", output);
    }

    private static Integer plus(Integer value1, Integer value2) {
        return value1 + value2;
    }

    private static Integer minus(Integer value1, Integer value2) {
        return value1 - value2;
    }

    private static Integer multiply(Integer value1, Integer value2) {
        return value1 * value2;
    }

    private static Integer divide(Integer value1, Integer value2) {
        return value1 / value2;
    }

    private static Integer modulus(Integer value1, Integer value2) {
        return value1 % value2;
    }

    private static Integer powerOf(Integer value, Integer power) {
        return (int) Math.pow(value, power);
    }
}
