import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SPRN sprn = new SPRN();
        String userInput;

        do {
            userInput = scanner.nextLine();
            String output = sprn.processCommands(userInput);

            if (output != null) System.out.println(output);
        } while (!userInput.isEmpty());
    }
}
