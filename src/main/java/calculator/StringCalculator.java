package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringCalculator {

    public static final String SPACEBAR = " ";
    public static final String IS_NUMBER_REGEX = "[0-9]+";
    public static final String IS_OPERATOR_REGEX = "[-+*/]";
    public static final String IS_NULL_ERROR_MESSAGE = "입력 값이 null이거나 빈 공백 문자입니다.";
    public static final String IS_NOT_OPERATOR_ERROR_MESSAGE = "사칙연산 기호가 아닌 문자가 포함되어 있습니다.";

    public int execute(String input) {
        validateInput(input);
        String[] inputs = input.split(SPACEBAR);
        List<Integer> numbers = parsingNumber(inputs);
        List<String> operations = parsingOperation(inputs);
        return input(numbers, operations);
    }

    private void validateInput(String input) throws IllegalArgumentException {
        if(isEmpty(input)) {
            throw new IllegalArgumentException(IS_NULL_ERROR_MESSAGE);
        }
        if(isNotOperator(input)) {
            throw new IllegalArgumentException(IS_NOT_OPERATOR_ERROR_MESSAGE);
        }
    }

    private boolean isEmpty(String input) {
        if(Objects.isNull(input) || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isNotOperator(String input) {
        String[] inputs = input.split(SPACEBAR);
        for(int i = 0; i < inputs.length; i++) {
            if(!inputs[i].matches(IS_NUMBER_REGEX) && !inputs[i].matches(IS_OPERATOR_REGEX)) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> parsingNumber(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < inputs.length; i++) {
            isNumber(inputs[i], numbers);
        }
        return numbers;
    }

    private List<Integer> isNumber(String input, List<Integer> numbers) {
        if(input.matches(IS_NUMBER_REGEX)) {
            numbers.add(Integer.parseInt(input));
        }
        return numbers;
    }

    private List<String> parsingOperation(String[] inputs) {
        List<String> operations = new ArrayList<>();
        for(int i = 0; i < inputs.length; i++) {
            isOperation(inputs[i], operations);
        }
        return operations;
    }

    private List<String> isOperation(String input, List<String> operations) {
        if(input.matches(IS_OPERATOR_REGEX)) {
            operations.add(input);
        }
        return operations;
    }

    private int input(List<Integer> numbers, List<String> operations) {
        int result = numbers.get(0);
        for(int i = 0; i < operations.size(); i++) {
            result = calculate(result, numbers.get(i+1), operations.get(i));
        }
        return result;
    }

    private int calculate(int oriNumber, int inputNumber, String operation) {
        int result = 0;

        if("+".equals(operation)) {
            result = oriNumber + inputNumber;
        }else if("-".equals(operation)) {
            result = oriNumber - inputNumber;
        }else if("*".equals(operation)) {
            result = oriNumber * inputNumber;
        }else if("/".equals(operation)) {
            result = oriNumber / inputNumber;
        }

        return result;
    }

}
