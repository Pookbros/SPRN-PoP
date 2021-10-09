import java.util.*;

/**
 * SPRN (Saturated Reverse Polish Notation) calculator class that takes commands and returns a response based on the command.
 * If command is a number, it will add to the 'inputs' ArrayList.
 * if command is an operator, it will perform that calculation and add it to the 'currentAnswer' variable.
 * If command is an equals operator, it will return the currentAnswer to the calling function.
 */
public class SRPN {

    List<Integer> currentAnswers = new ArrayList<>();
    Integer currentAnswer;
    List<Integer> inputs = new ArrayList<>();


    /**
     * Returns a String with the result of the current command to be printed to the console.
     * Takes one String argument which can be any length.
     * This method will process the command, either storing the input in the 'inputs' array, or performing a
     * calculation if the command is an operator.
     *
     * @param command the command to be processed
     * @return the string result to be printed to the console
     */
    public String processCommand(String command) throws IllegalStateException {

        try {
            Integer numberInput = Integer.parseInt(command);
            this.inputs.add(numberInput);
        } catch (NumberFormatException e) {
            if (command.equals("=")) {
                System.out.println(processEquals(command));
            } else {

                System.out.println(processOperator(command));
            }
        }
        return null;
    }

    //TODO: Change to private. Setting this as public so I can unit test the String value returned.
    public String processEquals(String command){
        if (currentAnswer == null)
            return "Stack empty.";
        else
            return formatOutput(currentAnswer);
    }

    //TODO: Change to private. Setting this as public so I can unit test the String value returned.
    public String processOperator(String command) {
        int o = 0;
        try {
            switch (command) {
                case "+":
                    currentAnswer = plus(inputs.remove(0), inputs.remove(1));

                    break;
                case "-":
                    currentAnswer = minus(inputs.get(0), inputs.remove(1));
                    inputs.set(0, currentAnswer);
                    break;
                case "*":
                    currentAnswer = multiply(inputs.get(0), inputs.remove(1));
                    inputs.set(0, currentAnswer);
                    break;
                case ("/"):
                    currentAnswer = divide(inputs.get(0), inputs.remove(1));
                    inputs.set(0, currentAnswer);
                    break;
                case "%":
                    currentAnswer = modulus(inputs.get(0), inputs.remove(1));
                    inputs.set(0, currentAnswer);
                    break;
                case "^":
                    currentAnswer = powerOf(inputs.get(0), inputs.remove(1));
                    inputs.set(0, currentAnswer);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
        } catch (IndexOutOfBoundsException ex) {
            return "Stack underflow.";
        }
        return null;
    }

    private String formatOutput(Integer output) {
        return String.format("%s", output);
    }

        private static Integer plus(Integer value1, Integer value2) {
        return value1 + value2;
    }

    private static  Integer minus(Integer value1, Integer value2) {
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

