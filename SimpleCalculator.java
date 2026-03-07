//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
//WEEK 8: JAVA SWING ASSIGNMENT: SIMPLE CALCULATOR

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String operator = "";
    private double firstOperand = 0;
    private boolean startNewNumber = true;

    public SimpleCalculator() {
        // JFrame settings
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panelButtons = new JPanel(new GridLayout(5, 4, 5, 5));

        // Buttons text
        String[] buttonTexts = {
                "7", "8", "9", "÷",
                "4", "5", "6", "×",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        // Add buttons to panel
        for (String text : buttonTexts) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panelButtons.add(button);
        }

        add(panelButtons, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            if (startNewNumber) {
                display.setText("");
                startNewNumber = false;
            }
            // Prevent multiple decimals
            if (command.equals(".") && display.getText().contains("."))
                return;
            display.setText(display.getText() + command);
        } else if ("+-×÷".contains(command)) {
            try {
                firstOperand = Double.parseDouble(display.getText());
            } catch (NumberFormatException ex) {
                display.setText("Error");
                return;
            }
            operator = command;
            startNewNumber = true;
        } else if (command.equals("=")) {
            try {
                double secondOperand = Double.parseDouble(display.getText());
                double result = 0;
                switch (operator) {
                    case "+":
                        result = firstOperand + secondOperand;
                        break;
                    case "-":
                        result = firstOperand - secondOperand;
                        break;
                    case "×":
                        result = firstOperand * secondOperand;
                        break;
                    case "÷":
                        if (secondOperand == 0) {
                            display.setText("Error: Div by 0");
                            startNewNumber = true;
                            return;
                        }
                        result = firstOperand / secondOperand;
                        break;
                }
                display.setText(String.valueOf(result));
                startNewNumber = true;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (command.equals("C")) {
            display.setText("");
            firstOperand = 0;
            operator = "";
            startNewNumber = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calc = new SimpleCalculator();
            calc.setVisible(true);
        });
    }
}