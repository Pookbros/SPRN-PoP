import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SRPNTest {

    @Test
     void processCommands_NumberIsGiven_SavesNumbers() {
        SRPN SRPN = new SRPN();

        String output = SRPN.processCommand("1");

        assertEquals(1, SRPN.inputs.remove(0));
    }

    @Test
    void processCommands_Adds() {
        SRPN SRPN = new SRPN();

        SRPN.processCommand("10");
        SRPN.processCommand("2");
        SRPN.processCommand("+");

        String output = SRPN.processEquals("=");

        assertEquals("12",output);
    }

    @Test
    void processCommands_Minus() {
        SRPN SRPN = new SRPN();

        SRPN.processCommand("11");
        SRPN.processCommand("3");
        SRPN.processCommand("-");
        String output = SRPN.processEquals("=");

        assertEquals("8", output);
    }

    @Test
    void processCommands_Multiplies() {
        SRPN SRPN = new SRPN();

        SRPN.processCommand("9");
        SRPN.processCommand("4");
        SRPN.processCommand("*");
        String output = SRPN.processEquals("=");

        assertEquals("36", output);
    }

    @Test
    void processCommands_Divides() {
        SRPN SRPN = new SRPN();

        SRPN.processCommand("11");
        SRPN.processCommand("3");
        SRPN.processCommand("/");
        String output = SRPN.processEquals("=");

        assertEquals("3", output);
    }

    @Test
    void processCommands_Modulus() {
        SRPN SRPN = new SRPN();

        SRPN.processCommand("11");
        SRPN.processCommand("3");
        SRPN.processCommand("%");
        String output = SRPN.processEquals("=");

        assertEquals("2", output);
    }

    @Test
    void processCommands_PowerOf() {
        SRPN SRPN = new SRPN();

        SRPN.processCommand("3");
        SRPN.processCommand("3");
        SRPN.processCommand("^");
        String output = SRPN.processEquals("=");

        assertEquals("27", output);
    }

    @Test
    void processCommands_EqualsWhenNoAnswer_ReturnsStackEmptyMessage() {
        SRPN SRPN = new SRPN();

        String output = SRPN.processEquals("=");

        assertEquals("Stack empty.", output);
    }

    @Test
    void processOperator_OperatorWhenNoNumberToProcess_ReturnsStackUnderflowMessage() {
        SRPN SRPN = new SRPN();

        String output = SRPN.processOperator("+");

        assertEquals("Stack underflow.", output);
    }

    @Test
    void processCommands_MultipleNumbersAndOperators_performsCommandsInOrder() {
        SRPN SRPN = new SRPN();

        SRPN.processCommand("3");
        SRPN.processCommand("3");
        SRPN.processCommand("*");
        SRPN.processCommand("4");
        SRPN.processCommand("4");
        SRPN.processCommand("*");
        SRPN.processCommand("+");

        String output = SRPN.processEquals("=");

        assertEquals("25", output);
    }
}