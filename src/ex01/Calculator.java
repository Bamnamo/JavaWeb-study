package ex01;

import com.sun.org.apache.xml.internal.security.Init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private static float USD_RATE = 1124.70F;
    private static float JPY_RATE = 10.113F;
    private static float CNY_RATE = 163.30F;
    private static float GBP_RATE = 1444.35F;
    private static float EUR_RATE = 1295.97F;

    JLabel title = new JLabel("달러");
    JTextField operand1 = new JTextField(10);
    String[] opExpression = {"선택", "달러", "엔화", "위안", "파운드", "유로"};
    JComboBox<String> opSelection = new JComboBox<String>(opExpression);
    JTextField txtResult = new JTextField(10);
    JButton btnClear = new JButton("다시입력");

    public Calculator() {
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void startFrame() {
        opSelection.addActionListener(new SelectionHandler());
        btnClear.addActionListener(new SelectionHandler());

    }

    class SelectionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == opSelection) {
                calulator();
            } else if (e.getSource() == btnClear) {
                init();
            }
        }
    }


    private void calulator() {
        float won = Float.parseFloat(operand1.getText());
        String result = null;
        String operator = opSelection.getSelectedItem().toString();
        if (operator.equals("달러")) {
            result = String.format("%.6f", won / USD_RATE);
        } else if (operator.equals("엔화")) {
            result = String.format("%.6f", won / JPY_RATE);
        } else if (operator.equals("위안")) {
            result = String.format("%.6f", won / CNY_RATE);
        } else if (operator.equals("파운드")) {
            result = String.format("%.6f", won / GBP_RATE);
        } else if (operator.equals("유로")) {
            result = String.format("%.6f", won / EUR_RATE);
        }
        txtResult.setText(result);
    }

    private void init() {
        operand1.setText("");
        txtResult.setText("");
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.startFrame();
    }
}
