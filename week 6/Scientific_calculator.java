import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Scientific_calculator extends JFrame {

    private boolean isOn = false;
    private String currentInput = "0";
    private double firstOperand = 0;
    private String operator = "";
    private double lastAnswer = 0;
    private boolean newInput = false;
    private boolean resultDone = false;

    private JLabel display;
    private JLabel historyLabel;
    private JLabel statusLabel;
    private JToggleButton powerBtn;

    private final Color BG_DARK = new Color(24, 24, 27);
    private final Color BG_PANEL = new Color(39, 39, 42);
    private final Color TEXT_MAIN = new Color(250, 250, 250);
    private final Color TEXT_MUTED = new Color(161, 161, 170);
    private final Color ACCENT_BLUE = new Color(14, 165, 233);
    private final Color ACCENT_RED = new Color(239, 68, 68);
    private final Color ACCENT_GREEN = new Color(34, 197, 94);
    private final Color ACCENT_ORANGE = new Color(249, 115, 22);

    public Scientific_calculator() {
        setTitle("Scientific Calculator - CSE 2110");
        setSize(340, 530);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(0, 0));
        getContentPane().setBackground(BG_DARK);
        add(buildHeader(), BorderLayout.NORTH);
        add(buildDisplay(), BorderLayout.CENTER);
        add(buildButtons(), BorderLayout.SOUTH);
        setCalcState(false);
        setVisible(true);
    }

    private JPanel buildHeader() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(BG_DARK);
        p.setBorder(new EmptyBorder(6, 8, 6, 8));

        JPanel info = new JPanel(new BorderLayout(0, 2));
        info.setBackground(BG_DARK);

        JLabel title = new JLabel("SCIENTIFIC CALCULATOR");
        title.setFont(new Font("Segoe UI", Font.BOLD, 12));
        title.setForeground(TEXT_MAIN);

        JLabel sub = new JLabel("CSE 2110 | Md Omor Faruk | 11240321755");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 8));
        sub.setForeground(TEXT_MUTED);

        info.add(title, BorderLayout.NORTH);
        info.add(sub, BorderLayout.SOUTH);

        powerBtn = new JToggleButton("ON");
        powerBtn.setFont(new Font("Segoe UI", Font.BOLD, 10));
        powerBtn.setForeground(Color.WHITE);
        powerBtn.setBackground(ACCENT_GREEN);
        powerBtn.setOpaque(true);
        powerBtn.setFocusPainted(false);
        powerBtn.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        powerBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        powerBtn.addActionListener(e -> togglePower());

        p.add(info, BorderLayout.CENTER);
        p.add(powerBtn, BorderLayout.EAST);

        return p;
    }

    private JPanel buildDisplay() {
        JPanel p = new JPanel(new BorderLayout(0, 3));
        p.setBackground(BG_PANEL);
        p.setBorder(new EmptyBorder(7, 9, 7, 9));

        historyLabel = new JLabel(" ");
        historyLabel.setFont(new Font("Consolas", Font.PLAIN, 10));
        historyLabel.setForeground(TEXT_MUTED);
        historyLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        display = new JLabel("0");
        display.setFont(new Font("Consolas", Font.BOLD, 32));
        display.setForeground(TEXT_MAIN);
        display.setHorizontalAlignment(SwingConstants.RIGHT);

        statusLabel = new JLabel("POWER OFF");
        statusLabel.setFont(new Font("Segoe UI", Font.BOLD, 8));
        statusLabel.setForeground(ACCENT_RED);

        p.add(historyLabel, BorderLayout.NORTH);
        p.add(display, BorderLayout.CENTER);
        p.add(statusLabel, BorderLayout.SOUTH);

        return p;
    }

    private JPanel buildButtons() {
        JPanel p = new JPanel(new GridLayout(7, 5, 3, 3));
        p.setBorder(new EmptyBorder(6, 6, 8, 6));
        p.setBackground(BG_DARK);

        Color funcBg = new Color(63, 63, 70);
        Color numBg = new Color(82, 82, 91);
        Color opBg = ACCENT_ORANGE;
        Color clearBg = ACCENT_RED;
        Color spBg = ACCENT_BLUE;

        p.add(mkBtn("sin", funcBg, TEXT_MAIN));
        p.add(mkBtn("cos", funcBg, TEXT_MAIN));
        p.add(mkBtn("tan", funcBg, TEXT_MAIN));
        p.add(mkBtn("log", funcBg, TEXT_MAIN));
        p.add(mkBtn("ln", funcBg, TEXT_MAIN));

        p.add(mkBtn("x²", funcBg, TEXT_MAIN));
        p.add(mkBtn("√", funcBg, TEXT_MAIN));
        p.add(mkBtn("x^y", funcBg, TEXT_MAIN));
        p.add(mkBtn("1/x", funcBg, TEXT_MAIN));
        p.add(mkBtn("%", funcBg, TEXT_MAIN));

        p.add(mkBtn("AC", clearBg, TEXT_MAIN));
        p.add(mkBtn("CE", spBg, TEXT_MAIN));
        p.add(mkBtn("⌫", spBg, TEXT_MAIN));
        p.add(mkBtn("( )", spBg, TEXT_MAIN));
        p.add(mkBtn("÷", opBg, TEXT_MAIN));

        p.add(mkBtn("7", numBg, TEXT_MAIN));
        p.add(mkBtn("8", numBg, TEXT_MAIN));
        p.add(mkBtn("9", numBg, TEXT_MAIN));
        p.add(mkBtn("π", funcBg, TEXT_MAIN));
        p.add(mkBtn("×", opBg, TEXT_MAIN));

        p.add(mkBtn("4", numBg, TEXT_MAIN));
        p.add(mkBtn("5", numBg, TEXT_MAIN));
        p.add(mkBtn("6", numBg, TEXT_MAIN));
        p.add(mkBtn("e", funcBg, TEXT_MAIN));
        p.add(mkBtn("−", opBg, TEXT_MAIN));

        p.add(mkBtn("1", numBg, TEXT_MAIN));
        p.add(mkBtn("2", numBg, TEXT_MAIN));
        p.add(mkBtn("3", numBg, TEXT_MAIN));
        p.add(mkBtn("±", spBg, TEXT_MAIN));
        p.add(mkBtn("+", opBg, TEXT_MAIN));

        p.add(mkBtn("0", numBg, TEXT_MAIN));
        p.add(mkBtn(".", numBg, TEXT_MAIN));
        p.add(mkBtn("ANS", spBg, TEXT_MAIN));

        JButton spacer = mkBtn("", BG_DARK, BG_DARK);
        spacer.setEnabled(false);
        spacer.setBorderPainted(false);
        p.add(spacer);

        p.add(mkBtn("=", ACCENT_GREEN, TEXT_MAIN));

        return p;
    }

    private JButton mkBtn(String label, Color bg, Color fg) {
        JButton b = new JButton(label);

        boolean isNum = label.matches("[0-9]");
        boolean isOp = label.matches("[+−×÷=x^y]");

        int fontSize = isNum ? 18 : (isOp ? 18 : 12);

        b.setFont(new Font("Segoe UI", Font.BOLD, fontSize));
        b.setForeground(fg);
        b.setBackground(bg);
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        if (!label.isEmpty()) {
            b.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    if (isOn) {
                        b.setBackground(bg.brighter());
                    }
                }

                public void mouseExited(MouseEvent e) {
                    b.setBackground(bg);
                }
            });

            b.addActionListener(e -> handle(label));
        }

        return b;
    }

    private void togglePower() {
        isOn = !isOn;
        setCalcState(isOn);
    }

    private void setCalcState(boolean on) {
        isOn = on;

        if (on) {
            currentInput = "0";
            operator = "";
            firstOperand = 0;
            newInput = false;
            resultDone = false;

            display.setText("0");
            display.setForeground(TEXT_MAIN);
            historyLabel.setText(" ");
            statusLabel.setText("READY");
            statusLabel.setForeground(ACCENT_GREEN);

            powerBtn.setText("OFF");
            powerBtn.setBackground(ACCENT_RED);
        } else {
            currentInput = "0";
            display.setText("---");
            display.setForeground(TEXT_MUTED);
            historyLabel.setText(" ");
            statusLabel.setText("POWER OFF");
            statusLabel.setForeground(ACCENT_RED);

            powerBtn.setText("ON");
            powerBtn.setBackground(ACCENT_GREEN);
        }
    }

    private void handle(String cmd) {
        if (!isOn) return;

        try {
            if (cmd.matches("[0-9]")) {

                if (resultDone || newInput) {
                    currentInput = cmd;
                    newInput = false;
                    resultDone = false;
                } else if (currentInput.equals("0")) {
                    currentInput = cmd;
                } else {
                    currentInput += cmd;
                }

                updateDisplay();
                return;
            }

            switch (cmd) {

                case ".":

                    if (resultDone || newInput) {
                        currentInput = "0.";
                        newInput = false;
                        resultDone = false;
                    } else if (!currentInput.contains(".")) {
                        currentInput += ".";
                    }

                    break;

                case "AC":

                    currentInput = "0";
                    operator = "";
                    firstOperand = 0;
                    newInput = false;
                    resultDone = false;
                    historyLabel.setText(" ");
                    statusLabel.setText("READY");

                    break;

                case "CE":

                    currentInput = "0";
                    newInput = false;

                    break;

                case "⌫":

                    if (currentInput.length() > 1) {
                        currentInput =
                            currentInput.substring(
                                0,
                                currentInput.length() - 1
                            );
                    } else {
                        currentInput = "0";
                    }

                    break;

                case "±":

                    currentInput =
                        fmt(-Double.parseDouble(currentInput));

                    break;

                case "π":

                    currentInput = fmt(Math.PI);
                    historyLabel.setText("π");
                    newInput = false;
                    resultDone = false;

                    break;

                case "e":

                    currentInput = fmt(Math.E);
                    historyLabel.setText("e");
                    newInput = false;
                    resultDone = false;

                    break;

                case "ANS":

                    currentInput = fmt(lastAnswer);
                    historyLabel.setText("ANS");
                    newInput = false;
                    resultDone = false;

                    break;

                case "+":
                case "−":
                case "×":
                case "÷":

                    if (!operator.isEmpty() && !newInput) {
                        pendingCalc();
                    } else {
                        firstOperand =
                            Double.parseDouble(currentInput);
                    }

                    operator = cmd;

                    historyLabel.setText(
                        fmt(firstOperand) + " " + cmd
                    );

                    newInput = true;
                    resultDone = false;
                    statusLabel.setText("OP: " + cmd);

                    break;

                case "=":

                    if (operator.isEmpty()) {
                        break;
                    }

                    double b =
                        Double.parseDouble(currentInput);

                    double res =
                        calcBinary(
                            firstOperand,
                            b,
                            operator
                        );

                    historyLabel.setText(
                        fmt(firstOperand)
                        + " "
                        + operator
                        + " "
                        + fmt(b)
                        + " ="
                    );

                    lastAnswer = res;
                    currentInput = fmt(res);

                    operator = "";
                    newInput = false;
                    resultDone = true;

                    statusLabel.setText("RESULT");

                    break;
            }

        } catch (Exception ex) {
            currentInput = "Error";
        }

        updateDisplay();
    }

    private void pendingCalc() {
        try {
            double b =
                Double.parseDouble(currentInput);

            firstOperand =
                calcBinary(
                    firstOperand,
                    b,
                    operator
                );

            currentInput = fmt(firstOperand);

        } catch (Exception ignore) {}
    }

    private double calcBinary(
        double a,
        double b,
        String op
    ) {

        switch (op) {

            case "+":
                return a + b;

            case "−":
                return a - b;

            case "×":
                return a * b;

            case "÷":
                return b == 0
                    ? errVal("Div/0")
                    : a / b;

            default:
                return b;
        }
    }

    private double errVal(String msg) {

        currentInput = msg;
        updateDisplay();
        display.setForeground(ACCENT_RED);

        new Timer(1800, e -> {

            display.setForeground(TEXT_MAIN);
            currentInput = "0";
            operator = "";
            newInput = true;

            updateDisplay();

        }) {{

            setRepeats(false);
            start();

        }};

        return 0;
    }

    private void updateDisplay() {

        String txt =
            currentInput.isEmpty()
                ? "0"
                : currentInput;

        int len = txt.length();

        int size =
            len > 14 ? 18 :
            len > 10 ? 23 :
            len > 7 ? 28 :
            32;

        display.setFont(
            new Font(
                "Consolas",
                Font.BOLD,
                size
            )
        );

        display.setText(txt);
    }

    private String fmt(double v) {

        if (Double.isInfinite(v))
            return "Inf";

        if (Double.isNaN(v))
            return "NaN";

        if (v == Math.floor(v)
                && Math.abs(v) < 1e15) {

            return String.valueOf((long) v);
        }

        String s =
            String.format("%.10g", v);

        if (s.contains(".")
                && !s.contains("e")) {

            s = s
                .replaceAll("0+$", "")
                .replaceAll("\\.$", "");
        }

        return s;
    }

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                UIManager
                    .getSystemLookAndFeelClassName()
            );

        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(
            Scientific_calculator::new
        );
    }
}