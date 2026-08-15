import javax.swing.*;
import java.awt.*;

public class ThemeStyling extends JFrame {

    private final Color BG_DARK = new Color(24, 24, 27);
    private final Color BG_PANEL = new Color(39, 39, 42);
    private final Color TEXT_MAIN = new Color(250, 250, 250);
    private final Color TEXT_MUTED = new Color(161, 161, 170);
    private final Color ACCENT_BLUE = new Color(14, 165, 233);
    private final Color ACCENT_RED = new Color(239, 68, 68);
    private final Color ACCENT_GREEN = new Color(34, 197, 94);
    private final Color ACCENT_ORANGE = new Color(249, 115, 22);

    public ThemeStyling() {

        setTitle("Theme & Styling");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(BG_DARK);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBackground(BG_PANEL);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton add = createButton("+", ACCENT_ORANGE);
        JButton equal = createButton("=", ACCENT_GREEN);
        JButton clear = createButton("AC", ACCENT_RED);
        JButton scientific = createButton("sin", ACCENT_BLUE);

        panel.add(add);
        panel.add(equal);
        panel.add(clear);
        panel.add(scientific);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton createButton(String text, Color bg) {

        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setBackground(bg);
        button.setForeground(TEXT_MAIN);
        button.setFocusPainted(false);
        button.setBorderPainted(false);

        return button;
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        SwingUtilities.invokeLater(() -> new ThemeStyling());
    }
}