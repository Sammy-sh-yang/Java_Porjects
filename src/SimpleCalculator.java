import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/*
 * Try use Stack instead of using Switch case
 *
 */
public class SimpleCalculator implements ActionListener {
    //GUI canvas stats
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;
    JPanel panel = new JPanel();
    JButton[] numButton = new JButton[10];//number 0-9
    //JButton[] functionButton = new JButton[7];//+ - * / . clear =
    JButton addButton, subButton, mulButton, divButton, dotButton, clearButton, eqButton;
    JTextField displayResult = new JTextField();
    Double n1;
    Double n2;
    int result;
    String operation;

    //Create a new button
    public JButton newButton(String s) {
        JButton button = new JButton();
        button.addActionListener(this);
        button.setText(s);
        button.setFocusable(false);
        return button;
    }


    void paint() {
        JFrame frame = new JFrame("Simple Calculator");
        //panel is container for components

        // display result
//        displayResult = new JTextField();
        displayResult.setBounds(50, 50, 200, 30);
        displayResult.setEditable(false);
        frame.add(displayResult);

        for (int i = 0; i < numButton.length; i++) {
            numButton[i] = newButton(String.valueOf(i));
            panel.add(numButton[i]);
        }

        // Create operation button
        addButton = newButton("+");
        subButton = newButton("-");
        mulButton = newButton("*");
        divButton = newButton("/");
        eqButton = newButton("=");
        dotButton = newButton(".");
        clearButton = newButton("C");
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(eqButton);
        panel.add(dotButton);
        panel.add(clearButton);

        panel.setBounds(50, 100, WINDOW_WIDTH - 100, WINDOW_HEIGHT - 100);
        panel.setLayout(new GridLayout(4, 4, 10, 10)); //Set grid for the buttons
        panel.setBackground(Color.green);
        frame.add(panel);

        //Not using other frame to layout; Only be using setBound to layout
        frame.setLayout(null);
        //Starting coordinate
        frame.setLocation(500, 0);
        //Close the frame when hit close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH + 1, WINDOW_HEIGHT + 39);//Set window size
        frame.setLocationRelativeTo(null); // this method display JFrame to center position of a screen
        frame.setVisible(true); //Set GUI visible
    }

    public int calculateResult(String s) {
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch.length == ' ') {
                continue;
            }

            if (Character.isDigit(ch[i])) {

                StringBuilder numBuilder = new StringBuilder();
                while (i < ch.length && Character.isDigit(ch[i])) {
                    numBuilder.append(ch[i++]);
                }
                i--;

                int num = Integer.parseInt(numBuilder.toString());

                if (operator == '-') {
                    num *= -1;
                } else if (operator == '*') {
                    num *= stack.pop();
                } else if (operator == '/') {
                    num = (stack.pop() / num);
                }
                stack.push(num);

            } else {
                operator = ch[i];
            }
        }

        int total = 0;
        while (!stack.empty()) {
            total += stack.pop();
        }
        return total;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButton[i]) {
                displayResult.setText(displayResult.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == addButton) {
            displayResult.setText(displayResult.getText().concat("+"));
        } else if (e.getSource() == subButton) {
            displayResult.setText(displayResult.getText().concat("-"));
        } else if (e.getSource() == mulButton) {
            displayResult.setText(displayResult.getText().concat("*"));
        } else if (e.getSource() == divButton) {
            displayResult.setText(displayResult.getText().concat("/"));
        } else if (e.getSource() == dotButton) {
            displayResult.setText(displayResult.getText().concat("."));
        } else if (e.getSource() == clearButton) {
            displayResult.setText("");
        } else if (e.getSource() == eqButton) {
            result = calculateResult(displayResult.getText());
            displayResult.setText(String.valueOf(result));
        }


        /*
         * Calculation using Switch case (old version)
         */

//        if (e.getSource() == addButton) {
//            n1 = Double.parseDouble(displayResult.getText());
//            displayResult.setText("0");
//            operation = "add";
//        }
//        else if (e.getSource() == subButton) {
//            n1 = Double.parseDouble(displayResult.getText());
//            displayResult.setText("");
//            operation = "subtract";
//        } else if (e.getSource() == mulButton) {
//            n1 = Double.parseDouble(displayResult.getText());
//            displayResult.setText("");
//            operation = "multiplication";
//        } else if (e.getSource() == divButton) {
//            n1 = Double.parseDouble(displayResult.getText());
//            displayResult.setText("");
//            operation = "division";
//        } else if (e.getSource() == clearButton) {
//            displayResult.setText("");
//        } else if (e.getSource() == dotButton) {
//            displayResult.setText(displayResult.getText().concat("."));
//
//        } else if (e.getSource() == eqButton) {
//            n2 = Double.parseDouble(displayResult.getText());
//            //results
//            switch (operation) {
//                case "add":
//                    result = n1 + n2;
//                    break;
//                case "subtract":
//                    result = n1 - n2;
//                    break;
//                case "division":
//                    result = n1 / n2;
//                    break;
//                case "multiplication":
//                    result = n1 * n2;
//                    break;
//                default:
//                    System.out.println("??");
//            }
//            displayResult.setText(String.valueOf(result));
//        }

    }

    public static void main(String[] args) {
        SimpleCalculator g = new SimpleCalculator();
        g.paint();

    }

}
