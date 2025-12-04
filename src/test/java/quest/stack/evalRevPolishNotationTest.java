package quest.stack;

import static org.junit.jupiter.api.Assertions.*;
import quest.stack.evalRevPolishNotation;

class evalRevPolishNotationTest {
    public static void main(String[] args) {
        evalRevPolishNotation obj = new evalRevPolishNotation();
//        System.out.println(obj.evalRPN(new String[] {"1","2","+"}));
//        System.out.println(obj.evalRPN(new String[] {"2","4","+","3","*"}));
        System.out.println(obj.evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

}