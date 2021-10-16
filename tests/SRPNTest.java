import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SRPNTest {

    @AfterEach
    public final void cleanup(){
        Stack.clear();
    }

    @Test
     void processCommands_NumberIsGiven_SavesNumbers() {
        SRPN srpn = new SRPN();

        srpn.processCommand("1");

        assertEquals(1, Stack.removeNumber());
    }


    //Test 1.1
    @Test
    void Test1_processCommands_Adds() {
        SRPN srpn = new SRPN();

        srpn.processCommand("10");
        srpn.processCommand("2");
        srpn.processCommand("+");

        String output = OperatorProcessor.processEquals();

        assertEquals("12",output);
    }

    //Test 1.2
    @Test
    void Test1_processCommands_Minus() {
        SRPN srpn = new SRPN();

        srpn.processCommand("11");
        srpn.processCommand("3");
        srpn.processCommand("-");
        String output = OperatorProcessor.processEquals();

        assertEquals("8", output);
    }

    //Test 1.3
    @Test
    void Test1_processCommands_Multiplies() {
        SRPN srpn = new SRPN();

        srpn.processCommand("9");
        srpn.processCommand("4");
        srpn.processCommand("*");
        String output = OperatorProcessor.processEquals();

        assertEquals("36", output);
    }

    //Test 1.4
    @Test
    void Test1_processCommands_Divides() {
        SRPN srpn = new SRPN();

        srpn.processCommand("11");
        srpn.processCommand("3");
        srpn.processCommand("/");
        String output = OperatorProcessor.processEquals();

        assertEquals("3", output);
    }

    //Test 1.5
    @Test
    void Test1_processCommands_Modulus() {
        SRPN srpn = new SRPN();

        srpn.processCommand("11");
        srpn.processCommand("3");
        srpn.processCommand("%");
        String output = OperatorProcessor.processEquals();

        assertEquals("2", output);
    }

    @Test
    void processCommands_PowerOf() {
        SRPN srpn = new SRPN();

        srpn.processCommand("3");
        srpn.processCommand("3");
        srpn.processCommand("^");
        String output = OperatorProcessor.processEquals();

        assertEquals("27", output);
    }

    @Test
    void processCommands_EqualsWhenNoAnswer_ReturnsStackEmptyMessage() {
        SRPN srpn = new SRPN();

        Stack.clear();

        String output = OperatorProcessor.processEquals();

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

        String output = OperatorProcessor.processEquals();

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

        String output = OperatorProcessor.processEquals();

        assertEquals("25", output);
    }

    @Test
    void SingleLinePolishNotation_performsCommandsInOrder() {
        SRPN srpn = new SRPN();

        srpn.processCommand("3 3 +");

        String output = OperatorProcessor.processEquals();

        assertEquals("6", output);
    }

    @Test
    void Test3_IntegerSaturationAtMax_returnsMaxInt() {
        SRPN srpn = new SRPN();

        srpn.processCommand("2147483647");
        srpn.processCommand("1");
        srpn.processCommand("+");
        srpn.processCommand("=");

        String output = OperatorProcessor.processEquals();

        assertEquals("2147483647", output);
    }

    @Test
    void Test3_IntegerSaturationAtMin_returnsMinInt() {
        SRPN srpn = new SRPN();

        srpn.processCommand("-2147483647");
        srpn.processCommand("1");
        srpn.processCommand("-");
        srpn.processCommand("=");
        srpn.processCommand("20");
        srpn.processCommand("-");
        srpn.processCommand("=");

        String output = OperatorProcessor.processEquals();

        assertEquals("-2147483648", output);
    }
}