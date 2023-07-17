import java.util.Stack;

public class stacktest {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack();


        stack.push(2);
        stack.push(1);
        stack.add(4);



        System.out.println(stack);

        int add = stack.pop()/stack.pop();
        System.out.println(add);




    }

}
