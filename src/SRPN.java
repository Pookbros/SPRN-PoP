import Constants.Operators;
import java.util.*;

/**
 * SPRN (Saturated Reverse Polish Notation) calculator class that takes commands and applies them.
 * If command is a number, it will add to the 'NumberStack'.
 * if command is an operator, it will perform that calculation and add it to the front of the NumberStack.
 * If command is an equal's operator, it will print the value at the front of the stack to the console.
 */
public class SRPN {

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
            // Recursively call this method for each string in commandList
            for (String c : commandList) {
                processCommand(c);
            }
        } else {
            // Try parse command to a number and add it to the stack. If not a number, process other operators
            if (!NumberStack.push(command.strip()) && !command.isEmpty()) {
                try {
                    OperatorProcessor.process(command);
                } catch (NoSuchElementException ex) {
                    System.out.println("Stack underflow.");
                } catch (ArithmeticException ex) {
                    System.out.println("Divide by 0.");
                }
            }
        }
    }
}

