import java.util.*;

/**
 * SPRN (Saturated Reverse Polish Notation) calculator class that takes commands and returns a response based on the command.
 * If command is a number, it will add to the 'inputs' ArrayList.
 * if command is an operator, it will perform that calculation and add it to the 'currentAnswer' variable.
 * If command is an equals operator, it will return the currentAnswer to the calling function.
 */
public class SRPN {

    Integer currentAnswer;
    //Deque<Integer> numberInputs = new ArrayDeque<>();

    /**
     * Returns a String with the result of the current command to be printed to the console.
     * Takes one String argument which can be any length.
     * This method will process the command, either storing the number input in the 'numberInputs' array, or performing a
     * calculation if the command is an operator.
     *
     * @param command the command to be processed
     */
    public void processCommand(String command) throws IllegalStateException {
        // Is it an integer?
        // Is it an allowed operator?
        // Is it 'd'?
        // Else throw

        // Split input line out into individual commands
        // If command is invalid, print to console and continue
        // If it's 'd', print everything and continue
        // Other custom letter commands next
        // If it's a number, add it to the stack of numbers
        // If it's an operator, apply it to the stack of numbers

        String[] commandList = command.split(" ");

        // Check for single line input (i.e. "3 3 + ")
        if (commandList.length > 1) {
            // Recursively call this method for each string in commandList
            for (String c : commandList) {
                processCommand(c);
            }
        } else {
            if (OperatorProcessor.commentMode) {
                if (command.contains(Operators.COMMENT)) {
                    OperatorProcessor.commentMode = false;
                }
                return;
            }
            // Try parse command to a number and add it to the stack
            if (!Stack.addNumber(command)) {
                // First check command for "=" (accounts for command such as "+=")
                if (command.contains(Operators.EQUALS)) {
                    System.out.println(OperatorProcessor.processEquals());
                    command = command.replace(Operators.EQUALS, "");
                }
                if (!command.isEmpty()) {
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
}

