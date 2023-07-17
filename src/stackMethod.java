import com.sun.corba.se.spi.extension.CopyObjectPolicy;

import java.util.Scanner;
import java.util.Stack;

public class stackMethod {

    // operations

    public static void main(String[] args) {

        // stack.push [1,2] -> stack.pop will pop the last one which is 2 first
        Stack<Integer> stack = new Stack<>();

        String q1 = "1+2"; // 3
        String q6 = "4-1"; //3
        String q2 = "2*2/4"; // 2
        String q5 = "3+2*2-1/2+2"; // 8.5 or 8
        String q3 = "1+2*4"; // 9
        String a4 = "(1+2)*4"; // 12

        // Anything with + will add later
        char operator = '+';
        // String to Char Array
        char[] ch = q3.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                continue;
            }
            // isDigit checks if char is digit return boolean
            if (Character.isDigit(ch[i])) {
                StringBuilder numBuild = new StringBuilder();
                while (i < ch.length && Character.isDigit(ch[i])) {
                    numBuild.append(ch[i++]);
                }
                //Jump back to pre-num
                i--;

                // String to Integer
                int num = Integer.parseInt(numBuild.toString());
                if (operator == '-') {
                    num *= -1;
                } else if (operator == '*') {
                    num *= stack.pop();
                } else if (operator == '/') {
                    num = stack.pop() / num;
                }
                stack.push(num);
            } else {
                operator = ch[i];
            }
        }
        System.out.println(stack);

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        System.out.println("sum " + total);
    }

}
