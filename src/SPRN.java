import java.util.*;

/**
 * SPRN (Saturated Reverse Polish Notation) calculator class that takes commands and returns a response based on the command.
 * If command is a number, it will add to the 'inputs' ArrayList.
 * if command is an operator, it will perform that calculation and add it to the 'currentAnswer' variable.
 * If command is an equals operator, it will return the currentAnswer to the calling function.
 */
public class SPRN {

    Double currentAnswer;
    List<Double> inputs = new ArrayList<>();

    /**
     * Returns a String with the result of the current command to be printed to the console.
     * Takes one String argument which can be any length.
     * This method will process the command, either storing the input in the 'inputs' array, or performing a
     * calculation if the command is an operator.
     *
     * @param command the command to be processed
     * @return the string result to be printed to the console
     */
    public String processCommands(String command) {

        try {
            Double numberInput = Double.parseDouble(command);
            this.inputs.add(numberInput);
        } catch (NumberFormatException e) {
            switch (command) {
                case "+":
                    currentAnswer = plus(inputs.get(0), inputs.get(1));
                    inputs.clear();
                    break;
                case "-":
                    currentAnswer = minus(inputs.get(0), inputs.get(1));
                    inputs.clear();
                    break;
                case "*":
                    currentAnswer = multiply(inputs.get(0), inputs.get(1));
                    inputs.clear();
                    break;
                case ("/"):
                    currentAnswer = divide(inputs.get(0), inputs.get(1));
                    inputs.clear();
                    break;
                case "%":
                    currentAnswer = modulus(inputs.get(0), inputs.get(1));
                    inputs.clear();
                    break;
                case "=":
                    return formatOutput(currentAnswer);
                default:
                    throw new IllegalStateException("Unexpected value: " + command);

            }

        }
        return null;
    }

    private String formatOutput(Double output){
        return String.format("%.0f", output);
    }

    private Double plus(Double value1, Double value2) {
        return value1 + value2;
    }

    private Double minus(Double value1, Double value2) {
        return value1 - value2;
    }

    private Double multiply(Double value1, Double value2) {
        return value1 * value2;
    }

    private Double divide(Double value1, Double value2) {
        return value1 / value2;
    }

    private Double modulus(Double value1, Double value2) {
        return value1 * value2;
    }

    private Double powerOf(Double value, Double power) {
        return Math.pow(value, power);
    }

}

