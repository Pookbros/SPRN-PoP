import java.util.*;

/**
 * SPRN (Saturated Reverse Polish Notation) calculator class that takes commands and returns a response based on the command.
 * If command is a number, it will add to the 'inputs' ArrayList.
 * if command is an operator, it will perform that calculation and add it to the 'currentAnswer' variable.
 * If command is an equals operator, it will return the currentAnswer to the calling function.
 */
public class SRPN {

    Integer currentAnswer;
    List<Integer> inputs = new ArrayList<>();

    /**
     * Returns a String with the result of the current command to be printed to the console.
     * Takes one String argument which can be any length.
     * This method will process the command, either storing the input in the 'inputs' array, or performing a
     * calculation if the command is an operator.
     *
     * @param command the command to be processed
     */
    public void processCommand(String command) throws IllegalStateException {
        String output;
        try {
            Integer numberInput = Integer.parseInt(command);
            this.inputs.add(numberInput);
        } catch (NumberFormatException e) {
            if (command.equals("=")) {
                System.out.println(OperatorProcessor.processEquals(currentAnswer));
            } else if (command.equals("d")){
                printOutInputs();
            } else {
                try {
                    Integer secondValue = inputs.remove(inputs.size() - 1);
                    Integer firstValue = inputs.remove(inputs.size() - 1);
                    currentAnswer = OperatorProcessor.processOperator(command, firstValue, secondValue);
                    inputs.add(currentAnswer);
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println("Stack underflow.");
                } catch (ArithmeticException ex) {
                    System.out.println("Divide by 0.");
                }
            }
        }
    }

    private void printOutInputs() {
        for (int input : inputs)
            System.out.println(input);
    }
}

