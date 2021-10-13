import jdk.jfr.Category;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SRPNTest {

    @Test

     void processCommands_NumberIsGiven_SavesNumbers() {
        SRPN srpn = new SRPN();

        srpn.processCommand("1");

        assertEquals(1, srpn.getInputs().removeFirst());
    }

    //Test 1.1
    @Test
    void Test1_processCommands_Adds() {
        SRPN srpn = new SRPN();

        srpn.processCommand("10");
        srpn.processCommand("2");
        srpn.processCommand("+");

        String output = OperatorProcessor.processEquals(srpn.getCurrentAnswer());

        assertEquals("12",output);
    }

    //Test 1.2
    @Test
    void Test1_processCommands_Minus() {
        SRPN srpn = new SRPN();

        srpn.processCommand("11");
        srpn.processCommand("3");
        srpn.processCommand("-");
        String output = OperatorProcessor.processEquals(srpn.getCurrentAnswer());

        assertEquals("8", output);
    }

    //Test 1.3
    @Test
    void Test1_processCommands_Multiplies() {
        SRPN srpn = new SRPN();

        srpn.processCommand("9");
        srpn.processCommand("4");
        srpn.processCommand("*");
        String output = OperatorProcessor.processEquals(srpn.getCurrentAnswer());

        assertEquals("36", output);
    }

    //Test 1.4
    @Test
    void Test1_processCommands_Divides() {
        SRPN srpn = new SRPN();

        srpn.processCommand("11");
        srpn.processCommand("3");
        srpn.processCommand("/");
        String output = OperatorProcessor.processEquals(srpn.getCurrentAnswer());

        assertEquals("3", output);
    }

    //Test 1.5
    @Test
    void Test1_processCommands_Modulus() {
        SRPN srpn = new SRPN();

        srpn.processCommand("11");
        srpn.processCommand("3");
        srpn.processCommand("%");
        String output = OperatorProcessor.processEquals(srpn.getCurrentAnswer());

        assertEquals("2", output);
    }

    @Test
    void processCommands_PowerOf() {
        SRPN srpn = new SRPN();

        srpn.processCommand("3");
        srpn.processCommand("3");
        srpn.processCommand("^");
        String output = OperatorProcessor.processEquals(srpn.getCurrentAnswer());

        assertEquals("27", output);
    }

    @Test
    void processCommands_EqualsWhenNoAnswer_ReturnsStackEmptyMessage() {
        SRPN srpn = new SRPN();

        String output = OperatorProcessor.processEquals(srpn.getCurrentAnswer());

        assertEquals("Stack empty.", output);
    }

    @Test
    void Test2_MultipleNumbersAndOperators_performsCommandsInOrder() {
        SRPN srpn = new SRPN();

        srpn.processCommand("3");
        srpn.processCommand("3");
        srpn.processCommand("*");
        srpn.processCommand("4");
        srpn.processCommand("4");
        srpn.processCommand("*");
        srpn.processCommand("+");

        String output = OperatorProcessor.processEquals(srpn.getCurrentAnswer());

        assertEquals("25", output);
    }

    @Test
    void Test2_dCommandIs_performsCommandsInOrderAndPrintsA() {
        SRPN srpn = new SRPN();

        srpn.processCommand("3");
        srpn.processCommand("3");
        srpn.processCommand("*");
        srpn.processCommand("4");
        srpn.processCommand("4");
        srpn.processCommand("*");
        srpn.processCommand("+");

        String output = OperatorProcessor.processEquals(srpn.getCurrentAnswer());

        assertEquals("25", output);
    }

    @Test
    void SingleLineCommand_performsOperationsInCorrectOrder() {
        SRPN srpn = new SRPN();

        srpn.processCommand("3+3*9/3");

        String output = OperatorProcessor.processEquals(srpn.getCurrentAnswer());

        assertEquals("12", output);
    }

    @Test
    void AnotherSingleLineCommand_performsOperationsInCorrectOrder() {
        SRPN srpn = new SRPN();

        srpn.processCommand("10/5*2-1");

        String output = OperatorProcessor.processEquals(srpn.getCurrentAnswer());

        assertEquals("3", output);
    }
}