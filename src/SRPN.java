import java.util.*;

/**
 * SPRN (Saturated Reverse Polish Notation) calculator class that takes commands and returns a response based on the command.
 * If command is a number, it will add to the 'inputs' ArrayList.
 * if command is an operator, it will perform that calculation and add it to the 'currentAnswer' variable.
 * If command is an equals operator, it will return the currentAnswer to the calling function.
 */
public class SRPN {

    Integer currentAnswer;
    Deque<Integer> numberInputs = new ArrayDeque<>();

    /**
     * Returns a String with the result of the current command to be printed to the console.
     * Takes one String argument which can be any length.
     * This method will process the command, either storing the number input in the 'numberInputs' array, or performing a
     * calculation if the command is an operator.
     *
     * @param command the command to be processed
     */
    public void processCommand(String command) throws IllegalStateException {
        String[] commandList = command.split(" ");

        // Check for single line input (i.e. "3 3 + ")
        if (commandList.length > 1) {
            for (String c : commandList) {
                processCommand(c);
            }
        } else {
            // Try parse command to a number and add it to the stack
            try {
                Integer numberInput = Integer.parseInt(command);
                numberInputs.addFirst(numberInput);
            } catch (NumberFormatException e) {
                // Check if command contains an equals
                if (command.indexOf(Operators.EQUALS) >= 0) {
                    System.out.println(OperatorProcessor.processEquals(numberInputs.peekFirst()));

                    // Remove the equals from the command
                    command = command.replace(Operators.EQUALS, ' ').trim();
                }
                //Iterate through command string
//                for (int i = 0; i < command.length(); i++) {
                    if (command.indexOf('d') >= 0) {
                        printOutInputs();
                    } else {
                        processOperator(command);
                    }
//                }
            }
        }

    }

    private void processOperator(String command) {
        try {
            Integer secondValue = numberInputs.removeFirst();
            Integer firstValue = numberInputs.removeFirst();

            currentAnswer = OperatorProcessor.process(command.charAt(0), firstValue, secondValue);
            if (currentAnswer == null) {
                System.out.println("Unrecognised operator or operand \"" + command + "\"");
            } else {
                numberInputs.addFirst(currentAnswer);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Stack underflow.");
        } catch (ArithmeticException ex) {
            System.out.println("Divide by 0.");
        }
    }

    private void printOutInputs() {
        for (int input : numberInputs)
            System.out.println(input);
    }
}

