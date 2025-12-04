package quest.stack;

import java.util.*;

public class evalRevPolishNotation {
    private int evaluate(String opertor, int operand1, int operand2){
        return switch (opertor){
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new IllegalStateException("wrong operator provided");
        };
    }
    public int evalRPN(String[] tokens) {
        int result = 0;
        Set<String> operators = Set.of("*","/","+","-");
        Stack<Integer> num_stack = new Stack<>();
        for (String tok:tokens){
            if(operators.contains(tok)){
                int operand2 = num_stack.pop();
                int operand1 = num_stack.pop();
                num_stack.push(evaluate(tok, operand1, operand2));
            } else{
                num_stack.push(Integer.valueOf(tok));
            }
        }
        return num_stack.pop();
    }
}
