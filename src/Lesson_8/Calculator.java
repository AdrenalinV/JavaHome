package Lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.LinkedBlockingDeque;


public class Calculator extends JFrame {
    private JTextField textField;
    public Calculator() {
        initMondatoryComponents();
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 700);
        setLayout(new BorderLayout());
        add(initTop(), BorderLayout.NORTH);
        add(initBottom(), BorderLayout.CENTER);
        setVisible(true);
    }
    private void initMondatoryComponents(){
        textField=new JTextField();
    }
    private JPanel initTop() {

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        textField.setEditable(false);
        top.add(textField, BorderLayout.CENTER);
        return top;
    }

    private JPanel initBottom() {
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(5, 3));
        ActionListener operatorsButtonListener = new OperatorsButtonListener(textField);
        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(operatorsButtonListener);
            bottom.add(btn);
        }
        JButton submit = new JButton("=");
        submit.addActionListener(new CalculaterListener(textField));
        bottom.add(submit);
        JButton zero = new JButton("0");
        zero.addActionListener(operatorsButtonListener);
        bottom.add(zero);
        JButton clear = new JButton("c");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        bottom.add(clear);
        JButton plus = new JButton("+");
        plus.addActionListener(operatorsButtonListener);
        bottom.add(plus);
        JButton minus = new JButton("-");
        minus.addActionListener(operatorsButtonListener);
        bottom.add(minus);
        JButton multiple = new JButton("*");
        multiple.addActionListener(operatorsButtonListener);
        bottom.add(multiple);
        return bottom;
    }
}
