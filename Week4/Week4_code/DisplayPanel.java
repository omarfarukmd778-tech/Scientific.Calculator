import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DisplayPanel extends JFrame {

    private JLabel display;
    private JLabel historyLabel;
    private JLabel statusLabel;

    private final Color BG_PANEL = new Color(39, 39, 42);
    private final Color TEXT_MAIN = new Color(250, 250, 250);
    private final Color TEXT_MUTED = new Color(161, 161, 170);
    private final Color ACCENT_RED = new Color(239, 68, 68);

    public DisplayPanel() {

        setTitle("Display Panel");
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(buildDisplay());

        setVisible(true);
    }

    private JPanel buildDisplay() {

        JPanel p = new JPanel(new BorderLayout(0, 5));
        p.setBackground(BG_PANEL);
        p.setBorder(new EmptyBorder(15, 20, 15, 20));

        historyLabel = new JLabel(" ");
        historyLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        historyLabel.setForeground(TEXT_MUTED);
        historyLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        display = new JLabel("0");
        display.setFont(new Font("Consolas", Font.BOLD, 46));
        display.setForeground(TEXT_MAIN);
        display.setHorizontalAlignment(SwingConstants.RIGHT);

        statusLabel = new JLabel("POWER OFF");
        statusLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
        statusLabel.setForeground(ACCENT_RED);

        p.add(historyLabel, BorderLayout.NORTH);
        p.add(display, BorderLayout.CENTER);
        p.add(statusLabel, BorderLayout.SOUTH);

        return p;
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        SwingUtilities.invokeLater(() -> new DisplayPanel());
    }
}