//public class OperatorProcessor {
//
//    public static String processOperator(String command, Integer firstValue, Integer secondValue) {
//        int o = 0;
//        try {
//            switch (command) {
//                case "+":
//                    return plus(firstValue, inputs.remove(1)));
//
//                    break;
//                case "-":
//                    currentAnswer = minus(inputs.get(0), inputs.remove(1));
//                    inputs.set(0, currentAnswer);
//                    break;
//                case "*":
//                    currentAnswer = multiply(inputs.get(0), inputs.remove(1));
//                    inputs.set(0, currentAnswer);
//                    break;
//                case ("/"):
//                    currentAnswer = divide(inputs.get(0), inputs.remove(1));
//                    inputs.set(0, currentAnswer);
//                    break;
//                case "%":
//                    currentAnswer = modulus(inputs.get(0), inputs.remove(1));
//                    inputs.set(0, currentAnswer);
//                    break;
//                case "^":
//                    currentAnswer = powerOf(inputs.get(0), inputs.remove(1));
//                    inputs.set(0, currentAnswer);
//                    break;
//                default:
//                    throw new IllegalStateException("Unexpected value: " + command);
//            }
//        } catch (IndexOutOfBoundsException ex) {
//            return "Stack underflow.";
//        }
//        return null;
//    }
//
//    private static Integer plus(Integer value1, Integer value2) {
//        return value1 + value2;
//    }
//
//    private static  Integer minus(Integer value1, Integer value2) {
//        return value1 - value2;
//    }
//
//    private static Integer multiply(Integer value1, Integer value2) {
//        return value1 * value2;
//    }
//
//    private static Integer divide(Integer value1, Integer value2) {
//        return value1 / value2;
//    }
//
//    private static Integer modulus(Integer value1, Integer value2) {
//        return value1 % value2;
//    }
//
//    private static Integer powerOf(Integer value, Integer power) {
//        return (int) Math.pow(value, power);
//    }
//}
