import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class NumberStack {

    private static Deque<Integer> numberStack = new ArrayDeque<>();

    public static Boolean push(String number){
        try {
            Integer numberInput = Integer.parseInt(number);
            numberStack.addFirst(numberInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void push(Integer number){
        numberStack.addFirst(number);
    }

    public static Integer pop(){
        return numberStack.removeFirst();
    }

    public static Integer peek(){
        return numberStack.peekFirst();
    }

    public static void print(){
        Iterator<Integer> iterator = numberStack.descendingIterator();

        if (NumberStack.size() == 0){
            System.out.println(Integer.MIN_VALUE);
        }
        else {
            while (iterator.hasNext())
                System.out.println(iterator.next());
        }
    }

    public static int size() {
        return numberStack.size();
    }

    // Used for unit testing purposes.
    public static void clear() {
        numberStack.clear();
    }
}
