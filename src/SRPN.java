import java.util.*;

/**
 * SPRN (Saturated Reverse Polish Notation) calculator class that takes commands and returns a response based on the command.
 * If command is a number, it will add to the 'inputs' ArrayList.
 * if command is an operator, it will perform that calculation and add it to the 'currentAnswer' variable.
 * If command is an equals operator, it will print the currentAnswer to the console.
 */
public class SRPN {

    private Integer currentAnswer;
    private Deque<Integer> inputs = new ArrayDeque<>();
    final String singleLineDelimiter = ",";
    final String polishNotationDelimiter = " ";

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
        int position;

        //Split on whitespace
        //Each element create array list of 'elementPairs (Enum, String)'
        //Then run 3 checks and do operation on left and right numbers:
        // Check for exponent
        // Check for divides, multiplies and modulo
        // Check for minus and plus
        //


        StringBuilder singleLineCommandBuilder = new StringBuilder();

        //Loop through command and add delimiter before any operators
        for (char c : command.toCharArray()) {
            if (Character.isDigit(c)) {
                singleLineCommandBuilder.append(c);
            } else {
                if (singleLineCommandBuilder.length() > 0){
                    //Create ElementPair with numbers built up from above
                    // AND Create element pair of current operator
                }



                //singleLineCommandBuilder.append(singleLineDelimiter).append(c).append(singleLineDelimiter);
            }
        }


//        if (singleLineCommandBuilder.indexOf(singleLineDelimiter) > 0) {
//            String singleLineCommand = singleLineCommandBuilder.toString();
//            //Handle single line input
//            List<String> singleLineArray = new ArrayList<String>(List.of(singleLineCommand.split(singleLineDelimiter)));
//
//            for (int i = 0; i < singleLineArray.size(); i++) {
//                try {
//                System.out.println(singleLineArray.get(i));
//                if (singleLineArray.get(i).equals(Operators.DIVIDE)) {
//                    currentAnswer = OperatorProcessor.processOperator(Operators.DIVIDE,
//                            Integer.parseInt(singleLineArray.get(i - 1)),
//                            Integer.parseInt(singleLineArray.get(i + 1)));
//                    singleLineArray.set(i, currentAnswer.toString());
//                    singleLineArray.remove(i - 1);
//                    singleLineArray.remove(i - 1);
//                    System.out.println("CurrentAnswer: " + currentAnswer);
//                } else if (singleLineArray.get(i) == Operators.EQUALS) {
//                    OperatorProcessor.processEquals(currentAnswer);
//                }
//                }catch (IndexOutOfBoundsException e){
//                    singleLineArray.remove(i);
//                }
//            }
//
//        } else {
            try {
                Integer numberInput = Integer.parseInt(command);
                this.inputs.addFirst(numberInput);
            } catch (NumberFormatException e) {
                if (command.equals(Operators.EQUALS)) {
                    System.out.println(OperatorProcessor.processEquals(inputs.peekFirst()));
                } else if (command.equals("d")) {
                    printOutInputs();
                } else {
                    try {
                        Integer secondValue = inputs.removeFirst();
                        Integer firstValue = inputs.removeFirst();
                        currentAnswer = OperatorProcessor.processOperator(command, firstValue, secondValue);
                        inputs.addFirst(currentAnswer);
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Stack underflow.");
                    } catch (ArithmeticException ex) {
                        System.out.println("Divide by 0.");
                    }
                }
            }
        }

        //TODO: Move this to OperatorProcessor
    private void printOutInputs() {
        for (int input : inputs)
            System.out.println(input);

        System.out.println(currentAnswer);
    }

    public Integer getCurrentAnswer() {
        return currentAnswer;
    }

    public Deque<Integer> getInputs() {
        return inputs;
    }
}

