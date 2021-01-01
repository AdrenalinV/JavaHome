package Lesson_8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorsButtonListener implements ActionListener {
    private final JTextField textField;

    public OperatorsButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        StringBuilder strBuilder = new StringBuilder( textField.getText());
        strBuilder.append(button.getText());
        textField.setText(strBuilder.toString());
    }
}
