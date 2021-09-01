import java.util.*;

public class PostFixEval {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x = in.nextLine();
        String[] strArr = x.split(" ");
        System.out.println(calculator(strArr));
    }

    public static int calculator(String[] strArr) {
        Stack<Integer> operands = new Stack<Integer>();
        for (String str : strArr) {
            if (str.trim().equals("")) {
                continue;
            }
            switch (str) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int right = operands.pop();
                    int left = operands.pop();
                    int value = 0;
                    switch (str) {
                        case "+":
                            value = left + right;
                            break;
                        case "-":
                            value = left - right;
                            break;
                        case "*":
                            value = left * right;
                            break;
                        case "/":
                            value = left / right;
                            break;
                        default:
                            break;
                    }
                    operands.push(value);
                    break;
                default:
                    operands.push(Integer.parseInt(str));
                    break;
            }
        }
        return operands.pop();
    }
}