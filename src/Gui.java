import javax.swing.*;

public class Gui extends Calculator {
    private JPanel panel0;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JTextField textField;
    private JButton button_add;
    private JButton button_sub;
    private JButton button_mul;
    private JButton button_div;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
    private JButton button_5;
    private JButton button_6;
    private JButton button_7;
    private JButton button_C;
    private JButton button_8;
    private JButton button_9;
    private JButton button_0;
    private JButton button_equal;

    public Gui() {
        button_add.addActionListener(e -> {
            update('+');
            machine();
            textField.setText(output());
        });
        button_sub.addActionListener(e -> {
            update('-');
            machine();
            textField.setText(output());
        });
        button_mul.addActionListener(e -> {
            update('*');
            machine();
            textField.setText(output());
        });
        button_div.addActionListener(e -> {
            update('/');
            machine();
            textField.setText(output());
        });
        button_1.addActionListener(e -> {
            update('1');
            machine();
            textField.setText(output());
        });
        button_2.addActionListener(e -> {
            update('2');
            machine();
            textField.setText(output());
        });
        button_3.addActionListener(e -> {
            update('3');
            machine();
            textField.setText(output());
        });
        button_4.addActionListener(e -> {
            update('4');
            machine();
            textField.setText(output());
        });
        button_5.addActionListener(e -> {
            update('5');
            machine();
            textField.setText(output());
        });
        button_6.addActionListener(e -> {
            update('6');
            machine();
            textField.setText(output());
        });
        button_7.addActionListener(e -> {
            update('7');
            machine();
            textField.setText(output());
        });
        button_8.addActionListener(e -> {
            update('8');
            machine();
            textField.setText(output());
        });
        button_9.addActionListener(e -> {
            update('9');
            machine();
            textField.setText(output());
        });
        button_0.addActionListener(e -> {
            update('0');
            machine();
            textField.setText(output());
        });
        button_C.addActionListener(e -> {
            clear();
            textField.setText(output());
        });
        button_equal.addActionListener(e -> {
            update('=');
            machine();
            textField.setText(output());
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Gui().panel0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
