import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorClone extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[8];
    private JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton;
    private JPanel panel;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public CalculatorClone() {
        setTitle(" Calculator");
        setSize(420, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
       
        getContentPane().setBackground(new Color(20, 20, 20));

        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setEditable(false);
        display.setFont(new Font("SansSerif", Font.BOLD, 30)); 
        display.setBackground(new Color(45, 45, 45)); 
        display.setForeground(Color.WHITE);          
        display.setHorizontalAlignment(JTextField.RIGHT); 
        display.setBorder(BorderFactory.createEmptyBorder());  
        add(display);

    
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("AC");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        Color numberButtonColor = new Color(75, 75, 75);  
        Color operatorButtonColor = new Color(255, 149, 0); 
        Color functionButtonColor = new Color(160, 160, 160); 

       
        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 24));
            functionButtons[i].setFocusable(false);
            functionButtons[i].setForeground(Color.WHITE);
            functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            functionButtons[i].setBackground(i < 4 ? operatorButtonColor : functionButtonColor);
            functionButtons[i].setOpaque(true);
            functionButtons[i].setBorderPainted(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 24));
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(numberButtonColor); 
            numberButtons[i].setForeground(Color.WHITE);     
            numberButtons[i].setOpaque(true);
            numberButtons[i].setBorderPainted(false);
            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        }

       
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);
        add(delButton);
        add(clrButton);

   
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(new Color(20, 20, 20)); 

     
        panel.add(clrButton);  
        panel.add(delButton);  
        panel.add(divButton); 
        panel.add(mulButton); 

    
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(subButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(addButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(equButton);  

       
        panel.add(numberButtons[0]);
        panel.add(decButton);

        add(panel);

        setVisible(true);
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            display.setText(display.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            display.setText("");
        }
        if (e.getSource() == delButton) {
            String temp = display.getText();
            display.setText("");
            for (int i = 0; i < temp.length() - 1; i++) {
                display.setText(display.getText() + temp.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorClone();
    }
}
