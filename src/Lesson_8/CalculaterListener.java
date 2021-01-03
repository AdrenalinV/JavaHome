package Lesson_8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculaterListener implements ActionListener {
    private final JTextField textField;

    public CalculaterListener(JTextField textField) {
        this.textField = textField;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String value = textField.getText();
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        String[] operators;
        if (value.contains("^")) {
            operators = value.split("\\^");
            textField.setText(
                    String.valueOf(
                            Math.pow(Float.parseFloat(operators[0]), Float.parseFloat(operators[1]))
                    )
            );
        }else {
            Object expResult = null;
            try {
                expResult = scriptEngine.eval(value);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            textField.setText(String.valueOf(expResult));
        }
//        if (value.contains("+")){
//            operators=value.split("\\+");
//            textField.setText(
//                    String.valueOf(
//                            Float.parseFloat(operators[0] )+ Float.parseFloat(operators[1])
//                    )
//            );
//        }else if (value.contains("-")){
//            operators=value.split("-");
//            textField.setText(
//                    String.valueOf(
//                            Float.parseFloat(operators[0] )- Float.parseFloat(operators[1])
//                    )
//            );
//        }else if (value.contains("*")){
//            operators=value.split("\\*");
//            textField.setText(
//                    String.valueOf(
//                            Float.parseFloat(operators[0]) * Float.parseFloat(operators[1])
//                    )
//            );
//        } else if (value.contains("^")){
//            operators=value.split("\\^");
//            textField.setText(
//                    String.valueOf(
//                            Math.pow(Float.parseFloat(operators[0]),Float.parseFloat(operators[1]))
//                    )
//            );
//        }else if (value.contains("/")){
//            operators=value.split("/");
//            textField.setText(
//                    String.valueOf(
//                            Float.parseFloat(operators[0])/Float.parseFloat(operators[1])
//                    )
//            );
//        }
    }
}
