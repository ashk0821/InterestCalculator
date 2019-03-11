package IntroductionCS.u12.day02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterestCalculator extends JFrame {
    JTextField textInvestment = new JTextField(8);
    JTextField textYears = new JTextField(8);
    JTextField textInterest = new JTextField(8);
    JTextField textValue = new JTextField(8);
    JButton calculate = new JButton("Calculate!");

    public InterestCalculator(){
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4,2));
        p1.add(new JLabel("Investment Amount"));
        p1.add(textInvestment);

        p1.add(new JLabel("Years"));
        p1.add(textYears);

        p1.add(new JLabel("Annual Rate"));
        p1.add(textInterest);

        p1.add(new JLabel("Future Value"));
        textValue.setEditable(false);
        p1.add(textValue);


        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(calculate, BorderLayout.EAST);

        JPanel p2 = new JPanel();
        p2.add(calculate);
        add(p2, BorderLayout.EAST);
        calculate.addActionListener(new CalcButtonListener());
    }

    class CalcButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = Double.parseDouble(textInvestment.getText());
                double r = Double.parseDouble(textInterest.getText());
                double t = Double.parseDouble(textYears.getText());

                double result = p * Math.pow(1 + r / 100, t);
                textValue.setText(String.format("%.2f", result));
            }
            catch (Exception ex){
                textValue.setText("Error!");
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new InterestCalculator();
        frame.setTitle("Calculator");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
